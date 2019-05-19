package com.yhuk.account.client.service;

import java.lang.annotation.*;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/4/29 18:11
 * @Version 1.0
 **/
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AsyncTimed {

}
