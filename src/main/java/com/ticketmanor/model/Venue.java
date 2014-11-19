package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Venue - XXX
 */
@Entity @Table(name="Venues")
public class Venue   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
