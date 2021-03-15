package com.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com"})
@EntityScan( basePackages = {"com.entities"} )
public class AppStarter {

	public static void main(String[] args) {
		SpringApplication.run(AppStarter.class, args);

	}

}
