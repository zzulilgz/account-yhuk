package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerRole;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.RoleBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.common.object.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/role")
public class PowerRoleController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerRoleService service;

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

}
