package com.yhuk.account.domain.dao;

import com.yhuk.account.domain.entity.PowerUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-11
 */
public interface PowerUserDao extends BaseMapper<PowerUser> {

    List<PowerUser> find();
}