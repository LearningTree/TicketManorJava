package com.ticketmanor.jpa;

import java.time.LocalDateTime;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ticketmanor.model.Act;
import com.ticketmanor.model.ActType;
import com.ticketmanor.model.Event;
import com.ticketmanor.model.Venue;

/** 
 * The EJB JPA portion of "Load some fake data". 
 * @author Ian Darwin
 */
@Stateless
public class FakeDataLoaderEjb {

	@PersistenceContext EntityManager em;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void loadFakeData() {
		System.out.println("FakeDataLoaderEjb.loadFakeData()");
		Act act = new Act();
		act.setTitle("Sun Never Sets: The Musical");
		act.setType(ActType.MUSICAL);
		em.persist(act);
		Venue venue = em.find(Venue.class, 1L);
		
		LocalDateTime start = LocalDateTime.now();
		for (int i = 0; i < 100; i+=2) {
			Event ev = new Event(act, start.plusDays(i), venue);
			em.persist(ev);
		}
	}
}
