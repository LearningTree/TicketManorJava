package com.ticketmanor.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FeedbackForm implements Serializable {

	private static final long serialVersionUID = 590957238181679158L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	String custName;
	String custEmail;
	LocalDateTime date;
	String comment;
	
	/**
	 * @param id
	 * @param custName
	 * @param custEmail
	 * @param date
	 * @param comment
	 */
	public FeedbackForm(long id, String custName, String custEmail,
			LocalDateTime date, String comment) {
		super();
		this.id = id;
		this.custName = custName;
		this.custEmail = custEmail;
		this.date = date;
		this.comment = comment;
	}
	
	public FeedbackForm() {
		// Needed for APIs
	}

	public long getId() {
		return id;
	}

	private void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
