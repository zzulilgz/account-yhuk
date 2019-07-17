package com.yhuk.account.restapi.config;

import com.yhuk.account.domain.service.PowerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/6/26 17:13
 * @Version 1.0
 **/
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private PowerRoleService powerRoleService;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .logout().disable()
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .exceptionHandling()
            .authenticationEntryPoint((request, response, authException) ->
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
            .and()
               // .addFilterAfter(new JwtTokenAuthenticationFilter(config), UsernamePasswordAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
                        "/swagger-resources","/swagger-resources/configuration/security",
                        "/swagger-ui.html","/course/coursebase/**").permitAll()
            .anyRequest().authenticated()
                .and().addFilterAfter(customFilter(), FilterSecurityInterceptor.class)
            .httpBasic().disable();
    }
    public MyFilterSecurityInterceptor customFilter() throws Exception{
        MyFilterSecurityInterceptor customFilter = new MyFilterSecurityInterceptor();
        customFilter.setSecurityMetadataSource(securityMetadataSource());
        customFilter.setAccessDecisionManager(accessDecisionManager());
        //customFilter.setAuthenticationManager(authenticationManagerBean());
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



    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore());
    }

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtTokenConverter());
    }
    @Bean
    protected JwtAccessTokenConverter jwtTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("base-yhuk");
        return jwtAccessTokenConverter;
    }



}
