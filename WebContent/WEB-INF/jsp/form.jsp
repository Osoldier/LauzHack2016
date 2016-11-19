<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>TripHub : Search Engine</title>
	</head>
	<body>
		<c:if test="${not startSet}">
			<form method="get" action=".">
				<label for="Number of starts">Number of starts :</label>
		    	<input type="text" name="startNb" id="startNb" />
		      	<br />
		       	<input type="submit" value="Cul !" />
			</form>
		</c:if>
		<c:if test="${startSet}">
			<form method="post" action="request">
		    	<p>
					<fieldset>
						<legend>Starting Points:</legend>
						<c:forEach var="i" begin="0" end="${startNb - 1}" step="1">
				       		<label for="start${i}">Start :</label>
				       		<input type="text" name="start${i}" id="start${i}" />
						</c:forEach>
		       		</fieldset>
		       		<fieldset>
					    <legend>Other Shit:</legend>
			    		<label for="destination">Destination :</label>
			    		<input type="text" name="dest" id="dest" />
			      		<br />
			      	</fieldset>
			       		<input type="submit" value="Cul !" />
		       		<!-- ID OF FIELDS TO ADD TO THE FORM : -->
				 </p>
			</form>
		</c:if>
	</body>
</html>