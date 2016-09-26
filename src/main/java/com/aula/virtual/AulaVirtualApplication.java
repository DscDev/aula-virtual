package com.aula.virtual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.aula.virtual.test","com.aula.virtual.controller","com.aula.virtual.service"})
public class AulaVirtualApplication {


	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(AulaVirtualApplication.class, args);
	}
}
