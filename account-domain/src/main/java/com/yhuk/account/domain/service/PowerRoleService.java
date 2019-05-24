package com.yhuk.account.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yhuk.account.domain.entity.PowerRole;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.RoleBo;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerRoleService extends IService<PowerRole> {

    IPage find(ListByPageQo reqQo);

    /**
     * 更具用户获取Role
     * @param userId
     * @return
     */
    List<RoleBo> findByUser(Integer userId);

    List<RoleBo> findList();
}
