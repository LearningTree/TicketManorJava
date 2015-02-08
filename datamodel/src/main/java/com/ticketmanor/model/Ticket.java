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
}
