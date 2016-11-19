<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>TripHub : Search Engine</title>
	</head>
	<body>
		<form method="post" action="request">
	    	<p>
	    		<label for="destination">Destination :</label>
	    		<input type="text" name="dest" id="dest" />
	      		<br />
	       		<label for="start">Start :</label>
	       		<input type="text" name="start" id="start" />
	       		<br />
	       		<input type="submit" value="Cul !" />
	       		<!-- ID OF FIELDS TO ADD TO THE FORM : -->
			 </p>
		</form>
	</body>
</html>