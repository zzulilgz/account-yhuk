package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerMenu;
import com.yhuk.account.domain.dao.PowerMenuDao;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.service.PowerMenuService;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhuk.account.object.response.MenuTreeBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;


/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerMenuServiceImpl extends BaseServiceImpl<PowerMenuDao, PowerMenu> implements PowerMenuService {

    @Autowired
    PowerMenuDao mapper;
    @Autowired
    private PowerOperationService operationService;

    @Override
    public IPage find(ListByPageQo reqQo) {
        QueryWrapper<PowerMenu> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper, reqQo, "create_time");

        return mapper.selectPage(initPage(reqQo), queryWrapper);
    }

    @Override
    public MenuTreeBo getTreeMenu(Boolean addOperation) {
        MenuTreeBo menuTreeBo = new MenuTreeBo(); //最顶级父级菜单
        menuTreeBo.setId("-1");
        menuTreeBo.setLabel("所有菜单");
        recursion(menuTreeBo,addOperation);
        return menuTreeBo;
    }

    /**
     * 递归封装菜单
     * @param menuTreeBo
     * @param addOperation 是否添加页节点
     */
    private void recursion(MenuTreeBo menuTreeBo,Boolean addOperation) {
        QueryWrapper<PowerMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", menuTreeBo.getId());
        List<PowerMenu> powerMenus = mapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(powerMenus)) {
            if(!addOperation){ //不添加页节点
                return;
            }
            setOperations(menuTreeBo);
            return;
        }
        for (PowerMenu powerMenu : powerMenus) {
            MenuTreeBo children = new MenuTreeBo();
            children.setId(powerMenu.getId().toString());
            children.setLabel(powerMenu.getName());
            children.setPath(powerMenu.getPath()); //路由地址
            menuTreeBo.getChildren().add(children);
            recursion(children,addOperation);
        }
    }

    private void setOperations(MenuTreeBo menuTreeBo) {
        String menuId = menuTreeBo.getId();
        List<PowerOperation> powerOperations = operationService.findBySubMenuIds(new String[]{menuId});

        for (PowerOperation powerOperation : powerOperations) {
            MenuTreeBo children = new MenuTreeBo();
            children.setPath(powerOperation.getPath());
            children.setLabel(powerOperation.getName());
            children.setId("sub-"+String.valueOf(powerOperation.getId()));
            menuTreeBo.getChildren().add(children);
        }
    }
}
