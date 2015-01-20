package com.ticketmanor.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaDemo {
	public static void main(String[] args) {
		EntityManagerFactory entityMgrFactory = Persistence.createEntityManagerFactory("ticketManor");
		EntityManager entityManager = entityMgrFactory.createEntityManager();
		for (Object o : entityManager.createQuery("from Event").getResultList()) {
			System.out.println(o);
		}
	}
}
