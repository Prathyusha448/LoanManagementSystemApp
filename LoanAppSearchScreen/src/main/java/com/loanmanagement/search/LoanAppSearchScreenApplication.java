package com.loanmanagement.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.loanmanagement.search.repository")
public class LoanAppSearchScreenApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAppSearchScreenApplication.class, args);
	}

}
