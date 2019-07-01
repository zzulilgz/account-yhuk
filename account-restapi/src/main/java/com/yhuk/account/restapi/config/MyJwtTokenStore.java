package com.yhuk.account.restapi.config;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/7/1 16:13
 * @Version 1.0
 **/
public class MyJwtTokenStore extends JwtTokenStore {

    private JwtAccessTokenConverter jwtTokenEnhancer;
    /**
     * Create a JwtTokenStore with this token enhancer (should be shared with the DefaultTokenServices if used).
     *
     * @param jwtTokenEnhancer
     */
    public MyJwtTokenStore(JwtAccessTokenConverter jwtTokenEnhancer) {
        super(jwtTokenEnhancer);
        this.jwtTokenEnhancer = jwtTokenEnhancer;
    }

    @Override
    public OAuth2AccessToken readAccessToken(String tokenValue) {
        OAuth2AccessToken accessToken = super.readAccessToken(tokenValue);
        if(!accessToken.isExpired()){
            return accessToken;
        }
        OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();

        return accessToken;
    }




}
