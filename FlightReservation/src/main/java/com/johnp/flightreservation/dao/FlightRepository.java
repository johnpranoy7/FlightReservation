package com.johnp.flightreservation.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.johnp.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

	@Query("from Flight where departure_city=:dept and arrival_city=:arr and date_of_travel=:doj")
	List<Flight> fromToFlight(@Param("dept") String departure_city, @Param("arr") String arrival_city,
			@Param("doj") Date date);

}



