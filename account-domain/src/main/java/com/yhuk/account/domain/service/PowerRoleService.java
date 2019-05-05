package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yhuk.account.object.request.ListByPageQo;

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

    List<PowerRole> findByUser(Integer userId);
}
