package com.doodle.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private Blob avatar;

	private String password;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user")
	private List<Event> events;

	//bi-directional many-to-one association to ParticipantEvent
	@OneToMany(mappedBy="user")
	private List<ParticipantEvent> participantEvents;

	public User() {
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Blob getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Blob avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}

	public List<ParticipantEvent> getParticipantEvents() {
		return this.participantEvents;
	}

	public void setParticipantEvents(List<ParticipantEvent> participantEvents) {
		this.participantEvents = participantEvents;
	}

	public ParticipantEvent addParticipantEvent(ParticipantEvent participantEvent) {
		getParticipantEvents().add(participantEvent);
		participantEvent.setUser(this);

		return participantEvent;
	}

	public ParticipantEvent removeParticipantEvent(ParticipantEvent participantEvent) {
		getParticipantEvents().remove(participantEvent);
		participantEvent.setUser(null);

		return participantEvent;
	}

}