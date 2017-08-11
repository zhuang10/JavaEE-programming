package com.doodle.dao;

import java.sql.*;
import java.util.ArrayList;

import MyBeans.*;


public class DBFriend {
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	
	private final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/myfriend?useSSL=false";
	private final String USER = "root";
	private final String PASS = "root";
	
	public DBFriend() {
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
	
	public void insert(Friend e){
		open();
		String insertNew = "Insert into friend (username, username2, status) values (?,?,?)";
		try {
			pstmt = conn.prepareStatement(insertNew);
			pstmt.setString(1, e.getUsername());
			pstmt.setString(2, e.getUsername2());
			pstmt.setInt(3, e.getStatus());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			close();
		}
		
	}
	
	public void Delete(String friendname,String username){
		open();
		String deleteNew = "Delete From friend where username=? and username2=?";

		try {
			pstmt = conn.prepareStatement(deleteNew);
			pstmt.setString(1, username);
			pstmt.setString(2, friendname);
			pstmt.executeUpdate();

			pstmt.setString(1, friendname);
			pstmt.setString(2, username);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}finally{
			close();
			
		}

	}
	
	public Friend checkRequest(String friendname, String username){ //Check friend
		open();
		Friend friend = new Friend();
		String checkUsername = "Select username, username2 from friend where username = '"+friendname+"' and  username2 = '"+username+"'";
		String checkUsername2 = "Select username, username2 from friend where username = '"+username+"' and  username2 = '"+friendname+"'";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(checkUsername);
			while(rs.next()){
				friend.setUsername(rs.getString("username"));
				friend.setUsername2(rs.getString("username2"));
			}
			if(friend.getUsername()==null||friend.getUsername2()==null){
				ResultSet rs2 = stmt.executeQuery(checkUsername2);
				while(rs2.next()){
					friend.setUsername(rs2.getString("username"));
					friend.setUsername2(rs2.getString("username2"));
				}
			}
			stmt.close();	
		} catch (SQLException e1) {
			System.out.println("Exception: "+e1);
		}finally{
			close();
		}
		
		return friend;
	}
	
	public Friend findfriend(String friendname){ //Chenck User
		open();
		Friend friend = new Friend();
		String selectRecords = "Select username from user where username = '"+friendname+"'";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(selectRecords);
			while(rs.next()){
				friend.setUsername2(rs.getString("username"));
			}
			stmt.close();	
		} catch (SQLException e1) {
			System.out.println("Exception: "+e1);
		}finally{
			close();
		}
		
		return friend;
	}
	
	public ArrayList<Friend> findAllfriend(String username){
		open();
		ArrayList<Friend> allfriends = new ArrayList<Friend>();
		String FromUsername = "Select * from friend where username = '"+username+"'";
		String FromUsername2 = "Select * from friend where username2 = '"+username+"'";
		Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(FromUsername);
			while(rs.next()){
				Friend friend = new Friend();
				friend.setUsername(rs.getString("username"));
				friend.setUsername2(rs.getString("username2"));
				friend.setStatus(rs.getInt("status"));
				allfriends.add(friend);
			}
			ResultSet rs2 = stmt.executeQuery(FromUsername2);
			while(rs2.next()){
				
				Friend friend = new Friend();
				friend.setUsername(rs2.getString("username2"));
				friend.setUsername2(rs2.getString("username"));
				friend.setStatus(rs2.getInt("status"));
				allfriends.add(friend);
				
			}
			stmt.close();	
		} catch (SQLException e1) {
			System.out.println("Exception: "+e1);
		}finally{
			close();
		}
		
		return allfriends;
	}
	
	public void UpdateStatus(String friendname, String username) {
		open();
		String uploadstatus = "update friend set status = ? where username = ? and username2 = ?";

		try {	
			pstmt = conn.prepareStatement(uploadstatus);
			pstmt.setInt(1, 1);
			pstmt.setString(2, friendname);
			pstmt.setString(3, username);
			pstmt.executeUpdate();

			pstmt.setInt(1, 1);
			pstmt.setString(2, username);
			pstmt.setString(3, friendname);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("Exception " + e);
		} finally {
			close();
		}
	}

}
