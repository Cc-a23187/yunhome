package com.whpu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(value = "com.whpu.mapper")
@SpringBootApplication
public class YunhomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(YunhomeApplication.class, args);
	}

}
