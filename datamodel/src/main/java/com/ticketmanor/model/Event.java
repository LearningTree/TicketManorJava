package com.ticketmanor.model;

import java.time.*;
import javax.persistence.*;

/*
 * Event - An Event is one act at one time at one Venue
 */
@Entity @Table(name="events")
public class Event   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The Act; may be a movie, a troupe, a rock group, etc. */
	@ManyToOne
	Act what;
	/** When this ticket is for (to the minute, e.g., 2014-11-11T11:11) */
	@Column(name="date_time")
	LocalDateTime dateTime;
	/** The Venue at which the event takes place. */
	@ManyToOne
	Venue where;
	
	public Event(Act act, LocalDateTime dateTime, Venue where) {
		this.what = act;
		this.dateTime = dateTime;
		this.where = where;
	}
	
	public Event() {
		// required by JPA
	}

	public String toString() {
		return what + "@" + dateTime + " " + where;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public Act getWhat() {
		return what;
	}

	public LocalDateTime getWhen() {
		return dateTime;
	}

	public Venue getWhere() {
		return where;
	}
}
