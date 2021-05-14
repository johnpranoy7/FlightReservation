package com.johnp.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.johnp.flightreservation.dto.ReservationDto;
import com.johnp.flightreservation.entities.Reservation;
import com.johnp.flightreservation.service.ReservationDtoService;

@Controller
public class ReservationController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class); 
	
	@Autowired
	ReservationDtoService reservationDtoService;
	
	@RequestMapping("/completeReservation")
	public String completeReservation(@ModelAttribute ReservationDto resDto)
	{	
		LOGGER.info("Inside completeReservation");
		LOGGER.info("ReservationDto :"+resDto);
		LOGGER.info("finishReservation called from reservationDtoService");
		Reservation reservation = reservationDtoService.finishReservation(resDto);
		LOGGER.info("reservation fetched from service layer: "+reservation);
		LOGGER.info("Display CompleteReservation.jsp");
		return "CompleteResevation";
	}
}
