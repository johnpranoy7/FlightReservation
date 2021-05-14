package com.johnp.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnp.flightcheckin.entities.Reservation;
import com.johnp.flightcheckin.entities.ReservationUpdatedto;
import com.johnp.flightcheckin.integration.FlightCheckinClient;

@Controller
public class ReservationClientController {

	@Autowired
	FlightCheckinClient flightCheckinClient;

	@RequestMapping("/showCheckin")
	public String displayCheckin() {
		return "showCheckin";
	}

	@RequestMapping("/getCheckin")
	public String showCheckin(@RequestParam("id") int reservationId, ModelMap modelmap) {
		Reservation reservation = flightCheckinClient.getReservation(reservationId);
		modelmap.addAttribute("reservation", reservation);
		return "enterBags";
	}
	
	@RequestMapping("/confirmation")
	public String showConfirmationPage(@RequestParam("no_of_bags")int no_of_bags, @RequestParam("id")int reservationId)
	{	
		System.out.println(no_of_bags+" "+reservationId);
		ReservationUpdatedto res = new ReservationUpdatedto();
		res.setResid(reservationId);
		res.setCheckedin(true);
		res.setNumber_of_bags(no_of_bags);
		flightCheckinClient.updateReservation(res);
		return "success";
	}
}
