package com.example.aop.demo_aop;

import com.example.aop.demo_aop.business.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAopApplication implements CommandLineRunner {
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private BusinessService businessService;
	public static void main(String[] args) {
		SpringApplication.run(DemoAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(Integer.toString(businessService.calculateMax()));
	}
}
