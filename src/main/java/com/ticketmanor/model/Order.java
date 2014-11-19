package com.ticketmanor.model;

import java.util.*;
import javax.persistence.*;

/*
 * Order - An order is one or more Tickets for one Customer
 */
@Entity @Table(name="Orders")
public class Order   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@ManyToOne
	Customer customer;
	@OneToMany
	List<Ticket> tickets = new ArrayList<>();
}
