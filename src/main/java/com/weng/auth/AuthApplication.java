package com.weng.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 *
 **/
@EnableSwagger2
@EnableDiscoveryClient
@EnableTransactionManagement
@MapperScan("com.weng.*.mapper.*")
@SpringBootApplication(scanBasePackages ={
        "com.weng.framework",
        "com.weng"
})
public class AuthApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
	}
}
