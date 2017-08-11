<%@ include file="header.jsp" %>

<%
	String userWelcome = "";
	String errorMessage = "";
	if(session.getAttribute("username") != null){
		userWelcome = session.getAttribute("username") + ", ";
	}
%>

<h1><%= userWelcome %> Welcome to Dudelle!</h1>

<hr>
<%
String fileName = "login_register.jsp";
if(session.getAttribute("username") != null){
	fileName = "user_menu.jsp";	
}else if(session.getAttribute("error") != null){
	out.println("<div class=\"logo alert alert-danger\">");
	out.println((String)session.getAttribute("error"));
	out.println("</div>");
	
	fileName = "login_register.jsp";
}else{
	fileName = "login_register.jsp";
}
%>
<jsp:include page='<%=fileName%>' flush="true" />
</body>
</html>