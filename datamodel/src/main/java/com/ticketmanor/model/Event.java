package com.ticketmanor.model;

import java.time.*;

import javax.persistence.*;
/*
 * Event - An Event is one act at one time at one Venue
 */
import javax.xml.bind.annotation.*;

@XmlRootElement
@Entity @Table(name="events")
public class Event   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The Act; may be a movie, a troupe, a rock group, etc. */
	@ManyToOne
	Act what;
	/** When this ticket is for (to the minute, e.g., 2014-11-11T11:11) */
	@Column(name="date_time")
	LocalDateTime date;
	/** The Venue at which the event takes place. */
	@ManyToOne
	Venue where;
	
	public Event(Act act, LocalDateTime dateTime, Venue where) {
		this.what = act;
		this.date = dateTime;
		this.where = where;
	}
	
	public Event() {
		// required by JPA
	}

	public String toString() {
		return what + "@" + date + " " + where;
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

	public LocalDateTime getDate() {
		return date;
	}

	public Venue getWhere() {
		return where;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((what == null) ? 0 : what.hashCode());
		result = prime * result + ((where == null) ? 0 : where.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (what == null) {
			if (other.what != null)
				return false;
		} else if (!what.equals(other.what))
			return false;
		if (where == null) {
			if (other.where != null)
				return false;
		} else if (!where.equals(other.where))
			return false;
		return true;
	}
}
