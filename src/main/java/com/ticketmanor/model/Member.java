package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Member - A Person who has signed up for the site.
 */
@Entity
public class Member extends Person  {
	// the id property is inherited

	/** The profile photo. A full-blown UI should support uploading this. */
	private byte[] profilePhoto;
}
