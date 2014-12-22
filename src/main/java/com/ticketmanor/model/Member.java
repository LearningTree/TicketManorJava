package com.ticketmanor.model;

import javax.persistence.*;

/*
 * Member - A Person who has signed up for the site.
 */
@Entity
public class Member extends Person  {
	// the id property is inherited

	/** The profile photo. A full implementation of the UI will support uploading this. */
	private byte[] profilePhoto;
}
