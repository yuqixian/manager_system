package com.yuqixian.ms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.foitech.ms.mapper")
public class MsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

}
