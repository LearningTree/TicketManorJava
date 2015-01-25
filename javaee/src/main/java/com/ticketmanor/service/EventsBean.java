package com.ticketmanor.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ticketmanor.model.Event;
import com.ticketmanor.model.Location;

@Stateless
@Local @Remote
@Path("eventsEjb")
public class EventsBean {
	@PersistenceContext EntityManager em;
	
	final List<Event> events = new ArrayList<>();
	
	public List<Event> findByDate(LocalDateTime selectedDate) {
		// ...
		return events;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	@GET
	public List<Event> getEventsNextNDays(int nDays, Location locn) {
		List<Event> results = new ArrayList<>();
		// ...
		return results;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addEvent(Event event) {
		em.persist(event);
		events.add(event);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteEvent(Event event) {
		events.remove(event);
		em.remove(event);
	}
}
