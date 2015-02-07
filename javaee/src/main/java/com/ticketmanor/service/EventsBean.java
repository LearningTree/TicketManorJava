package com.ticketmanor.service;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ticketmanor.model.Event;

@ManagedBean
public class EventsBean {

	@EJB
	EventsEjb ejb;
	
	private int nDays;
	
	public List<Event> getEventsNextNDays() {
		return ejb.getEventsNextNDays(nDays);
	}
}
