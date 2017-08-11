package com.doodle.bll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doodle.dao.*;

/**
 * Servlet implementation class EventServlet
 */
@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//define session 
		HttpSession session = request.getSession();
		//Check step
		if(request.getParameter("step1") != null){
			System.out.println(session.getAttribute("username"));
			Event event = new Event();
			event.setName(request.getParameter("eventName"));
			event.setDescription(request.getParameter("eventDescription"));
			event.setUser(DBManager.findUserByUsername((String) session.getAttribute("username")));
			event.setId(DBManager.addEventAndGetId(event));
			session.setAttribute("eventId", event.getId());
			System.out.println(session.getAttribute("eventId"));
			response.sendRedirect("select_dates.jsp");
		} else if(request.getParameter("step3") != null){
			String[] detailIds = request.getParameterValues("detailId");
			String[] detailStartTimes = request.getParameterValues("startTime");
			String[] detailEndTimes = request.getParameterValues("endTime");
			
			for(int i = 0; i< detailIds.length; i++){
				Detail detail = DBManager.findDetailById(Integer.parseInt(detailIds[i]));
				DBManager.deleteDetail(Integer.parseInt(detailIds[i]));
				detail.setStartTime(detailStartTimes[i]);
				detail.setEndTime(detailEndTimes[i]);
				DBManager.addDetail(detail);
			}
			response.sendRedirect("event_summary.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
