package com.johnp.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.johnp.flightcheckin.entities.Reservation;
import com.johnp.flightcheckin.entities.ReservationUpdatedto;

@Component
public class FlightCheckinClientImpl implements FlightCheckinClient {

	private static final String FLIGHT_RESERVATION_URL = "http://localhost:8080/flightreservation/reservation/";

	@Override
	public Reservation getReservation(int id) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.getForObject(FLIGHT_RESERVATION_URL + id, Reservation.class);
		return reservation;
	}

	@Override
	public Reservation updateReservation(ReservationUpdatedto reservationUpdatedto) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation1 = restTemplate.postForObject(FLIGHT_RESERVATION_URL, reservationUpdatedto,
				Reservation.class);
		return reservation1;
	}

}
