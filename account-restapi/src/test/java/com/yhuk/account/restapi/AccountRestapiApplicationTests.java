package com.yhuk.account.restapi;

import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.service.PowerUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRestapiApplicationTests {

    @Autowired
    PowerUserService userService;
    @Test
    public void contextLoads() {
        List<PowerUser> list = userService.list();
        System.out.println(list.toString());
    }
    

}
