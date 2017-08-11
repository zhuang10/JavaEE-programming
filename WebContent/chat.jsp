<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.util.*, com.doodle.dao.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
<link rel="stylesheet" type="text/css" href="css/chatstyle.css">
</head>
<body>
	<%
		DBAvatar db_a = new DBAvatar();
	%>
	<div id="chat">
	<div class="sidebar">
		<div class="m-card">
			<header>
				<a href="Avatar.jsp"><img class="avatar" width="40" height="40" alt="Coffce" src= <%=db_a.findImage((String) session.getAttribute("username"))%>></a>
				<p class="name">Coffee</p>
			</header>
			<footer>
				<form action="ContactServlet">
					<input type="text" name="name" class="search" placeholder="search user..."/>
					<input type="submit" name="BtnFriend" value="AddFriend"/> 
				</form>
			</footer>
		</div>
		
		<div class="m-list">
			<ul>
				<%
					DBFriend db = new DBFriend();
					ArrayList<Friend> allFriend = new ArrayList<Friend>();
					allFriend = db.findAllfriend((String)session.getAttribute("username"));
					if(allFriend !=null){
						for(Friend f : allFriend){
							if(f.getStatus() == 1){
								out.println("<li class=\"active\">"+
											"<img class=\"avatar\" width=\"30\" height=\"30\" alt=\"example\" src="+db_a.findImage(f.getUsername2())+">"+
											"<p class=\"name\">"+f.getUsername2()+"</p>"+
											"<form action=\"ContactServlet\">"+
											"<input type=\"hidden\" name=\"friendname\" value="+f.getUsername2()+" />"+
											"<input type=\"submit\" name=\"BtnFriend\" value=\"Delete\" />"+
											"<input type=\"submit\" name=\"BtnFriend\" value=\"Chat\" />"+
											"</form>"+
											"</li>");				
							}
						}
				}
				
				%>
			</ul>
		</div>
	</div>
	
	<div class="main">
		<div class="m-message">
			<ul class="list_message"><!--v-for-start-->
				<%
				String display_message = "";
				if(session.getAttribute("c_friendname")!=null){
					DBMessage m_db =new DBMessage();
					Friend choose_f = db.checkRequest((String)session.getAttribute("username"), (String)session.getAttribute("c_friendname"));
					System.out.println((String)session.getAttribute("username") +":"+(String)session.getAttribute("friendname"));
					System.out.println(choose_f.getUsername() +":"+choose_f.getUsername2());
					ArrayList<Message> messages = new ArrayList<Message>();
					messages = m_db.findAllMessage(choose_f);
					for(Message m: messages){
						if(m.getSender().equals((String)session.getAttribute("username"))){
							display_message += "<li>"+
											   "<p class=\"time\"><span>"+m.getFormatChatdate()+"</span></p>"+
											   "<div class=\"main  self\">"+
											   "<img class=\"avatar\" width=\"30\" height=\"30\" src=\"dist/images/2.png\">"+
											   "<div class=\"text\">"+m.getMessage()+"</div>"+
											   "</div>"+
											   "</li>";
							
						}else if(m.getSender().equals((String)session.getAttribute("c_friendname"))){
							display_message +=  "<li>"+
									  			"<p class=\"time\"><span>"+m.getFormatChatdate()+"</span></p>"+
									   			"<div class=\"main\">"+
											    "<img class=\"avatar\" width=\"30\" height=\"30\" src=\"dist/images/2.png\">"+
											    "<div class=\"text\">"+m.getMessage()+"</div>"+
										   	    "</div>"+
											    "</li>";

						}
					}
				}
				out.println(display_message);
				%>
			</ul>
		</div>
		<div class="m-text">
			<form action= "MessageServlet" method= "POST" class="m_form">
				<textarea name="message" placeholder="Enter text here"></textarea>
			<input type="submit" value="send" />
			</form>
		</div>
	
	</div>
	<footer>
		<%
		ArrayList<Friend> allFriends = new ArrayList<Friend>();
		allFriends = db.findAllfriend((String)session.getAttribute("username"));
		if(allFriends !=null){
			for(Friend f : allFriends){	
				if(f.getStatus() == 0 && f.getUsername().equals(session.getAttribute("username"))){
						out.println("<p>"+ f.getUsername()+"</p>");
						out.println("<form method=\"GET\" action=\"ContactServlet\">"+
						"<p>Do you want add "+f.getUsername2()+"</p>"+
						"<img class=\"avatar\" width=\"30\" height=\"30\" alt=\"example\" src="+db_a.findImage(f.getUsername2())+">"+
						"<input type=\"hidden\" name=\"friendname\" value="+f.getUsername2()+" />"+
						"<input type=\"submit\" name=\"BtnFriend\" value=\"YesFriend\" />"+
						"<input type=\"submit\" name=\"BtnFriend\" value=\"NoFriend\" />"+
						"</form>"
						);					
				}
			}
		}
		%>
	</footer>
	
</div>
<%
int isExist = -1;
if(session.getAttribute("isExist")!=null){
	isExist = Integer.parseInt(session.getAttribute("isExist").toString());
}

%>

	<script type="text/javascript">
		var isExist = <%=isExist%>;
		if(isExist == 0){
			alert('We do not find this username');
		}else if(isExist == 1){
			alert('You already have this friend');
		}else if(isExist == 2){
			alert('You canndot add yourself');
		}else if(isExist == 3){
			alert('The request send succeed');
		}
		
	 	$(document).ready(function(){ 
				//$(".list_message").empty();
				var text ="<div></div>";
				$(".m_form").remove("#friendname");
				var friendname =$(".active").children("p").text();
				var hiddenFriend = "<input type=\"hidden\" name=\"friendname\" value="+friendname+" id=\"friendname\" />";
				$(".m_form").append(hiddenFriend);
				
				
				$(".list_message").append($(".display_message").text());
		});
	</script>
</body>
</html>