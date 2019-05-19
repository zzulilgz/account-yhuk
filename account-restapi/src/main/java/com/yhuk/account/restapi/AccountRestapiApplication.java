package com.yhuk.account.restapi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages ={"com.yhuk.account"})
@MapperScan("com.yhuk.account.*.dao")
@RestController
@EnableDiscoveryClient
public class AccountRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountRestapiApplication.class, args);
    }

}
