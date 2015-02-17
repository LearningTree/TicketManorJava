package com.ticketmanor.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.io.StringWriter;
import java.time.LocalDateTime;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketmanor.model.Act;
import com.ticketmanor.model.ActType;
import com.ticketmanor.model.Event;
import com.ticketmanor.model.Person;
import com.ticketmanor.model.Venue;

/** Test the serializer and deserializer through Jackson */
public class JacksonTest {
	ObjectMapper mapper = new ObjectMapper();

	@Test
	public void testPerson() throws Exception {
        String jsonInput =                                       // <2>
                "{\"id\":0,\"firstName\":\"Robin\",\"lastName\":\"Wilson\"}";
        Person q = mapper.readValue(jsonInput, Person.class);
        System.out.println("Read and parsed Person from JSON: " + q);

        Person p = new Person("Roger", "Rabbit");                // <3>
        StringWriter sout = new StringWriter();
        mapper.writeValue(sout, p);
        sout.close();
        String expected =
        	"{\"id\":0,\"firstName\":\"Roger\",\"middles\":null,\"lastName\":\"Rabbit\",\"email\":null,\"address\":null,\"fullName\":\"Roger Rabbit\"}";
        final String actual = sout.getBuffer().toString();
        System.out.println("Person object " + p +" as JSON = " + actual);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testEventToFromString() throws Exception {
		Act act = new Act(ActType.TROUPE, "The Flying Wallendas");
		LocalDateTime when = LocalDateTime.of(2015, 06, 01, 19, 00, 00);
		Venue where = new Venue("The Gardens");
		Event evt = new Event(act, when, where);
		StringWriter sout = new StringWriter();
		mapper.writeValue(sout, evt);
		sout.close();
		String result = sout.getBuffer().toString();
		System.out.println("Serialized Event is " + result);
		Event nEvt = mapper.readValue(result, Event.class);
		System.out.println("Reconstituted Event is " + nEvt);
		assertEquals(nEvt.getWhat().getTitle(), "The Flying Wallendas");
		assertSame(nEvt.getWhat().getType(), ActType.TROUPE);
	}
}
