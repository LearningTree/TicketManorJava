package com.ticketmanor.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/*
 * Venue - A place where Events happen. Some (such as modern movie theatres) have more than one Auditorium;
 * others (such as large concert halls) do not.
 */
@Entity @Table(name="Venues")
public class Venue   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String name;
	
	@OneToMany
	Set<Auditorium> auditoria = new HashSet<>();
	
	public String toString() {
		return "Venue(" + name + ")";
	};
}
