package com.ticketmanor.jpa;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/** Load some fake data. Tried to make this a Singleton EJB
 * but WildFly didn't run its @PostConstruct method.
 * @author Ian Darwin
 */
@WebListener
public class FakeDataLoaderListener implements ServletContextListener {

	@EJB FakeDataLoaderEjb ejb;
	
	@Override
	public void contextInitialized(ServletContextEvent ctx) {
		System.out.println("FakeEventLoader: servlet context initialized()");
		ejb.loadFakeData();
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// Empty
	}
}
