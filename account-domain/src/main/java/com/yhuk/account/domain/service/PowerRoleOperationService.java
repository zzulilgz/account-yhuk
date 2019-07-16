package com.yhuk.account.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yhuk.account.domain.entity.PowerRoleOperation;
import com.yhuk.account.object.request.ListByPageQo;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerRoleOperationService extends IService<PowerRoleOperation> {

    IPage find(ListByPageQo reqQo);

    /**
     * 更新角色的子菜单权限
     * @param id
     * @param subMenuIds
     */
    void update(String id, String[] subMenuIds);
}
