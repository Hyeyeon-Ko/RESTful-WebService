package com.example.restfulwebservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
//@EnableSwagger2
@OpenAPIDefinition
public class SwaggerConfig {
//    강의 내용
//    private static final Contact DEFAULT_CONTACT = new Contact("Kenneth Lee",
//            "http://www.joneconsulting.co.kr", "edowon@joneconsulting.co.kr");
//
//    private static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome API Title",
//            "My User management REST API service", "1.0", "urn:tos",
//            DEFAULT_CONTACT, "Apache 2.0",
//            "http://www.apache.org/license/LICENSE-2.0", new ArrayList<>());
//
//    커뮤니티 내용
//    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<>(
//            Arrays.asList("application/json", "application/xml"));

//    private static final Contact CONTACT = new Contact().name("Kenneth Lee")
//            .url("http://www.joneculsting.co.kr")
//            .email("edowon@joneconsluting.co.kr");
//    private static final License LICENSE= new License().name("Apache 2.0")
//            .url("http://www.apache.org/licenses/LICENSE-2.0");
//    private static final Info INFO = new Info().title("Awesome API Title")
//            .contact(CONTACT)
//            .description("Awesome API Documentation")
//            .version("1.0")
//            .license(LICENSE)
//            .termsOfService("urn:tos");
//    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES
//            = new HashSet<>(Arrays.asList("application/json", "application/xml"));

    @Bean
    public OpenAPI openAPI() {
        Contact contact = new Contact()
                .name("Kenneth Lee")
                .url("http://www.joneculsting.co.kr")
                .email("edowon@joneconsluting.co.kr");

        License license = new License()
                .name("Apache 2.0")
                .url("http://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("Awesome API Title")
                .contact(contact)
                .description("Awesome API Documentation")
                .version("1.0")
                .license(license)
                .termsOfService("urn:tos");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}