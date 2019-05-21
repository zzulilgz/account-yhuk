package com.yhuk.account.sso.service;

import com.yhuk.account.object.response.ResourceBo;
import com.yhuk.account.object.response.RoleBo;
import com.yhuk.account.object.response.UserRolesBo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
        List<MyGrantedAuthority> list = new ArrayList<>();
        for (RoleBo role : this.getRoles()) {
            List<ResourceBo> resources = role.getResources();
            for (ResourceBo resource : resources) {
                list.add(new MyGrantedAuthority(resource.getPath()));
            }
        }
        return list;
    }

    @Override
    public String getUsername() {
        return this.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
