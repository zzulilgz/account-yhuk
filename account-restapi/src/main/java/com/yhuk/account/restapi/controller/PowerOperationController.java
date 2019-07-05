package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.account.object.utils.ResponseUtils;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import com.yhuk.common.object.ResponseVO;
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
    public ResponseVO<PowerOperation> get(@PathVariable Integer id){
        PowerOperation model = service.getById(id);
        return new ResponseVO<>(model);
    }

    @PostMapping
    public ResponseVO<Integer> save(@RequestBody PowerOperation model){
        service.save(model);
        return new ResponseVO<>(model.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return new ResponseVO<>(true);
    }
    @PutMapping("/{id}")
    public ResponseVO<Boolean> update(@PathVariable Integer id,@RequestBody PowerOperation model){
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
