package com.johnp.flightreservation.entities;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	private String flightnum;
	private String airliner;
	private String departure_city;
	private String arrival_city;
	private Date date_of_travel;
	private Timestamp estimated_traveltime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightnum() {
		return flightnum;
	}

	public void setFlightnum(String flightnum) {
		this.flightnum = flightnum;
	}

	public String getAirliner() {
		return airliner;
	}

	public void setAirliner(String airliner) {
		this.airliner = airliner;
	}

	public String getDeparture_city() {
		return departure_city;
	}

	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}

	public String getArrival_city() {
		return arrival_city;
	}

	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public Date getDate_of_travel() {
		return date_of_travel;
	}

	public void setDate_of_travel(Date date_of_travel) {
		this.date_of_travel = date_of_travel;
	}

	public Timestamp getEstimated_timetravel() {
		return estimated_traveltime;
	}

	public void setEstimated_timetravel(Timestamp estimated_traveltime) {
		this.estimated_traveltime = estimated_traveltime;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightnum=" + flightnum + ", airliner=" + airliner + ", departure_city="
				+ departure_city + ", arrival_city=" + arrival_city + ", date_of_travel=" + date_of_travel
				+ ", estimated_timetravel=" + estimated_traveltime + "]";
	}

}
