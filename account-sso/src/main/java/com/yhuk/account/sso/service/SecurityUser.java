package com.yhuk.account.sso.service;

import com.yhuk.account.object.response.UserRolesBo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/29 16:41
 * @Version 1.0
 **/
public class SecurityUser extends UserRolesBo implements UserDetails {

    public SecurityUser(UserRolesBo user) {
        if(user!=null){
            BeanUtils.copyProperties(user,this);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
