package com.yhuk.account.restapi.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description TODO
 * @Author gaozhi.liu
 * @Date 2019/7/5 15:33
 * @Version 1.0
 **/
@Configuration
@MapperScan("com.yhuk.account.*.dao")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


    @Bean
    public PerformanceInterceptor performanceInterceptor() {

        PerformanceInterceptor performanceInterceptor =new PerformanceInterceptor();

        //格式化sql语句
        Properties properties =new Properties();
        properties.setProperty("format", "faalse");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;

    }

}
