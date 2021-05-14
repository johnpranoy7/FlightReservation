package com.johnp.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	public static final Logger LOGGER = LoggerFactory.getLogger(EmailSender.class);

	@Autowired
	JavaMailSender sender;

	public void sendEmail(String to, String filepath) {
		LOGGER.info("Inside sendEmail");
		MimeMessage message = sender.createMimeMessage();
		try {
			LOGGER.info("Inside Try Block");
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.addTo(to);
			helper.setSubject("Itenary for your Flight");
			helper.setText("PFA for your Itenary");
			helper.addAttachment("Flight Itenary", new File(filepath));
			sender.send(message);
			LOGGER.info("Message has been sent Successfully");

		} catch (MessagingException e) {
			LOGGER.error("Email Sending Failed with Exception :" + e);
			e.printStackTrace();
		}

	}
}
