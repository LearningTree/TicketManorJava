package com.ticketmanor.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class PersonTest {

	@Test
	public void test() {
		Person p = new Person("Jon", "Jonez");
		assertEquals("full name 2", "Jon Jonez", p.getFullName());
		p.middles = "F.";
		assertEquals("full name 3", "Jon F. Jonez", p.getFullName());
	}

}
