package com.yhuk.account.restapi.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.entity.PowerMenu;
import com.yhuk.account.domain.service.PowerMenuService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.MenuTreeBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.common.object.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**
 * <p>
 *  菜单前端控制器
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/menu")
public class PowerMenuController {
    private static Logger logger = LoggerFactory.getLogger("web");

	@Autowired
    PowerMenuService service;

    @GetMapping("/{id}")
    public ResponseVO<PowerMenu> get(@PathVariable Integer id){
        PowerMenu model = service.getById(id);
        return new ResponseVO<>(model);
    }
    @PostMapping
    public ResponseVO<Integer> save(@RequestBody PowerMenu model){
        service.save(model);
        return new ResponseVO<>(model.getId());
    }
    @DeleteMapping("/{id}")
    public ResponseVO<Boolean> delete(@PathVariable Integer id){
        service.removeById(id);
        return new ResponseVO<>(true);
    }
    @PutMapping("/{id}")
    public ResponseVO<Boolean> update(@PathVariable Integer id,@RequestBody PowerMenu model){
        model.setId(id);
        service.updateById(model);
        return new ResponseVO<>(true);
    }
    @PostMapping("/list")
    public ResponseVO<IPage> find(@RequestBody(required = false) ListByPageQo reqQo){
        logger.info("/list request:{}", JsonUtils.toJson(reqQo));
        return new ResponseVO<>(service.find(reqQo));
    }

    /**
     * 获取树形菜单
     * @return
     */
    @GetMapping("/treeMenu")
    public ResponseVO<MenuTreeBo> findTreeMenu(){
        MenuTreeBo treeMenu = service.getTreeMenu();
        return new ResponseVO<>(treeMenu);
    }
//    @GetMapping
//    public ResponseVO<Object> findAll(){
//        logger.info("menu findAll");
//    }
}
