package com.rest.webservices.restfulwebservices.swagger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
@Configuration
// Enable Swagger
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Md. Ashik Ali Khan",
			"http://ashik-programmer.blogspot.com", "khan.ashik@gmail.com");
	private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Api Documentation Title",
			"Api Documentation Decription", "2.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0",
			"http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_CONSUMES_PRODUCES = 
			new HashSet<>(Arrays.asList("application/json", "application/xml"));

	// Bean - Docket
	// Swagger 2
	// all the paths
	// all the apis
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
				.consumes(DEFAULT_CONSUMES_PRODUCES)
				.produces(DEFAULT_CONSUMES_PRODUCES);
	}
}
