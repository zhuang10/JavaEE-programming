<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1" import="java.util.*, com.doodle.bll.*, com.doodle.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Dudelle</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/myjs.js"></script>

<!-- loads jquery and jquery ui -->
<!-- -->
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
<!-->
		<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.11.1.js"></script>
		<!-- -->
<script type="text/javascript" src="jquery-ui.multidatespicker.js"></script>
<script type="text/javascript">
		<!--
			var latestMDPver = $.ui.multiDatesPicker.version;
			var lastMDPupdate = '2014-09-19';
			
			$(function() {
				// Version //
				//$('title').append(' v' + latestMDPver);
				$('.mdp-version').text('v' + latestMDPver);
				$('#mdp-title').attr('title', 'last update: ' + lastMDPupdate);
				
				// Documentation //
				$('i:contains(type)').attr('title', '[Optional] accepted values are: "allowed" [default]; "disabled".');
				$('i:contains(format)').attr('title', '[Optional] accepted values are: "string" [default]; "object".');
				$('#how-to h4').each(function () {
					var a = $(this).closest('li').attr('id');
					$(this).wrap('<'+'a href="#'+a+'"></'+'a>');
				});
				$('#demos .demo').each(function () {
					var id = $(this).find('.box').attr('id') + '-demo';
					$(this).attr('id', id)
						.find('h3').wrapInner('<'+'a href="#'+id+'"></'+'a>');
				});
				
				// Run Demos
				$('.demo .code').each(function() {
					eval($(this).attr('title','NEW: edit this code and test it!').text());
					this.contentEditable = true;
				}).focus(function() {
					if(!$(this).next().hasClass('test'))
						$(this)
							.after('<button class="test">test</button>')
							.next('.test').click(function() {
								$(this).closest('.demo').find('.hasDatepicker').multiDatesPicker('destroy');
								eval($(this).prev().text());
								$(this).remove();
							});
				});
			});
		// -->
		</script>

<!-- loads some utilities (not needed for your developments) -->
<link rel="stylesheet" type="text/css" href="css/mdp.css">
<link rel="stylesheet" type="text/css" href="css/prettify.css">
<script type="text/javascript" src="js/prettify.js"></script>
<script type="text/javascript" src="js/lang-css.js"></script>
<script type="text/javascript" src="js/myjs.js"></script>
</head>
<body>