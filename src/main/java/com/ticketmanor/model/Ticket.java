package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Ticket - A Ticket is one seat at one Event
 */
@Entity @Table(name="Tickets")
public class Ticket   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The seat number that this Ticket is for; null means non-reserved seating */
	String seatNumber;
}
