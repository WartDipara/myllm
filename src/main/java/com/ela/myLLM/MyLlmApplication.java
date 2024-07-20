package com.ela.myLLM;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ela.myLLM.mapper")
public class MyLlmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLlmApplication.class, args);
	}

}
