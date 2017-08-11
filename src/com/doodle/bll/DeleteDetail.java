package com.doodle.bll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doodle.dao.DBManager;

/**
 * Servlet implementation class DeleteDetail
 */
@WebServlet("/DeleteDetail")
public class DeleteDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteDetail() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBManager.deleteDetail(Integer.parseInt(request.getParameter("detailId")));
		response.sendRedirect("select_dates.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
