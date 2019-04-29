package com.yhuk.account.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AccountSsoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountSsoApplication.class, args);
    }

}
