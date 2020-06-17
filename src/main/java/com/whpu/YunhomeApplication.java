package com.whpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.whpu.mapper")
public class YunhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YunhomeApplication.class, args);
    }

}
