package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Auditorium - XXX
 */
@Entity @Table(name="auditoriums")
public class Auditorium   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	String name;
	String address;
}
