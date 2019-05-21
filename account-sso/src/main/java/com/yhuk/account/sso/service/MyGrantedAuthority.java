package com.yhuk.account.sso.service;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/5/21 17:30
 * @Version 1.0
 **/
public class MyGrantedAuthority implements GrantedAuthority {

    private String access_path;

    public MyGrantedAuthority(String path) {
        this.access_path = path;

    }

    @Override
    public String getAuthority() {
        return this.access_path;
    }

    public String getAccess_path() {
        return access_path;
    }

    public void setAccess_path(String access_path) {
        this.access_path = access_path;
    }
}
