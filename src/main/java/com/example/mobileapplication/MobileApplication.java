package com.example.mobileapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.view.tiles3.SpringWildcardServletTilesApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.servlet.view.tiles3.SpringWildcardServletTilesApplicationContext;

@SpringBootApplication
public class MobileApplication {

    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Bean
//    public SpringWildcardServletTilesApplicationContext springWildcardServletTilesApplicationContext() {
//        return new SpringWildcardServletTilesApplicationContext();
//
//    }

}
