package com.example.hrgatewayzuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class HrGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrGatewayZuulApplication.class, args);
	}

}
