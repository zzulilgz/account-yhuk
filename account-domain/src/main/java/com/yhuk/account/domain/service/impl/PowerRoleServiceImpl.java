package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.dao.PowerRoleUserDao;
import com.yhuk.account.domain.entity.PowerRole;
import com.yhuk.account.domain.dao.PowerRoleDao;
import com.yhuk.account.domain.entity.PowerRoleOperation;
import com.yhuk.account.domain.entity.PowerRoleUser;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.domain.service.PowerRoleService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yhuk.account.object.response.RoleBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerRoleServiceImpl extends BaseServiceImpl<PowerRoleDao, PowerRole> implements PowerRoleService {

    @Autowired
    PowerRoleDao mapper;
    @Autowired
    PowerRoleUserDao roleUserDao;

    @Autowired
    PowerOperationService operationService;

    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerRole> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo),queryWrapper);
    }

    @Override
    public List<RoleBo> findByUser(Integer userId) {
        Assert.notNull(userId,"userId不能为空");

        List<RoleBo> roleBos = new ArrayList<>();

        QueryWrapper<PowerRoleUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",userId);
        List<PowerRoleUser> powerRoleUsers = roleUserDao.selectList(queryWrapper);

        QueryWrapper<PowerRole> roleWrapper = new QueryWrapper<>();
        roleWrapper.in("role_id",
                powerRoleUsers.stream().map(PowerRoleUser::getRoleId).collect(Collectors.toList()));
        List<PowerRole> powerRoles = mapper.selectList(roleWrapper);

        for (PowerRole powerRole : powerRoles) {
            RoleBo roleBo = new RoleBo();
            roleBo.setId(powerRole.getId());
            roleBo.setName(powerRole.getName());
            roleBo.setResources(operationService.findByRole(powerRole.getId()));

            roleBos.add(roleBo);
        }
        return roleBos;
    }

}
