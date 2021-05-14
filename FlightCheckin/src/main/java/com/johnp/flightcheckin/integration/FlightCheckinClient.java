package com.johnp.flightcheckin.integration;

import com.johnp.flightcheckin.entities.Reservation;
import com.johnp.flightcheckin.entities.ReservationDto;
import com.johnp.flightcheckin.entities.ReservationUpdatedto;

public interface FlightCheckinClient {
	public Reservation getReservation(int id);
	public Reservation updateReservation(ReservationUpdatedto res);
}
