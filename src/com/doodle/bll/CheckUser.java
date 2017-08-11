package com.doodle.bll;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doodle.dao.*;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("btn"));
		//define session 
		HttpSession session = request.getSession();
		//if sign in
		if(request.getParameter("btn").toLowerCase().equals("sign in")){
			//System.out.println(request.getParameter("usernameIn"));
			User user = new User();
			user.setUsername(request.getParameter("usernameIn"));
			user.setPassword(request.getParameter("passwordIn"));
			if(DBManager.findUserByUsername(user.getUsername(), user.getPassword()) != null){
				session.setAttribute("username", user.getUsername());
			}
			else{
				session.setAttribute("error", "username or password incorrect");
			}
		}else if(request.getParameter("btn").toLowerCase().equals("sign up")){
			User user = new User();
			user.setUsername(request.getParameter("usernameUp"));
			user.setPassword(request.getParameter("passwordUp"));
			if(user.getUsername().length() < 7 || user.getPassword().length() < 7){
				session.setAttribute("error", "Password and username must have more than 6 characters");
			}
			else if(DBManager.findUserByUsername(user.getUsername()) == null){
				DBManager.addUser(user);
				session.setAttribute("username", user.getUsername());
			}
			else{
				session.setAttribute("error", "user already exists");
			}
		} else {
			session.removeAttribute("username");
			if(session.getAttribute("error") != null)
				session.removeAttribute("error");
		}
		response.sendRedirect("index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
