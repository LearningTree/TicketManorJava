package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Ticket - XXX
 */
@Entity @Table(name="Tickets")
public class Ticket   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
