package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerMenu;
import com.yhuk.account.domain.service.PowerMenuService;
import com.yhuk.account.domain.utils.JsonUtils;
import com.yhuk.account.restapi.utils.ResponseUtils;
import com.yhuk.account.restapi.utils.ResponseUtils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yhuk.account.object.request.ListByPageQo;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Controller
@RequestMapping("/powerMenu")
public class PowerMenuController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerMenuService service;

    @GetMapping("/{id}")
    public Response<PowerMenu> get(@PathVariable Integer id){
        PowerMenu model = service.getById(id);
        return ResponseUtils.getSuccessJson(model);
    }
    @PostMapping
    public Response<Integer> save(@RequestBody PowerMenu model){
        service.save(model);
        return ResponseUtils.getSuccessJson(model.getId());
    }
    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return ResponseUtils.getSuccessJson(true);
    }
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Integer id,@RequestBody PowerMenu model){
        model.setId(id);
        service.updateById(model);
        return ResponseUtils.getSuccessJson(true);
    }
    @PostMapping("/list")
    public Response<IPage> find(@RequestBody(required = false) ListByPageQo reqQo){
        logger.info("/list request:{}",JsonUtils.toJson(reqQo));
        return ResponseUtils.getSuccessJson(service.find(reqQo));
    }
}