package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.account.object.utils.ResponseUtils;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 操作表，button,href等 前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/powerOperation")
public class PowerOperationController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerOperationService service;

    @GetMapping("/{id}")
    public Response<PowerOperation> get(@PathVariable Integer id){
        PowerOperation model = service.getById(id);
        return ResponseUtils.getSuccessJson(model);
    }

    @PostMapping
    public Response<Integer> save(@RequestBody PowerOperation model){
        service.save(model);
        return ResponseUtils.getSuccessJson(model.getId());
    }
    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return ResponseUtils.getSuccessJson(true);
    }
    @PutMapping("/{id}")
    public Response<Boolean> update(@PathVariable Integer id,@RequestBody PowerOperation model){
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
