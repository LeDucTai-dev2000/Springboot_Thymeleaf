package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"thymeleaf.controller"} )
public class DemoSpringThymeleafApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringThymeleafApplication.class, args);
	}

}
