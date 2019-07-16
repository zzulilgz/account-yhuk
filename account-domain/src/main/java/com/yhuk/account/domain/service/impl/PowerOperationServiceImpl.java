package com.yhuk.account.domain.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.domain.dao.PowerOperationDao;
import com.yhuk.account.domain.dao.PowerRoleOperationDao;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.entity.PowerRoleOperation;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.ResourceBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * <p>
 * 操作表，button,href等 服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerOperationServiceImpl extends BaseServiceImpl<PowerOperationDao, PowerOperation> implements PowerOperationService {

    @Autowired
    PowerOperationDao mapper;
    @Autowired
    PowerRoleOperationDao roleOperationDao;

    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerOperation> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo),queryWrapper);
    }

    @Override
    public List<ResourceBo> findByRole(Integer roleId) {
        Assert.notNull(roleId,"角色ID不能为空");

        List<ResourceBo> resourceBos = new ArrayList<>();
        //查找关联
        QueryWrapper<PowerRoleOperation> roleOperationQueryWrapper =
                new QueryWrapper<>();
        roleOperationQueryWrapper.eq("role_id",roleId);
        List<PowerRoleOperation> powerRoleOperations =
                roleOperationDao.selectList(roleOperationQueryWrapper);
        List<Integer> resourceIds = powerRoleOperations.stream().map(
                PowerRoleOperation::getOperationId).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(resourceIds)){
            return Collections.emptyList();
        }
        //查找resource
        QueryWrapper<PowerOperation> operationQueryWrapper = new QueryWrapper<>();
        operationQueryWrapper.in("id",resourceIds);
        List<PowerOperation> powerOperations = mapper.selectList(operationQueryWrapper);
        for (PowerOperation powerOperation : powerOperations) {
            ResourceBo resourceBo = new ResourceBo();
            resourceBo.setName(powerOperation.getName());
            resourceBo.setPath(powerOperation.getPath());

            resourceBos.add(resourceBo);
        }
        return resourceBos;
    }

    @Override
    public List<PowerOperation> getAvailableSubMenuByRoleIds(List<String> roleIds) {
        QueryWrapper<PowerRoleOperation> roleOperationQueryWrapper =
                new QueryWrapper<>();
        roleOperationQueryWrapper.in("role_id",roleIds);
        List<PowerRoleOperation> powerRoleOperations =
                roleOperationDao.selectList(roleOperationQueryWrapper);
        if(CollectionUtils.isEmpty(powerRoleOperations)){
            return Collections.emptyList();
        }
        List<Integer> collect = powerRoleOperations.stream().map(
                PowerRoleOperation::getOperationId).collect(Collectors.toList());

        //查询operation
        QueryWrapper<PowerOperation> operationQuery = new QueryWrapper<>();
        operationQuery.in("id",collect);

        return Optional.ofNullable(mapper.selectList(operationQuery)).orElse(
                Collections.EMPTY_LIST
        );
    }

    @Override
    public List<PowerOperation> findBySubMenuIds(String[] subMenuIds) {
        QueryWrapper<PowerOperation> roleOperationQueryWrapper =
                new QueryWrapper<>();
        roleOperationQueryWrapper.in("menu_id",subMenuIds);
        List<PowerOperation> powerOperations = mapper.selectList(roleOperationQueryWrapper);

        return powerOperations;

    }
}
