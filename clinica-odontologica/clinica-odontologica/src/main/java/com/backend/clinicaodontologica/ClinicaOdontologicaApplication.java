package com.backend.clinicaodontologica;

import com.backend.clinicaodontologica.dao.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class ClinicaOdontologicaApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		H2Connection.create();
		LOGGER.info("ClinicaOdontologica is now running...");
	}

}
