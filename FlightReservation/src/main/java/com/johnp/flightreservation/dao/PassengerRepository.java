package com.johnp.flightreservation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.johnp.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
