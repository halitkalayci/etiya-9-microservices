package com.etiya.identityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// TODO: daha sonra konuşacağız
//@ComponentScan(basePackages = {"io.github.halitkalayci"})
public class IdentityserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdentityserviceApplication.class, args);
	}

}
