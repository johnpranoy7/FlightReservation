package com.johnp.flightreservation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightReservationApplication {

	public static final Logger LOGGER = LoggerFactory.getLogger(FlightReservationApplication.class);

	public static void main(String[] args) {
		LOGGER.info("Inside Runner Class");
		SpringApplication.run(FlightReservationApplication.class, args);
	}

}
