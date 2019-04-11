package com.yhuk.account.domain.test;

import com.yhuk.account.domain.entity.PowerUser;
import com.yhuk.account.domain.service.PowerUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/11 17:12
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    PowerUserService powerUserService;
    
    @org.junit.Test
    public void test(){
        List<PowerUser> list = powerUserService.list();
        System.out.println(list.size());
    }
}
