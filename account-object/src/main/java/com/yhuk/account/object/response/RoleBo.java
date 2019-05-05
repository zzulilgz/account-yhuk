package com.yhuk.account.object.response;

import lombok.Data;

import java.util.Set;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/5 11:38
 * @Version 1.0
 **/
@Data
public class RoleBo {

    private Integer id;

    private String name;

    private Set<ResourceBo> resources;



}
