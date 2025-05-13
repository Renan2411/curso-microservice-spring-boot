package org.example.hrconfigserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import io.github.cdimascio.dotenv.Dotenv;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigServer
public class HrConfigServerApplication {

//    @Value("${spring.cloud.config.server.git.username}")
//    private String username;
//
//    @PostConstruct
//    public void init() {
//        Dotenv dotenv = Dotenv.load();
//        dotenv.entries().forEach(entry ->
//                System.setProperty(entry.getKey(), entry.getValue())
//        );
//    }

    public static void main(String[] args) {
        SpringApplication.run(HrConfigServerApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        System.out.printf(username);
//    }
}
