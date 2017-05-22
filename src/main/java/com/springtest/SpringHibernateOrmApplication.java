package com.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringHibernateOrmApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateOrmApplication.class, args);
	}
}
