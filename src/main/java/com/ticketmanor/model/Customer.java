package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Customer - XXX
 */
@Entity
public class Customer extends Person  {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
