package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Event - XXX
 */
@Entity @Table(name="Events")
public class Event   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
