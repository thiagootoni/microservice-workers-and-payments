package com.thiago.hrworker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class HrWorkerApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hr-worker no ar!");
		
	}

}
