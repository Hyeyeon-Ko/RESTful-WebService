package com.example.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class  RestfulWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulWebServiceApplication.class, args);
    }

    @Bean
    public LocaleResolver localeResolver(){
        //SessionLocaleResolver 클래스는 세션을 통해서 로케일 값을 얻어옴
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        //한국어 처리가 가본이 될 수 있게 DefaultLocale값을 Locale.KOREA로 지정
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
}
