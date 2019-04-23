package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerRoleMenu;
import com.yhuk.account.domain.dao.PowerRoleMenuDao;
import com.yhuk.account.domain.service.PowerRoleMenuService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerRoleMenuServiceImpl extends BaseServiceImpl<PowerRoleMenuDao, PowerRoleMenu> implements PowerRoleMenuService {

    @Autowired
    PowerRoleMenuDao mapper;

    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerRoleMenu> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo),queryWrapper);
    }

}
