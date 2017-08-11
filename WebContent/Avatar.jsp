<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Avatar</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/chatstyle.css">
</head>
<body>
<div id="chat">
	
	<div class="main">
		<a href="chat.jsp">Back</a>
		<form method="POST" action="AvatarServlet" enctype="multipart/form-data">
			<input type="file" name= "photo"/>
			<input type="submit" value="Submit">
		</form>
	</div>
	<script>
	<%
	if(session.getAttribute("imageError")!=null){
		if(((String)session.getAttribute("imageError")).equals("You just can put png.")){
			%>
			alert("You just can put png.");
			<%
			
		}else if(((String)session.getAttribute("imageError")).equals("You need put png file")){
			%>
			alert("You need put png file");
			<%
		}
	}
	%>
	</script>
	<%
	session.removeAttribute("imageError");
	System.out.println(session.getAttribute("imageError"));
	%>
</div>
</body>
</html>