package com.ticketmanor.rest.client;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;


//import org.glassfish.jersey.jackson.JacksonFeature;
import com.ticketmanor.model.Event;

/** 
 * Example client the JAX-RS 2.0 Client API.
 * It has a dependency on Jersey (which is in our POM file now).
 * It is confused by some fields in the returned JSON data...
 * @author Ian Darwin
 */
public class JaxRsClientMain {

	private static final String URL = 
		"http://localhost:8080/ticketmanor/rest/events/-1";
	private static final String AUTH_HEADER = "Authorization";
	static String auth_value;

	public static void main(String[] args) {
		auth_value = encodeAuth("robin", "secret54321");
		process();
	}
	
	private static String encodeAuth(String userName, String password) {
		String cred = userName + ":" + password;
		return new String(Base64.getEncoder().encode(cred.getBytes()));
	}
	
	public static Event process() {
		Client cl = ClientBuilder.newClient();
		cl.register(JacksonFeature.class);
		WebTarget target = cl.target(URL);
		Event e = target.request(MediaType.APPLICATION_JSON)
				.header(AUTH_HEADER, auth_value).get(Event.class);
		System.out.println("Got an event: " + e);
		return e;
	}
	
	public static Event process2() {
		Event e = ClientBuilder.newClient()
				.target(URL)
				.request(MediaType.APPLICATION_JSON)
				.header(AUTH_HEADER, "bar")
				.get(Event.class);
		System.out.println("Got an event: " + e);
		return e;
	}
}
