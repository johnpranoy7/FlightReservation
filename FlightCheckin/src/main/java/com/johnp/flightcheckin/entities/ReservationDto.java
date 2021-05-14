package com.johnp.flightcheckin.entities;

public class ReservationDto {
	private int flightid;
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String name_on_card;
	private String card_num;
	private String cvv;
	private int fl;

	public int getFlightid() {
		return flightid;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName_on_card() {
		return name_on_card;
	}

	public void setName_on_card(String name_on_card) {
		this.name_on_card = name_on_card;
	}

	public String getCard_num() {
		return card_num;
	}

	public void setCard_num(String card_num) {
		this.card_num = card_num;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public int getFl() {
		return fl;
	}

	public void setFl(int fl) {
		this.fl = fl;
	}

	@Override
	public String toString() {
		return "ReservationDto [flightid=" + flightid + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", email=" + email + ", phone=" + phone + ", name_on_card=" + name_on_card + ", card_num=" + card_num
				+ ", cvv=" + cvv + ", fl=" + fl + "]";
	}

}
