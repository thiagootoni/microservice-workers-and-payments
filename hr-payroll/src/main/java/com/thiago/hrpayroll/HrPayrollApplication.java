package com.thiago.hrpayroll;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class HrPayrollApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("HR- payroll no ar!!!");		
	}

}
