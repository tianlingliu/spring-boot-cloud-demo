package com.aibaoxian.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication(exclude = MybatisAutoConfiguration.class)
@ServletComponentScan
@MapperScan("com.aibaoxian.auth.mapper")
//@EnableAutoConfiguration
public class AuthDBRWApplication {


    /**
     * 启动入口
     *
     * @param args
     */
    public static void main(String... args) {
        SpringApplication.run(AuthDBRWApplication.class, args);
    }


}
