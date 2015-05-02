package com.ticketmanor.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class EventTest {

	final static LocalDateTime now = LocalDateTime.now();
	
	Act acta = new Act(ActType.MUSICAL, "In The Dogs' Den");
	
	final static Venue venue = new Venue("Rectangle Square Gardens");

	@Test
	public void testEquals() {
		Event evt1 = new Event(acta, now, venue);
		Event evt2 = new Event(acta, now, venue);
		assertEquals(evt1, evt2);
	}
}
