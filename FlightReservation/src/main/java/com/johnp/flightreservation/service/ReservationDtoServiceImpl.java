package com.johnp.flightreservation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.johnp.flightreservation.dao.FlightRepository;
import com.johnp.flightreservation.dao.PassengerRepository;
import com.johnp.flightreservation.dao.ReservationRepository;
import com.johnp.flightreservation.dto.ReservationDto;
import com.johnp.flightreservation.entities.Flight;
import com.johnp.flightreservation.entities.Passenger;
import com.johnp.flightreservation.entities.Reservation;
import com.johnp.flightreservation.util.EmailSender;
import com.johnp.flightreservation.util.PdfGenerator;

@Component
@Transactional
public class ReservationDtoServiceImpl implements ReservationDtoService {

	public static final Logger LOGGER = LoggerFactory.getLogger(ReservationDtoServiceImpl.class);

	@Value("${com.johnp.flightreservation.service.reservationdtoserviceimpl.file.path}")
	private String FILE_PATH;

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	ReservationRepository resevationrepo;

	@Autowired
	PassengerRepository passengerrepo;

	@Autowired
	EmailSender emailSender;

	@Autowired
	PdfGenerator pdfGenerator;

	@Override
	public Reservation finishReservation(ReservationDto reservDto) {
		LOGGER.info("FinishReservation" + reservDto);
		int flId = reservDto.getFl();
		LOGGER.info("flId :" + flId);
		Flight flight = flightRepository.findById(flId).get();
		LOGGER.info("Retreieved Flight :" + flight);
		Reservation reservation = new Reservation();
		reservation.setCheckedin(false);
		reservation.setNo_of_bags(0);

		Passenger passenger = new Passenger();
		passenger.setFirst_name(reservDto.getFirst_name());
		passenger.setLast_name(reservDto.getLast_name());
		passenger.setEmail(reservDto.getEmail());
		passenger.setPhone(reservDto.getPhone());
		LOGGER.info("Saving the passenger" + passenger);
		passengerrepo.save(passenger);
		LOGGER.info("saved Passenger" + passenger);

		reservation.setFlight(flight);
		reservation.setPassenger(passenger);
		LOGGER.info("Saving Reservation :" + reservation);
		resevationrepo.save(reservation);
		LOGGER.info("Saved Reservation");
		LOGGER.info("FILE_PATH :" + FILE_PATH);
		pdfGenerator.generateTicket(reservation, FILE_PATH + reservation.getId() + ".pdf");
		LOGGER.info("generateTicket called from pdfGenerator");
		emailSender.sendEmail(reservation.getPassenger().getEmail(), FILE_PATH + reservation.getId() + ".pdf");
		LOGGER.info("sendEmail called");
		LOGGER.info("Returning Reservation from finishReservation function :" + reservation);
		return reservation;
	}

}
