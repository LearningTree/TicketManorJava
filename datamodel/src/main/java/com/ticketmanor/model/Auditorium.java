package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Auditorium - XXX
 */
import javax.xml.bind.annotation.*;

@XmlRootElement
@Entity @Table(name="auditoriums")
public class Auditorium   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;

	String name;
	String address;
	@ManyToOne Venue venue;
}
