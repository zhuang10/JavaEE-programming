package com.doodle.dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAvatar {
private Connection conn;
	
	private final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/myfriend?useSSL=false";
	private final String USER = "root";
	private final String PASS = "root";
	
	
	public DBAvatar() {
		this.conn = null;
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
	
	public void update(InputStream image,String username){
		open();
		String insertNew = "Update user set avatar =(?) where username = (?)";
		try {
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(insertNew);
			if(image!= null){
				pstmt.setBlob(1, image);
			}
			pstmt.setString(2, username);
			int row = pstmt.executeUpdate();
			if (row > 0) {
               System.out.println("Image is uploaded successfully into the Database");
            }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}finally{
			close();
		}
		
	}
	
	public String findImage(String username){
		open();
		String path ="img/noavatar.png";
		PreparedStatement pstmt =null;
		ResultSet rs =null;
		byte[] b = null;
		try{
			String selectRecords = "Select avatar from user where username = (?)";
			pstmt = conn.prepareStatement(selectRecords);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				Blob test = rs.getBlob("avatar");
				InputStream x = test.getBinaryStream();
				int size = x.available();
				path ="U://"+username+".png";
				OutputStream out = new FileOutputStream(path);
				b = new byte[size];
				x.read(b);
				out.write(b);
			}
		}catch(Exception e){
			System.out.println("Exceprion"+e);
			System.out.println("this user do not have avatar");
		}finally{
			close();
		}
		return path;
	}
}
