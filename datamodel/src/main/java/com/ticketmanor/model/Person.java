package com.ticketmanor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
 * Person - One individual person who has some interaction with the system.
 */
@Entity @Table(name="people")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@NotNull
	protected String firstName;
	protected String middles;
	@NotNull
	protected String lastName;
	String email;
	@Embedded
	Address address;
	
	public Person() {
		// EMPTY
	}
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + getFullName();
	}

	@Transient
	public String getFullName() {
		StringBuilder sb = new StringBuilder(firstName);
		if (middles != null) {
			sb.append(" ").append(middles);
		}
		sb.append(" ").append(lastName);
		return sb.toString();
	}
}
