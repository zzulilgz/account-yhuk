package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerMenuOperation;
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
public interface PowerMenuOperationService extends IService<PowerMenuOperation> {

    IPage find(ListByPageQo reqQo);
}
