package com.yhuk.account.domain.service;

import com.yhuk.account.domain.entity.PowerOperation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import com.yhuk.account.object.request.ListByPageQo;
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
}
