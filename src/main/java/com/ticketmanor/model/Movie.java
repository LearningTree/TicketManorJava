package com.ticketmanor.model;

import javax.persistence.Entity;

@Entity
public class Movie extends Act {
	
	String director;
	
	public Movie(String director, String title, int year) {
		super(ActType.MOVIE);
		this.title = title;
		this.year = year;
		this.director = director;
	}
	
	public Movie() {
		// required by JPA
	}
	
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return getTitle() + " " + getYear();
	}
}
