package com.yhuk.account.object.response;

import lombok.Data;

import java.util.Set;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/5 11:08
 * @Version 1.0
 **/
@Data
public class UserRolesBo {

    private String loginName;

    private String password; //密码用char存安全些

    private Set<RoleBo> roles;


}
