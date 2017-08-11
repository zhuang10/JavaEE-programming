<%@ include file="header.jsp" %>

		<form action="EventServlet">
			<div id="page">			
				<div id="demos">
					<h2>Step 1: Give your event a description</h2>
						<ul id="demos-list">
							<li class="demo full-row">
								<p class="description">
									<label>Event Name:</label> <input type="text" name="eventName"/>
								</p>
								<p class="description">
									<label>Event Description:</label><br><textarea rows="15" cols="90" name="eventDescription">test</textarea>
								</p>
							</li>	
						</ul>
					<div class="clear"></div>
				</div>
				<input class="btn btn-default" type="submit" name="step1" value="NEXT">
			</div>
		</form>
	</body>
</html>