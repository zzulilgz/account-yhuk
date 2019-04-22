package com.yhuk.account.domain.dao;

import com.yhuk.account.domain.entity.PowerUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-11
 */
@Mapper
public interface PowerUserDao extends BaseMapper<PowerUser> {

//    @Select("SELECT * FROM power_user")
    List<PowerUser> find();
}