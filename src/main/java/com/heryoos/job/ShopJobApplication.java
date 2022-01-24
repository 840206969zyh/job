package com.heryoos.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan(basePackages = {"com.heryoos.job.mapper"})
@Component("com.heryoos.job")
public class ShopJobApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ShopJobApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShopJobApplication.class);
    }

}
