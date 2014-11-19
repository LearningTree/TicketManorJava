package com.ticketmanor.model;

import java.time.*;
import javax.persistence.*;

/*
 * Event - An Event is one act at one time at one Venue
 */
@Entity @Table(name="Events")
public class Event   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	/** The Act; may be a movie, a troupe, a rock group, etc. */
	@ManyToOne
	Act what;
	/** When this ticket is for (to the minute, e.g., 2014-11-11T11:11) */
	LocalDateTime when;
	/** The Venue at which the event takes place. */
	@ManyToOne
	Venue where;

	public String toString() {
		return what + "@" + when + " " + where;
	}
}
