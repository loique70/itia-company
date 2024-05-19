package com.itia.sitevitrine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableJpaAuditing
public class sitevitrineApplication {

	public static void main(String[] args) {
		SpringApplication.run(sitevitrineApplication.class, args);
	}

}
