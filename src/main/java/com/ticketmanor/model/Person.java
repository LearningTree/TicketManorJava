package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Person - XXX
 */
@Entity @Table(name="people")
public class Person   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String firstName, middles, lastName;
	String email;
	@Embedded
	Address address;
}
