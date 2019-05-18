package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.domain.service.PowerUserService;

import com.yhuk.account.object.response.UserRolesBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.account.object.utils.ResponseUtils;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yhuk.account.object.request.ListByPageQo;
import org.springframework.stereotype.Controller;

import java.sql.Wrapper;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/powerUser")
public class PowerUserController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerUserService service;
    @Autowired
    PowerRoleService roleService;

    @GetMapping("/{id}")
    public Response<PowerUser> get(@PathVariable Integer id){
        PowerUser model = service.getById(id);
        model.setPassword("*****");
        return ResponseUtils.getSuccessJson(model);
    }
    @PostMapping
    public Response<Integer> save(@RequestBody PowerUser model){
        service.save(model);
        return ResponseUtils.getSuccessJson(model.getId());
    }
    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return ResponseUtils.getSuccessJson(true);
    }
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Integer id,@RequestBody PowerUser model){
        model.setId(id);
        service.updateById(model);
        return ResponseUtils.getSuccessJson(true);
    }
    @PostMapping("/list")
    public Response<IPage> find(@RequestBody(required = false) ListByPageQo reqQo){
        logger.info("/list request:{}", JsonUtils.toJson(reqQo));
        return ResponseUtils.getSuccessJson(service.find(reqQo));
    }

    @GetMapping("/name/{login}")
    public Response<UserRolesBo> findByLogin(@PathVariable("login") String loginName){
        logger.info("/name/{}",loginName);

        UserRolesBo userRolesBo= service.findResourceByLoginName(loginName);
        
        return ResponseUtils.getSuccessJson(userRolesBo);
    }


}
