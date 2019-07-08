package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerMenu;
import com.yhuk.account.domain.dao.PowerMenuDao;
import com.yhuk.account.domain.service.PowerMenuService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhuk.account.object.response.MenuTreeBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    @Override
    public IPage find(ListByPageQo reqQo) {
        QueryWrapper<PowerMenu> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper, reqQo, "create_time");

        return mapper.selectPage(initPage(reqQo), queryWrapper);
    }

    @Override
    public MenuTreeBo getTreeMenu() {
        MenuTreeBo menuTreeBo = new MenuTreeBo(); //最顶级父级菜单
        menuTreeBo.setId(-1);
        menuTreeBo.setLabel("所有菜单");
        recursion(menuTreeBo);
        return menuTreeBo;
    }

    /**
     * 递归封装菜单
     * @param menuTreeBo
     */
    private void recursion(MenuTreeBo menuTreeBo) {
        QueryWrapper<PowerMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", menuTreeBo.getId());
        List<PowerMenu> powerMenus = mapper.selectList(queryWrapper);

        if (CollectionUtils.isEmpty(powerMenus)) {
            return;
        }
        for (PowerMenu powerMenu : powerMenus) {
            MenuTreeBo children = new MenuTreeBo();
            children.setId(powerMenu.getId());
            children.setLabel(powerMenu.getName());
            menuTreeBo.getChildren().add(children);
            recursion(children);
        }
    }
}
