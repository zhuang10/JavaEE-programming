<%@ page import="java.util.*, com.doodle.dao.*" %>

<%
	List<Detail> allDatesClean = DBManager.findAllDetails();
	List<Detail> eventDates = new ArrayList<Detail>();
	if(session.getAttribute("eventId") != null){	
		for(Detail d : allDatesClean){
			if(d.getEvent().getId() == (Integer)session.getAttribute("eventId")){
				eventDates.add(d);
			}
		}
	}
	
%>

<li class="demo first">
	<div id="dates-display">
	<h3>Dates selected: </h3>
	<% 
		if(eventDates != null){
		
			for(Detail d : eventDates){
				
		        out.print("<form action = \"DeleteDetail\">");
		        out.print("<input type=\"hidden\" name=\"detailId\" value=\"" + d.getId() + "\"><br>");
		        out.print("<button type=\"submit\"><span class=\"glyphicon glyphicon-trash\"></span></button>");      
		        out.print(" " + d.getDate() + "<br>");
		        out.print("</form>");
				
				
		
			}
		}
	%>
	
	</div>
</li>