package com.ticketmanor.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.ticketmanor.model.Act;
import com.ticketmanor.model.ActType;
import com.ticketmanor.model.Event;
import com.ticketmanor.model.Location;
import com.ticketmanor.model.Venue;

/** 
 * Slightly mis-named; should be ConcertsEjb
 * Generates fake data and keeps it in an in-memory List<Event> to reduce overhead.
 */
@Singleton
@Startup
@Local @Remote
@Path("eventsEjb")
public class EventsEjb {
    private static final long serialVersionUID = +531574255525675305L;

	@PersistenceContext EntityManager em;

	private static List<Event> allEvents;

	/**
	 * Get All events
	 * @return A list of all Events
	 */
	public List<Event> getAllEvents() {
		final TypedQuery<Event> query = 
				em.createQuery("from Event e", Event.class);
		return query.getResultList();
	}

    @PostConstruct
    public void started() {
        System.out.println("EventsEjb started()");
		fakeEvents();
    }

	/**
	 * Make up new fake events; scheduled to run daily before midnight.
	 * Switches "allEvents" atomically in case one is viewing while this runs.
	 * Uses Vector as necessary for thread safety.
	 */
    @Schedule(hour="23", minute="55", persistent=false)
    public void fakeEvents() {
		System.out.println("EventsEjb::fakeEvents called");
		Act firstAct = em.find(Act.class, 1L); // must exist
		List<Act> sportsTeams = em.createQuery("from Act act where act.type = ?1", Act.class).
				setParameter(1, ActType.SPORTS).
				getResultList();
		
		List<Venue> allVenues = em.createQuery("from Venue v", Venue.class).getResultList();
		List<Event> newAll = new Vector<>();
		LocalDateTime start = LocalDateTime.now().withHour(19).withMinute(0);
		int nTeams = 0, nVenues=0;
		Event ev = new Event(firstAct, start.plusDays(i), allVenues.get(0));
		newAll.add(ev);
		for (int i = 0; i < 20; i++) {
			nTeams++; nTeams %= sportsTeams.size();
			nVenues++; nVenues %= allVenues.size();
			Event sp = new Event(sportsTeams.get(nTeams), start.plusDays(i), allVenues.get(nVenues));
			newAll.add(sp);
		}
		allEvents = newAll;
	}

	
	/** 
	 * Get a list of Events on the given date
	 * @param selectedDate The date on which to look for events.
	 * @return a list of Events for that date
	 */
	public List<Event> getEventsForDate(LocalDate selectedDate) {
		final List<Event> l = new Vector<>();
		return allEvents
			.stream()
			.filter(evt->evt.getDate().equals(selectedDate))
			.toList();
	}
	
	/**
	 * Get events that will occur in the next 'n' days
	 * @param nDays The range of days (now to 'N' days hence) to look for
	 * @return A list of Events over the next n days
	 */
	public List<Event> getEventsNextNDays(int nDays) {
		return allEvents
			.stream()
			.filter(evt -> dateInRange(evt, nDays))
			.toList();
	}

	boolean dateInRange(Event evt, int nDays) {
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.from(start).plusDays(nDays);
		long evtDay = evt.getDate().toLocalDate().toEpochDay();

		return evtDay >= start.toEpochDay() && evtDay <= end.toEpochDay();
	}

	/**
	 * REST front-end to get events that will occur in the next 'n' days
	 * @param nDays The range of days (now to 'N' days hence) to look for
	 * @param locn The Location in which to look for the events
	 * @return A list of Events over the next n days
	 */
	// @GET
	public List<Event> getEventsNextNDays(int nDays, Location locn) {
		// XXX Doesn't handle location yet!
		return getEventsNextNDays(nDays);
	}
	
	/**
	 * Add an Event to the database
	 * @param event The Event object to be added
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addEvent(Event event) {
		allEvents.add(event);
	}

	/**
	 * Remove an Event from the database.
	 * @param event The Event object to remove
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteEvent(Event event) {
		allEvents.remove(event);
	}
}
