package com.johnp.flightreservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.johnp.flightreservation.dao.ReservationRepository;
import com.johnp.flightreservation.dto.ReservationUpdatedto;
import com.johnp.flightreservation.entities.Reservation;
import com.johnp.flightreservation.exception.UserNotFoundException;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationrepo;

	@GetMapping("/reservation/{id}")
	public Reservation showOneReservation(@PathVariable("id") int id) {
		Reservation reservation;
		try {
			reservation = reservationrepo.findById(id).get();

		} catch (Exception e) {
			throw new UserNotFoundException("Res id:" + id);
		}
		System.out.println("reservation objet :" + reservation);

		return reservation;
	}

	@GetMapping("/reservation")
	public List<Reservation> showAllReservation() {
		return reservationrepo.findAll();
	}

	@PostMapping("/reservation")
	public Reservation updateOneReservation(@RequestBody ReservationUpdatedto res) {
		System.out.println("updateOneReservation" + res);
		Reservation reservation = reservationrepo.getOne(res.getResid());
		System.out.println("Reservation Original Fetched" + reservation);
		reservation.setCheckedin(true);
		reservation.setNo_of_bags(res.getNumber_of_bags());
		return reservationrepo.save(reservation);
	}

	/*
	 * @PutMapping("/res") public Reservation updateRes(@RequestBody Reservation
	 * res) { return reservationrepo.save(res); }
	 */
}
