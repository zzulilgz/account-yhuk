package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.domain.entity.PowerRoleOperation;
import com.yhuk.account.domain.dao.PowerRoleOperationDao;
import com.yhuk.account.domain.service.PowerOperationService;
import com.yhuk.account.domain.service.PowerRoleOperationService;
import com.yhuk.account.domain.service.impl.BaseServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yhuk.account.object.request.ListByPageQo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
@Service
public class PowerRoleOperationServiceImpl extends BaseServiceImpl<PowerRoleOperationDao, PowerRoleOperation> implements PowerRoleOperationService {

    @Autowired
    PowerRoleOperationDao mapper;

    @Autowired
    PowerOperationService operationService;
    @Override
    public IPage find(ListByPageQo reqQo){
        QueryWrapper<PowerRoleOperation> queryWrapper = new QueryWrapper<>();

        setQueryTimeType(queryWrapper,reqQo,"create_time");

        return mapper.selectPage(initPage(reqQo),queryWrapper);
    }

    @Override
    public void update(String id, String[] subMenuIds) {
        List<PowerOperation> bySubMenuIds = operationService.findBySubMenuIds(subMenuIds);
        List<PowerRoleOperation> list = new ArrayList<>();
        for (PowerOperation bySubMenuId : bySubMenuIds) {
            PowerRoleOperation powerRoleOperation = new PowerRoleOperation();
            powerRoleOperation.setOperationId(bySubMenuId.getId());
            powerRoleOperation.setRoleId(Integer.valueOf(id));
            list.add(powerRoleOperation);
        }
        executeUpdate(id,list);
    }
    @Transactional
    public void executeUpdate(String id, List<PowerRoleOperation> list) {
        Map<String,Object> column = new HashMap<>();
        column.put("role_id",id);
        mapper.deleteByMap(column);
        saveBatch(list);
    }
}
