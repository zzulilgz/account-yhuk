package com.yhuk.account.domain.service.impl;

import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.dao.PowerUserDao;
import com.yhuk.account.domain.service.PowerUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzulilgz
 * @since 2019-04-11
 */
@Service
public class PowerUserServiceImpl extends ServiceImpl<PowerUserDao, PowerUser> implements PowerUserService {

    @Autowired
    PowerUserDao powerUserDao;
    @Override
    public List<PowerUser> find() {

        return powerUserDao.find();
    }
}
