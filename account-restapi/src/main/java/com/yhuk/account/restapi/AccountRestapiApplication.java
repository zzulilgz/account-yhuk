package com.yhuk.account.restapi;


import com.yhuk.account.domain.service.PowerUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

//默认只扫描启动类同级的包
@ComponentScan(basePackages ={"com.yhuk.account"})
@MapperScan("com.yhuk.account.*.dao")
@RestController
public class AccountRestapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountRestapiApplication.class, args);
    }

    @Autowired
    PowerUserService userService;

    @GetMapping
    public String test(){
        System.out.println(userService.find().toString());
        return userService.list().toString();
    }

}
