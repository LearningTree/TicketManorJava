package com.ticketmanor.model;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Test;

public class ActTest {
	
	final static LocalDateTime now = LocalDateTime.now();
	
	Act acta = new Act(ActType.MUSICAL, "In The Dogs' Den");
	
	final static Venue venue = new Venue("Rectangle Square Gardens");

	@Test
	public void testEquals() {
		Act act2 = new Act(ActType.MUSICAL, "In The Dogs' Den");
		assertEquals(acta, act2);
	}
}
