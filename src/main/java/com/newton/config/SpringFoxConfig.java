package com.newton.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {
	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.newton.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo("API do curso de Spring boot",
				"Esta api é utilizada no curso de Spring Boot do prof. Nelio Alves",
				"Versão 1.0",
				"https://www.linkedin.com/in/newtonneto/",
				new Contact("Newton Neto", "https://www.linkedin.com/in/newtonneto/", "newton.mgs@gmail.com"),
						"GitHub",
						"https://github.com/newtonneto/",
						Collections.emptyList()
		);
	}
}
