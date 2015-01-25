package com.ticketmanor.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

//import org.glassfish.jersey.jackson.JacksonFeature;

import com.ticketmanor.model.Event;

/** This will become an example of the JAX-RS 2.0 Client API.
 * It has a dependency on Jersey (which is in our POM file now).
 * It is confused by some fields in the returned JSON data...
 * @author Ian Darwin
 */
public class JaxRsClientMain {

	private static final String URL = 
		"http://localhost:8080/ticketmanor/rest/events/-1";

	public static void main(String[] args) {
		Client cl = ClientBuilder.newClient();
		//cl.register(JacksonFeature.class);
		WebTarget target = cl.target(URL);
		Event e = target.request(MediaType.APPLICATION_JSON).get(Event.class);
		System.out.println("Got an event: " + e);
	}
}
