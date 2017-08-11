package com.doodle.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detail database table.
 * 
 */
@Entity
@NamedQuery(name="Detail.findAll", query="SELECT d FROM Detail d")
public class Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String date;

	@Column(name="end_time")
	private String endTime;

	@Column(name="start_time")
	private String startTime;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	public Detail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}