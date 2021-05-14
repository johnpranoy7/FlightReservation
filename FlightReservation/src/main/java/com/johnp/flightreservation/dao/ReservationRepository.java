package com.johnp.flightreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnp.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
