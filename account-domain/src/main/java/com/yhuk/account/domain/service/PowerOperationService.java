package com.yhuk.account.domain.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yhuk.account.domain.entity.PowerOperation;
import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.ResourceBo;

import java.util.List;

/**
 * <p>
 * 操作表，button,href等 服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerOperationService extends IService<PowerOperation> {

    IPage find(ListByPageQo reqQo);

    /**
     * 获取角色权限
     * @param roleId
     * @return
     */
    List<ResourceBo> findByRole(Integer roleId);

    List<PowerOperation> getAvailableSubMenuByRoleIds(List<String> roleIds);

    List<PowerOperation> findBySubMenuIds(String[] subMenuIds);
}
