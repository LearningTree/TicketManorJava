package com.ticketmanor.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.ticketmanor.model.Event;

@Stateless
@Local @Remote
public class FindEventsBean {
	public List<Event> findByDate(Date selectedDate) {
		List<Event> matchedEvents = null;
		// ...
		return matchedEvents;
	}
}
