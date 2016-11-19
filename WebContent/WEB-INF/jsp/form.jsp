<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<fieldset>
				<legend>General Shit:</legend>
				<c:if test="${errorDest}">
					<small style="color: red;">Please give a destination</small>
					<br />
				</c:if>
				<c:if test="${errorDate}">
					<small style="color: red;">Please give at least a starting point</small>
					<br />
				</c:if>
				<label for="destination">Destination :</label> 
				<input type="text" name="dest" id="dest" />
				<label for="date">Date of travel:</label>
				<input type="date" name="date" id="date" />
				<br />
			</fieldset>
			<fieldset>
				<legend>User info:</legend>	
				<c:if test="${errorStart}">
					<small style="color: red;">Please fill all location fields</small>
					<br />
				</c:if>
				<c:if test="${errorTime}">
					<small style="color: red;">Please fill all time fields</small>
					<br />
				</c:if>
				<c:if test="${errorName}">
					<small style="color: red;">Please fill all names</small>
					<br />
				</c:if>
				<c:forEach var="i" begin="0" end="${startNb - 1}" step="1">
					<p>User #<c:out value="${i + 1}" /></p>
					<label for="name${i}" style="margin:20px;align:left;">Name :</label>
					<input type="text" name="name" id="name${i}" />
					<br />
					<label for="start${i}" style="margin:20px;align:left;">Start :</label>
					<input type="text" name="start" id="start${i}" />
					<br />
					<label for="time${i}" style="margin:20px;align:left;">At :</label>
					<input type="time" name="time" id="time${i}" />
					<br />
				</c:forEach>
			</fieldset>
			<input type="submit" value="Cul !" />
			<!-- ID OF FIELDS TO ADD TO THE FORM : -->
			</p>
		</form>
	</c:if>
</body>
</html>