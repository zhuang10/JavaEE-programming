package com.doodle.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Message{
	private String username;
	private String username2;
	private String message;
	private Date chatdate;
	private String sender;
	public Message() {
	}
	

	public Message(String username, String username2, String message, String sender) {
		this.username = username;
		this.username2 = username2;
		this.message = message;
		this.sender = sender;
	}


	public String getUsername() {
		return username;
	}
	

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername2() {
		return username2;
	}
	
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getChatdate() {
		return chatdate;
	}
	
	public void setChatdate(Date chatdate) {
		this.chatdate = chatdate;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getFormatChatdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(chatdate);
	}
}
