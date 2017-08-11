package com.doodle.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;

import MyBeans.Friend;
import MyBeans.Message;
import MyBeans.SortByDate;

public class DBMessage {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	
	private final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/myfriend?useSSL=false";
	private final String USER = "root";
	private final String PASS = "root";
	
	public DBMessage() {
		conn = null;
		pstmt = null;
		stmt =null;
	}
	
	public void open(){
		try{
			//Step1:
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			System.out.println("Connection estalished");
		}catch(ClassNotFoundException e){
			System.out.println("Exception: "+e);
		}catch(SQLException e){
			System.out.println("Exception: "+e);
		}
		
	}
	
	public void close(){
		try{
			if(conn!=null){
				conn.close();
			}
			
		}catch(SQLException e){
			System.out.println("Exception: "+e);
		}
	}
	

	public void insert(Message m){
		open();
		String insertNew = "Insert into message (username, username2, message,sender) values (?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertNew);
			pstmt.setString(1, m.getUsername());
			pstmt.setString(2, m.getUsername2());
			pstmt.setString(3, m.getMessage());
			pstmt.setString(4, m.getSender());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			close();
		}
		
	}
	
	public ArrayList<Message> findAllMessage(Friend f){
		open();
		ArrayList<Message> messages = new ArrayList<Message>();
		String findMessages = "Select * from message where username = '"+f.getUsername()+"' and username2 = '"+f.getUsername2() +"'";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(findMessages);
			while(rs.next()){
				Message m = new Message();
				m.setUsername(rs.getString("username"));
				m.setUsername(rs.getString("username2"));
				m.setMessage(rs.getString("message"));
				m.setChatdate(rs.getTimestamp("chatdate"));
				m.setSender(rs.getString("sender"));
				messages.add(m);
			}
			
			Collections.sort(messages, new SortByDate());
			stmt.close();
		} catch (SQLException e1) {
			System.out.println("Exception: "+e1);
		}finally{
			close();
		}
		
		
		return messages;
	}
}
