package com.ticketmanor.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.Test;

import com.ticketmanor.model.Event;
import com.ticketmanor.model.Movie;

public class EjbTest {

	@Test
	public void test() throws Exception {

		final Properties p = new Properties();
		p.put("TicketManorDataSource", "new://Resource?type=DataSource");
		p.put("TicketManorDataSource.JdbcDriver", "org.hsqldb.jdbcDriver");
		p.put("TicketManorDataSource.JdbcUrl", "jdbc:hsqldb:mem:TicketManorDataSource");

		final Context context = EJBContainer.createEJBContainer(p).getContext();

		EventsBean events = (EventsBean) context.lookup("java:global/injection-of-entitymanager/EventsBean");

		LocalDateTime today = LocalDateTime.now();
		events.addEvent(new Event(new Movie("Quentin Tarantino", "Reservoir Dogs", 1992), today, null));
		events.addEvent(new Event(new Movie("Joel Coen", "Fargo", 1996), today, null));
		events.addEvent(new Event(new Movie("Joel Coen", "The Big Lebowski", 1998), today, null));

		List<Event> list = events.getEvents();
		assertEquals("List.size()", 3, list.size());

		for (Event event : list) {
			events.deleteEvent(event);
		}

		assertEquals("List now empty", 0, events.getEvents().size());
	}
}