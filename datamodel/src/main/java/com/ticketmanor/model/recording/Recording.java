package com.ticketmanor.model.recording;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import com.ticketmanor.model.Sellable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Recording extends Sellable implements Serializable {

	private static final long serialVersionUID = 129287912L;
	protected String title;
	int version;
	
	public Recording() {
		// Empty constructor needed for JPA
	}
	
	@Version
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public abstract Duration getDuration();
	public void setDuration(Duration d) {
		// System.err.println("Lame-but-required method called");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title;
	}
}
