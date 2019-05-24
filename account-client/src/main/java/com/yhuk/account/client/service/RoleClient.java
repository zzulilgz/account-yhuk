package com.yhuk.account.client.service;

import com.yhuk.account.object.response.RoleBo;
import com.yhuk.account.object.utils.ResponseUtils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/24 10:38
 * @Version 1.0
 **/
@FeignClient(serviceId = "account-restapi",path = "/account/role")
public interface RoleClient {

    /*
     * 获取所有角色所具备的权限
     */
    @GetMapping("/list/roleResource")
    Response<List<RoleBo>> findList();

}
