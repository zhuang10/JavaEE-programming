package com.doodle.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the participant_event database table.
 * 
 */
@Entity
@Table(name="participant_event")
@NamedQuery(name="ParticipantEvent.findAll", query="SELECT p FROM ParticipantEvent p")
public class ParticipantEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="PARTICIPANT")
	private User user;

	public ParticipantEvent() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}