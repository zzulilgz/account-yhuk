package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yhuk.account.object.request.ListByPageQo;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerRoleMenuService extends IService<PowerRoleMenu> {

    IPage find(ListByPageQo reqQo);
}
