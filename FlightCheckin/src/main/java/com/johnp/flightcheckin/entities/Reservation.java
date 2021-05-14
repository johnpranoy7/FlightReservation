package com.johnp.flightcheckin.entities;

import java.sql.Timestamp;

public class Reservation {

	private int id;
	private boolean checkedin;
	private int no_of_bags;
	private Timestamp created;

	private Flight flight;

	private Passenger passenger;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCheckedin() {
		return checkedin;
	}

	public void setCheckedin(boolean checkedin) {
		this.checkedin = checkedin;
	}

	public int getNo_of_bags() {
		return no_of_bags;
	}

	public void setNo_of_bags(int no_of_bags) {
		this.no_of_bags = no_of_bags;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkedin=" + checkedin + ", no_of_bags=" + no_of_bags + ", flight="
				+ flight + ", passenger=" + passenger + ", created=" + created + "]";
	}

}
