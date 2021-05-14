package com.johnp.flightreservation.service;

import com.johnp.flightreservation.dto.ReservationDto;
import com.johnp.flightreservation.entities.Reservation;

public interface ReservationDtoService {

	public Reservation finishReservation(ReservationDto reservDto);
}
