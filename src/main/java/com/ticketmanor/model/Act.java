package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Act - XXX
 */
@Entity @Table(name="Acts")
public class Act   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	// TODO
}
