package com.johnp.flightcheckin.entities;

import org.springframework.stereotype.Component;

@Component
public class ReservationUpdatedto {
	private int resid;
	private int number_of_bags;
	private boolean checkedin;

	public int getResid() {
		return resid;
	}

	public void setResid(int resid) {
		this.resid = resid;
	}

	public int getNumber_of_bags() {
		return number_of_bags;
	}

	public void setNumber_of_bags(int number_of_bags) {
		this.number_of_bags = number_of_bags;
	}

	public boolean isCheckedin() {
		return checkedin;
	}

	public void setCheckedin(boolean checkedin) {
		this.checkedin = checkedin;
	}

	@Override
	public String toString() {
		return "ReservationUpdatedto [resid=" + resid + ", number_of_bags=" + number_of_bags + ", checkedin="
				+ checkedin + "]";
	}

}
