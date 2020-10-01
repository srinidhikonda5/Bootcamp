package com.capg.go.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/****************************************************************************************************************************
- File Name        : GoCartManagementSystemApplication .java 
- Author           : Srinidhi
- Creation Date    : 21/09/2020
- Modified Date    : 22/09/2020
****************************************************************************************************************************/


@SpringBootApplication
public class GoCartManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoCartManagementSystemApplication.class, args);

	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
