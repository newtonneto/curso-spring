package com.newton.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.newton.services.DBService;
import com.newton.services.EmailService;
import com.newton.services.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		if(!"create".equals(strategy)) {
			//Caso deseje parar a recriação do DB sempre que o programa for reinicializado, setar o valor de,
			//spring.jpa.hibernate.ddl-auto para none em applications-dev.properties
			return false;
		}
		
		dbService.instantiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
