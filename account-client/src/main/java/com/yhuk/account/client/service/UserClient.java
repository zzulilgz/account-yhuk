package com.yhuk.account.client.service;

import com.yhuk.account.object.response.UserRolesBo;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description account-restapi客户端
 * @Author gaozhi.liu
 * @Date 2019/4/29 18:13
 * @Version 1.0
 **/
@FeignClient(serviceId = "account-restapi",path = "/account/powerUser")
public interface UserClient {
    /**
     * 根据用户名获取用户权限
     * @param loginName
     * @return
     */
    @GetMapping("/name/{login}")
    Response<UserRolesBo> findByLogin(@PathVariable("login") String loginName);

}
