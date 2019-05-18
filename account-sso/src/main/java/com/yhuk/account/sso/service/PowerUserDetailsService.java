package com.yhuk.account.sso.service;

import com.yhuk.account.client.service.UserClient;
import com.yhuk.account.object.response.UserRolesBo;
import com.yhuk.account.object.utils.JsonUtils;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/7 13:55
 * @Version 1.0
 **/
@Component
public class PowerUserDetailsService implements UserDetailsService {
    public static final Logger logger = LoggerFactory.getLogger(PowerUserDetailsService.class);

    @Autowired
    UserClient userClient;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        logger.info("loadUserByUsername:{}",loginName);

        Response<UserRolesBo> userRoleRes = userClient.findByLogin(loginName);
        logger.info("UserRolesBo：{}",JsonUtils.toJson(userRoleRes));
        UserRolesBo userRolesBo = userRoleRes.getData();
        if (userRolesBo == null) {
            throw new UsernameNotFoundException("LoginName " + loginName + " not found");
        }
        return new SecurityUser(userRolesBo);
    }

}
