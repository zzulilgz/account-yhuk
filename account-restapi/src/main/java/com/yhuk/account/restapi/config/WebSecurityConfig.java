package com.yhuk.account.restapi.config;

import com.yhuk.account.domain.service.PowerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/6/28 17:59
 * @Version 1.0
 **/
@Configuration
@Order(1)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PowerRoleService powerRoleService;

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin().disable().httpBasic().disable();
        http.addFilterBefore(customFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();

    }

    @Bean
    public MyFilterSecurityInterceptor customFilter() throws Exception{
        MyFilterSecurityInterceptor customFilter = new MyFilterSecurityInterceptor();
        customFilter.setSecurityMetadataSource(securityMetadataSource());
        customFilter.setAccessDecisionManager(accessDecisionManager());
        customFilter.setAuthenticationManager(authenticationManagerBean());
        return customFilter;
    }

    @Bean
    public MyAccessDecisionManager accessDecisionManager() {
        return new MyAccessDecisionManager();
    }

    @Bean
    public MySecurityMetadataSource securityMetadataSource() {
        return new MySecurityMetadataSource(powerRoleService);
    }
}
