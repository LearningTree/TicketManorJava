package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Auditorium - XXX
 */
@Entity @Table(name="Auditoriums")
public class Auditorium   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	// TODO
}
