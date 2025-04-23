package com.example.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() { //Serve para registrar uma instância única (Singleton) do RestTemplate
        return new RestTemplate();
    }

}
