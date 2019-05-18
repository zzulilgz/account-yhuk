package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.UserRolesBo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerUserService extends IService<PowerUser> {

    IPage find(ListByPageQo reqQo);

    /**
     * 根据登录名获取用户所具有的资源权限
     *
     * @param loginName
     * @return
     */
    UserRolesBo findResourceByLoginName(String loginName);
}
