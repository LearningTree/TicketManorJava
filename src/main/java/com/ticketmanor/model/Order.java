package com.ticketmanor.model;

import java.util.*;
import javax.persistence.*;

/*
 * Order - An order is one or more Tickets for one Member (a.k.a. "customer")
 */
@Entity @Table(name="Orders")
public class Order   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@ManyToOne
	Member member;
	@OneToMany
	List<Ticket> tickets = new ArrayList<>();
}
