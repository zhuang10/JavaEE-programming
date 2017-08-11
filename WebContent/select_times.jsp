<%@ page import="java.util.*, com.doodle.dao.*" %>


<% 
List<Detail> allDatesClean = DBManager.findAllDetails();
List<Detail> storedDetails = new ArrayList<Detail>();
if(session.getAttribute("eventId") != null){	
	for(Detail d : allDatesClean){
		if(d.getEvent().getId() == (Integer)session.getAttribute("eventId")){
			storedDetails.add(d);
		}
	}
}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Select Event Times</title>
		<!-- loads jquery and jquery ui -->
		<!-- -->
		<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
		<!-->
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
		<!-- -->
		<script type="text/javascript" src="jquery-ui.multidatespicker.js"></script>
		<script type="text/javascript"></script>
		
		<!-- loads some utilities (not needed for your developments) -->
		<link rel="stylesheet" type="text/css" href="css/mdp.css">
		<link rel="stylesheet" type="text/css" href="css/prettify.css">
		<script type="text/javascript" src="js/prettify.js"></script>
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/lang-css.js"></script>
		<script type="text/javascript" src="js/myjs.js"></script>
	</head>
	<body>
		<div id="page">			
			<div id="demos">
				<h2>Step 2: Select the time</h2>
					<ul id="demos-list">
						<li class="demo full-row">
<form action="EventServlet">
		<table class="table">
			<tr>
				<th>Event Date</th>
				<th>Start Time</th>
				<th>End Time</th>
			</tr>
			
			<%
				if(storedDetails != null){
					
					for(Detail detail : storedDetails){
						out.print("<tr>");
						out.print("<input type=\"hidden\" name=\"detailId\" value=\"" + detail.getId() + "\">");
						out.print("<td>" + detail.getDate() + "</td>");
						out.print("<td><input type=\"text\" name=\"startTime\"></td>");
						out.print("<td><input type=\"text\" name=\"endTime\"></td>");
						out.print("</tr>");
					}
				}
			%>
		</table>


						</li>	
					</ul>
				<div class="clear"></div>
			</div>
			
			<center><input class="btn btn-default" type="submit" name="step3" value="Create Event" /></center>
</form>
		</div>
		

		
		<!-- -----------------------------------  -->
		
	</body>
</html>