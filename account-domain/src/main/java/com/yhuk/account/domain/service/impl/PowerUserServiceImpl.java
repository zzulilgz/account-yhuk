package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerRole;
import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.dao.PowerUserDao;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.domain.service.PowerUserService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhuk.account.object.response.RoleBo;
import com.yhuk.account.object.response.UserRolesBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerUserServiceImpl extends BaseServiceImpl<PowerUserDao, PowerUser> implements PowerUserService {

    @Autowired
    PowerUserDao mapper;

    @Autowired
    PowerRoleService powerRoleService;

    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerUser> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo), queryWrapper);
    }

    @Override
    public UserRolesBo findResourceByLoginName(String loginName){
        Assert.hasText(loginName,"登录名不能为空");
        UserRolesBo userRolesBo = new UserRolesBo();


        QueryWrapper<PowerUser> userQueryWrapper =  new QueryWrapper<>();
        userQueryWrapper.eq("login_name",loginName);

        PowerUser powerUser = mapper.selectOne(userQueryWrapper);
        List<RoleBo> byUser = powerRoleService.findByUser(powerUser.getId());
        userRolesBo.setLoginName(loginName);
        userRolesBo.setPassword(powerUser.getPassword());
        userRolesBo.setRoles(byUser);

        return userRolesBo;
    }

}
