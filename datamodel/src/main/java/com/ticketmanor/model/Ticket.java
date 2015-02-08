package com.ticketmanor.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

/*
 * Ticket - A Ticket is one seat at one Event
 */
@Entity @Table(name="tickets")
@XmlRootElement
public class Ticket implements Sellable, Serializable {
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public long getId() {
		return id;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The Event that this ticket is for. */
	@NotNull Event event;
	/** The seat number that this Ticket is for; null means non-reserved seating */
	String seatNumber;
	/** The price of this seat, in dollars and cents */
	@NotNull Double price;
}
