package com.doodle.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Detail
	@OneToMany(mappedBy="event")
	private List<Detail> details;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="ORGANIZER")
	private User user;

	//bi-directional many-to-one association to ParticipantEvent
	@OneToMany(mappedBy="event")
	private List<ParticipantEvent> participantEvents;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Detail> getDetails() {
		return this.details;
	}

	public void setDetails(List<Detail> details) {
		this.details = details;
	}

	public Detail addDetail(Detail detail) {
		getDetails().add(detail);
		detail.setEvent(this);

		return detail;
	}

	public Detail removeDetail(Detail detail) {
		getDetails().remove(detail);
		detail.setEvent(null);

		return detail;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ParticipantEvent> getParticipantEvents() {
		return this.participantEvents;
	}

	public void setParticipantEvents(List<ParticipantEvent> participantEvents) {
		this.participantEvents = participantEvents;
	}

	public ParticipantEvent addParticipantEvent(ParticipantEvent participantEvent) {
		getParticipantEvents().add(participantEvent);
		participantEvent.setEvent(this);

		return participantEvent;
	}

	public ParticipantEvent removeParticipantEvent(ParticipantEvent participantEvent) {
		getParticipantEvents().remove(participantEvent);
		participantEvent.setEvent(null);

		return participantEvent;
	}

}