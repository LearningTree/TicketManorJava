package com.ticketmanor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * Venue - A place where Events happen. Some (such as modern movie theatres) have more than one Auditorium;
 * others (such as large concert halls) do not.
 */
@Entity @Table(name="venues")
@XmlRootElement
public class Venue   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String name;
	/** The location */
	String streetAddress, city, provState, country;
	/** The Geometry coordinates; N.B. May be null! */
	Double lat, lng;
	
	@OneToMany(mappedBy="venue")
	Set<Auditorium> auditoria = new HashSet<>();
	
	public String toString() {
		return name;
	};
	
	public long getId() {
		return id;
	}
}
