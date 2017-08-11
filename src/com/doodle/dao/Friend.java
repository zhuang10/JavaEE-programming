package com.doodle.dao;

public class Friend {
	private String username2;
	private String username;
	private int status;
	
	public Friend() {
		status = 0;
	}

	public String getUsername2() {
		return username2;
	}

	public void setUsername2(String friendname) {
		this.username2 = friendname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
