package com.ticketmanor.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class VenueTest {

	private static final String VENUE_NAME = "Triangle Square Gardens";

	private static final Venue venue = new Venue(VENUE_NAME);
	
	@Test
	public void testEquals() {
		Venue v2 = new Venue(VENUE_NAME);
		assertEquals(venue, v2);
	}
}
