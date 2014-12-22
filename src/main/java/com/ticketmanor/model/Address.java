package com.ticketmanor.model;

import javax.persistence.*;

@Embeddable
public class Address {

	String street;
	String city;
	String state;
	String country;
	String postcode;
}
