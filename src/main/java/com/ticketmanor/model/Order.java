package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Order - XXX
 */
@Entity @Table(name="Orders")
public class Order   {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
