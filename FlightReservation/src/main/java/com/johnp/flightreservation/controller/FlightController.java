package com.johnp.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.johnp.flightreservation.dao.FlightRepository;
import com.johnp.flightreservation.entities.Flight;

@Controller
public class FlightController {

	public static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

	@Autowired
	FlightRepository flightrepo;

	@RequestMapping("/showFLights")
	public String showFLights(@RequestParam("departure_city") String departure_city,
			@RequestParam("arrival_city") String arrival_city,
			@RequestParam("date_of_travel") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date_of_travel,
			ModelMap modelMap) {
		LOGGER.info("Inside showFlights");
		System.out.println(departure_city + "\n" + arrival_city + "\n" + date_of_travel);

		LOGGER.info("");
		List<Flight> availableFlights = flightrepo.fromToFlight(departure_city, arrival_city, date_of_travel);
		LOGGER.info("fromToFlight method called from flightrepo");
		for (Flight f : availableFlights)
			System.out.println(f);
		modelMap.addAttribute("flights", availableFlights);
		LOGGER.info("redirect to displayFlights.jsp");
		return "displayFlights";
	}

	@RequestMapping("/selectflight")
	public String selectFlight(@RequestParam("id") int id, ModelMap modelmap) {
		LOGGER.info("findById called from flightrepo for id" + id);
		Flight flight = flightrepo.findById(id).get();
		modelmap.addAttribute("flight", flight);
		LOGGER.info("Display BillingPage.jsp");
		return "BillingPage";
	}

	@RequestMapping("/admin/addFlight")
	public String addFlight() {
		return "addFlight";
	}
}
