package com.uisrael.mineria.mineriadatos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MineriaDatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MineriaDatosApplication.class, args);
	}

}
