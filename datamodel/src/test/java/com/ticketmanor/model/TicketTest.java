package com.ticketmanor.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketTest {

	/** Test getPrice because it's an inherited field. */
	@Test
	public void testPrice() {
		Ticket t = new Ticket(null, null, 12.34);
		assertEquals(12.34, t.getPrice(), 0.001);
	}

}
