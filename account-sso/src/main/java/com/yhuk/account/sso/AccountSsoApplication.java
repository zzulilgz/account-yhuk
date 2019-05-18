package com.yhuk.account.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.yhuk.account")
@EnableZuulProxy
public class AccountSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountSsoApplication.class, args);
    }

}
