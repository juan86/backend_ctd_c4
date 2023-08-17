package com.backend.digitalhouse.clase15;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Clase15Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Clase15Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Clase15Application.class, args);
		LOGGER.info("Clase15 is now running...");
	}

}
