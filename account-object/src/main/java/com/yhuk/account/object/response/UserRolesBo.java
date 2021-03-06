package com.yhuk.account.object.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description userRole业务层
 * @Author gaozhi.liu
 * @Date 2019/5/5 11:08
 * @Version 1.0
 **/
@Data
public class UserRolesBo {

    private Integer id;

    private String loginName;

    private String password; //密码用char存安全些

    private List<RoleBo> roles = new ArrayList<>();


}
