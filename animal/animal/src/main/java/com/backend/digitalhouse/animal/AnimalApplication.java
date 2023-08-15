package com.backend.digitalhouse.animal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AnimalApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnimalApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(AnimalApplication.class, args);
		LOGGER.info("AnimalApplication is now running...");
	}

	@GetMapping("hola")
	public String saludar(){
		String saludo = "Hola Camada 4";
		LOGGER.info(saludo);
		return saludo;
	}

}
