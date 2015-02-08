package com.ticketmanor.model;

import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/*
 * Order - An order is one or more Tickets for one Member (a.k.a. "customer")
 */
@XmlRootElement
@Entity @Table(name="orders")
public class Order   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@ManyToOne
	Member member;
	@OneToMany
	List<OrderItem> items = new ArrayList<>();
}
