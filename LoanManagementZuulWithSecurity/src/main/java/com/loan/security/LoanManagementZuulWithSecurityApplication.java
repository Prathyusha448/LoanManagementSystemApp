package com.loan.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class LoanManagementZuulWithSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementZuulWithSecurityApplication.class, args);
	}

}
