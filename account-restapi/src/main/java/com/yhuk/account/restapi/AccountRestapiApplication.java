package com.yhuk.account.restapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.yhuk.account.mapping"})
public class AccountRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountRestapiApplication.class, args);
    }

}
