package com.yhuk.account.client.service;

import com.yhuk.account.object.response.UserRolesBo;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/29 18:13
 * @Version 1.0
 **/
@FeignClient("accountapi")
public interface UserClient {

    @GetMapping("/name/{login}")
    Response<UserRolesBo> findByLogin(@PathVariable("login") String loginName);


}
