package com.yhuk.account.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/29 18:13
 * @Version 1.0
 **/
@FeignClient("accountapi")
public interface UserClient {




}
