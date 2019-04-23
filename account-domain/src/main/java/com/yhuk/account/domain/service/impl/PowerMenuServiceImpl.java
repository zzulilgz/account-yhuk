package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerMenu;
import com.yhuk.account.domain.dao.PowerMenuDao;
import com.yhuk.account.domain.service.PowerMenuService;
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
public class PowerMenuServiceImpl extends BaseServiceImpl<PowerMenuDao, PowerMenu> implements PowerMenuService {

    @Autowired
    PowerMenuDao mapper;

    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerMenu> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo),queryWrapper);
    }

}
