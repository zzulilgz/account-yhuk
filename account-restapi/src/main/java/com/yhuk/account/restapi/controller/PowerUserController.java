package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.domain.service.PowerUserService;

import com.yhuk.account.object.response.UserRolesBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.common.object.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import com.yhuk.account.object.request.ListByPageQo;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@RestController
@RequestMapping(value="/user")
public class PowerUserController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerUserService service;
	@Autowired
    PowerOperationService powerOperationService;
    @Autowired
    PowerRoleService roleService;

    /**
     * 根据登录名称获取可操作权限
     * @param loginName
     * @return
     */
    @GetMapping("/resources/{loginName}")
    public ResponseVO<UserRolesBo> getResources(@PathVariable String loginName){
        UserRolesBo userRolesBo = service.findResourceByLoginName(loginName);
        return new ResponseVO<>(userRolesBo);
    }
    @GetMapping("/id/{id}")
    public ResponseVO<PowerUser> get(@PathVariable Integer id){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(JsonUtils.toJson(authentication));
        PowerUser model = service.getById(id);
        model.setPassword("*****");
        return new ResponseVO<>(model);
    }
    @PostMapping
    public ResponseVO<Integer> save(@RequestBody PowerUser model){
        service.save(model);
        return new ResponseVO<>(model.getId());
    }
    @DeleteMapping("/id/{id}")
    public ResponseVO<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return new ResponseVO<>(true);
    }
    @PutMapping("/id/{id}")
    public ResponseVO<Boolean> update(@PathVariable Integer id,@RequestBody PowerUser model){
        model.setId(id);
        service.updateById(model);
        return new ResponseVO<>(true);
    }
    @PostMapping("/list")
    public ResponseVO<IPage> find(@RequestBody(required = false) ListByPageQo reqQo){
        logger.info("/list request:{}", JsonUtils.toJson(reqQo));
        new ResponseVO<>(service.find(reqQo));
        return new ResponseVO<>(service.find(reqQo));
    }
    @GetMapping("/available/subMenu")
    public ResponseVO<Set<Integer>> availableSubMenu(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roleIds = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        List<PowerOperation> subMenuByRoleIds = powerOperationService.getAvailableSubMenuByRoleIds(roleIds);
        Set<Integer> collect = subMenuByRoleIds.stream().map(PowerOperation::getMenuId).collect(Collectors.toSet());
        return new ResponseVO(collect);
    }

    @GetMapping("/name/{login}")
    public ResponseVO<UserRolesBo> findByLogin(@PathVariable("login") String loginName){
        logger.info("/name/{}",loginName);
        UserRolesBo userRolesBo= service.findResourceByLoginName(loginName);
        return new ResponseVO<>(userRolesBo);
    }


}
