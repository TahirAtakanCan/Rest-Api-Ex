package com.tahiratakancan.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.tahiratakancan"})
@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringRestApiApplication.class, args);
	}

}
