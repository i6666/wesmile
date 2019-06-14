package com.wesmile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="com.wesmile.mapper")
public class WesmileApplication {

    public static void main(String[] args) {
        SpringApplication.run(WesmileApplication.class, args);
    }

}
