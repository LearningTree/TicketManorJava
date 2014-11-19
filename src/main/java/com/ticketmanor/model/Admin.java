package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Admin - XXX
 */
@Entity
public class Admin extends Person  {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	// TODO
}
