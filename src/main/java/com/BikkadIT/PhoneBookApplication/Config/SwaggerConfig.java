package com.BikkadIT.PhoneBookApplication.Config;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;


import springfox.documentation.swagger2.annotations.EnableSwagger2;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket apiDoc() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.BikkadIT.PhoneBookApplication"))
			.paths(PathSelectors.any())
			.build();
		
	}
}
