package com.johnp.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.johnp.flightreservation.entities.Reservation;

@Component
public class PdfGenerator {

	public static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);

	public void generateTicket(Reservation reservation, String filepath) {
		Document document = new Document();
		LOGGER.info("Created new Document");
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));

			document.open();
			LOGGER.info("opened the ducoment");

			document.add(generateTable(reservation));
			LOGGER.info("added the Table inside Document");

			document.close();
			LOGGER.info("Closed the Document");

		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Failed to create PDF because of exception: " + e);
			e.printStackTrace();
		}
	}

	public PdfPTable generateTable(Reservation reservation) {
		LOGGER.info("Inside generateTable");
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		LOGGER.info("Added a row for Flight Details");

		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightnum());
		LOGGER.info("Added FlightNumber");

		table.addCell("Airliner");
		table.addCell(reservation.getFlight().getAirliner());
		LOGGER.info("Added Airliner Information");

		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDeparture_city());
		LOGGER.info("Added Departure City");

		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrival_city());
		LOGGER.info("Added Arrival City");

		table.addCell("Date of Travel");
		table.addCell(reservation.getFlight().getDate_of_travel().toString());
		LOGGER.info("Added Date of Travel");

		table.addCell("Time of Travel");
		table.addCell(reservation.getFlight().getEstimated_timetravel().toString());
		LOGGER.info("Added Time of Travel");

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);
		LOGGER.info("Added row for Passenger Details");

		table.addCell("First NAme:");
		table.addCell(reservation.getPassenger().getFirst_name());
		LOGGER.info("Added FirstName");

		table.addCell("Last NAme:");
		table.addCell(reservation.getPassenger().getLast_name());
		LOGGER.info("Added LastNAme");

		table.addCell("Email Id");
		table.addCell(reservation.getPassenger().getEmail());
		LOGGER.info("Added EmailID");

		table.addCell("Phone Number");
		table.addCell(reservation.getPassenger().getPhone());
		LOGGER.info("Added Phone Number");
		LOGGER.info("returning table: " + table);

		return table;
	}
}
