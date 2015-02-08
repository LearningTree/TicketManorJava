package com.ticketmanor.service;

import java.time.LocalDate;
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
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ticketmanor.model.Event;
import com.ticketmanor.model.Location;

@Stateless
@Local @Remote
@Path("eventsEjb")
public class EventsEjb {
	@PersistenceContext EntityManager em;
	
	public List<Event> getAllEvents() {
		Query q = em.createQuery("from Event e");
		return q.getResultList();
	}
	
	/** Get a list of Events on the given date */
	public List<Event> getEventsForDate(LocalDate selectedDate) {
		Query q = em.createQuery("from Event e where e.date like " + selectedDate);
		return q.getResultList();
	}
	
	/** Get events that will occur in the next 'n' days */
	public List<Event> getEventsNextNDays(int nDays) {
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.from(start).plusDays(nDays);
		Query q = em.createQuery("from Event e where e.date <= " + start + " AND e.date >= " + end);
		return q.getResultList();
	}

	@GET
	public List<Event> getEventsNextNDays(int nDays, Location locn) {
		// XXX Doesn't handle location yet!
		return getEventsNextNDays(nDays);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addEvent(Event event) {
		em.persist(event);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteEvent(Event event) {
		em.remove(event);
	}
}
