package com.ticketmanor.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Person - One individual person who has some interaction with the system.
 */
@Entity @Table(name="people")
@XmlRootElement
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@NotNull
	protected String firstName;
	protected String middles;
	@NotNull
	protected String lastName;
	// Minimal email validation: name@host.something
	@Pattern(regexp="\\w+@\\w+\\..*")
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
