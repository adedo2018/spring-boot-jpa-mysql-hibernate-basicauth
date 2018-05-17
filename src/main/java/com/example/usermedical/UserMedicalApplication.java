package com.example.usermedical;

import com.mangofactory.swagger.plugin.EnableSwagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableSwagger
public class UserMedicalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMedicalApplication.class, args);
	}
}
