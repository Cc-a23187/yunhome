package com.whpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.whpu.mapper")
public class YunhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunhomeApplication.class, args);
    }

}
