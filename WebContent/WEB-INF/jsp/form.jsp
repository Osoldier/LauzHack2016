<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TripHub</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<script src="js/init.js"></script>
<noscript>
    <link rel="stylesheet" href="css/skel.css" />
    <link rel="stylesheet" href="css/style.css" />
    <link rel="stylesheet" href="css/style-xlarge.css" />
</noscript>
</head>
<body class="landing">

    <header id="header">
        <h1><a href="index.html">TripHub</a></h1>
    </header>

    <!-- Banner -->
        <section id="banner">
            <h2>Hi. This is TripHub.</h2>
            <p>A way to make your travels more social</p>
        </section>

        <!-- One -->
        <section id="one" class="wrapper style1 special">
            <div class="container">
                <header class="major">
                    <h2>First of all, please fill up the infos</h2>
                </header>
                <div class="row 150%">
                    <c:if test="${not startSet}">
                		<form method="get" action=".">
                			<label for="Number of starts">Number of starts :</label>
                			<input type="text" name="startNb" id="startNb" />
                			<br />
                    		<input type="submit" value="Proceed" />
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
                            <input type="submit" value="Submit" />
                            <!-- ID OF FIELDS TO ADD TO THE FORM : -->
                            </p>
                        </form>
                    </c:if>
                </div>
            </div>
        </section>
</body>
</html>
