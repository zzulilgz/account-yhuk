package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.dao.PowerRoleOperationDao;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.entity.PowerRole;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.domain.service.PowerRoleOperationService;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.RoleBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.common.object.ResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
@Api("角色相关api")
@RestController
@RequestMapping("/role")
public class PowerRoleController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerRoleService service;
    @Autowired
    PowerOperationService powerOperationService;
    @Autowired
    PowerRoleOperationService powerRoleOperationService;

    @GetMapping("/list/roleResource")
    public ResponseVO<List<RoleBo>> listRoleResource(){
        List<RoleBo> list = service.findList();
        return new ResponseVO<>(list);
    }
    @GetMapping("/{id}")
    public ResponseVO<PowerRole> get(@PathVariable Integer id){
        PowerRole model = service.getById(id);
        return new ResponseVO<>(model);
    }
    @PostMapping
    public ResponseVO<Integer> save(@RequestBody PowerRole model){
        service.save(model);
        return new ResponseVO<>(model.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return new ResponseVO<>(true);
    }
    @PutMapping("/{id}")
    public ResponseVO<Boolean> update(@PathVariable Integer id,@RequestBody PowerRole model){
        model.setId(id);
        service.updateById(model);
        return new ResponseVO<>(true);
    }
    @PostMapping("/list")
    public ResponseVO<IPage> find(@RequestBody(required = false) ListByPageQo reqQo){
        logger.info("/list request:{}",JsonUtils.toJson(reqQo));
        return new ResponseVO<>(service.find(reqQo));
    }

//    @ApiOperation("查询角拥有的子菜单Id")
//    @GetMapping("/available/subMenu/{id}")
//    public ResponseVO<Set<String>> availableSubMenu(@PathVariable String id){
//        List<String> roleIds = new ArrayList<>();
//        roleIds.add(id);
//        List<PowerOperation> subMenuByRoleIds = powerOperationService.getAvailableSubMenuByRoleIds(roleIds);
//        Set<Integer> collect = subMenuByRoleIds.stream().map(PowerOperation::getMenuId).collect(Collectors.toSet());
//        return new ResponseVO(collect);
//    }

    @PutMapping("/{id}/subMenus")
    public ResponseVO<Boolean> updateSubMenuIds(@PathVariable String id,@RequestBody String[] subMenuIds){
        powerRoleOperationService.update(id,subMenuIds);
        return new ResponseVO<>(true);
    }

}
