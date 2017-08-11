<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
	import="java.util.*, com.doodle.dao.*"    
%>


<% 
Event event = null;
List<Detail> storedDetails = null;
List<User> users = DBManager.findAllUsers();
if(session.getAttribute("eventId") != null){
	event = DBManager.findEventById((Integer)session.getAttribute("eventId"));
	List<Detail> allDetails = DBManager.findAllDetails();
	storedDetails = new ArrayList<Detail>();
	for(Detail d : allDetails){
		if(d.getEvent().getId() == event.getId()){
			storedDetails.add(d);
		}
	}
}
%>    

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/mdp.css">
<link rel="stylesheet" type="text/css" href="css/prettify.css">
<script type="text/javascript" src="js/prettify.js"></script>
<script type="text/javascript" src="js/lang-css.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Event Summary</title>
</head>
<body>
		<div id="page">			
			<div id="demos">
				<h2>Event Summary</h2>
					<ul id="demos-list">
						<li class="demo full-row">
						
						<table class="table">
							<tr>
								<td>Event Name</td>
								<td><%= event.getName() %></td>
							</tr>
							<tr>
								<td>Event Description</td>
								<td><%= event.getDescription() %></td>
							</tr>
							<tr>
								<td>Chosen dates</td>
								<td><ul>
								<%
								if(storedDetails != null){
					
									for(Detail detail : storedDetails){
										out.print("<li>");
										out.print(detail.getDate() + " from " + detail.getStartTime() + " to " + detail.getEndTime());
										out.print("</li>");
									}
								}
								%>
								</ul></td>
							</tr>
							
						</table>
						
						</li>
					</ul>
					<div class="clear"></div>					
			</div>
		</div>
		
		<div id="page">			
			<div id="demos">
				<h2>Invite Participants</h2>
					<ul id="demos-list">
						<li class="demo full-row">
						
						<!-- insert checkbox and participants usename for each person in user table in table -->
						<form action = "AddParticipants">
							<%
							for(User u : users){
								if(!u.getUsername().equals((String)session.getAttribute("username"))){
									out.println("<div class=\"checkbox\">");
									out.println("<label><input type=\"checkbox\" name=\"userParticipation\" value=\"" + u.getUsername() + "\">" + u.getUsername() + "</label>");
									out.println("</div>");
								}
							}
							%>
						</form>
						</li>
					</ul>
					<a href="user_choice.jsp">Test</a>
					<div class="clear"></div>	
									
			</div>
		</div>
		<a href="user_choice.jsp">Test</a>
		
</body>
</html>