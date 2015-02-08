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
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The Event that this ticket is for. */
	@NotNull Event event;
	/** The seat number that this Ticket is for; null means non-reserved seating */
	String seatNumber;
	/** The price of this seat, in dollars and cents */
	@NotNull Double price;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((seatNumber == null) ? 0 : seatNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (seatNumber == null) {
			if (other.seatNumber != null)
				return false;
		} else if (!seatNumber.equals(other.seatNumber))
			return false;
		return true;
	}
}
