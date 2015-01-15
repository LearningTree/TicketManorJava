package com.ticketmanor.model;

import javax.persistence.*;

/*
 * An Act is one entity that people pay to see: A movie, a soloist, a troupe, a rock group, an orchestra...
 */
@Entity @Table(name="Acts")
@Inheritance(strategy=InheritanceType.JOINED)
public class Act   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	String name;
	ActType type;
	int year;
	String notes;
	/** A list of recordings related to this Act that we can sell */
	// Need to import the Recording hierarchy
	// List<Recording> discography;
	
	public Act() {
		// required by JPA
	}
	
	public Act(ActType type) {
		this.type = type;
	}
}
