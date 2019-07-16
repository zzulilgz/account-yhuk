package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yhuk.account.object.request.ListByPageQo;
import com.yhuk.account.object.response.MenuTreeBo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-23
 */
public interface PowerMenuService extends IService<PowerMenu> {
    /**
     * 分页查找
     * @param reqQo
     * @return
     */
    IPage find(ListByPageQo reqQo);

    /**
     *
     * @param addOperation 是否显示operation
     * @return
     */
    MenuTreeBo getTreeMenu(Boolean addOperation);
}
