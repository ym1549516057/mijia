package com.hxyk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxyk.dao")
public class IntelligentcommunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntelligentcommunityApplication.class, args);
	}
}
