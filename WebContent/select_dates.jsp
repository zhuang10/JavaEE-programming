<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Select dates</title>
		
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
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/lang-css.js"></script>
		<script type="text/javascript" src="js/myjs.js"></script>
	</head>
	<body>
		<div id="page">			
			<div id="demos">
				<h2>Step 1: Select the event dates</h2>
				<div class="alert alert-info fade in">
        			<a href="#" class="close" data-dismiss="alert">&times;</a>
        			<strong>Note!</strong> You can select multiple dates.
    			</div>
					<ul id="demos-list">
						<li class="demo first">
						<form action="DatePickerServlet" id="datepickerform">
							<div id="simpliest-usage" class="box"></div>
							<center><input class="btn btn-default" type="submit" value="Select Dates" /></center>
							<br>

						</form>
						</li>	
						<jsp:include page="dates_panel.jsp"/>		
					</ul>
				<div class="clear"></div>
			</div>
			<center><a href="select_times.jsp"><input class="btn btn-default" type="submit" value="Next Step" /></a></center>
		</div>
		

		
		<!-- -----------------------------------  -->
		
	</body>
</html>