package com.ticketmanor.model;


public class Movie extends Act {
	
	String director;
	
	public Movie(String director, String title, int year) {
		super(ActType.MOVIE);
		this.name = title;
		this.year = year;
		this.director = director;
	}
}
