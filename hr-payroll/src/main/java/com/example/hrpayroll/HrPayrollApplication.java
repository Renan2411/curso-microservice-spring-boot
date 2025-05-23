package com.example.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@RibbonClient(name = "hr-worker") COM O EUREKA NÃO HÁ NECESSIDADE DO RIBBON
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableCircuitBreaker
public class HrPayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrPayrollApplication.class, args);
    }

}
