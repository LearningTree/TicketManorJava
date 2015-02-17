package com.ticketmanor.test;

import java.io.StringWriter;
import java.time.LocalDateTime;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

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
        System.out.print("Person object " + p +" as JSON = ");
        mapper.writeValue(System.out, p);
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
		System.out.println("Converted value is " + result);
		Event nEvt = mapper.readValue(result, Event.class);
		System.out.println("Reconstituted Event is " + nEvt);
	}
}
