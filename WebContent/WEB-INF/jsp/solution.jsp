<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Solution</title>
	</head>
	<body>
		<div id="map" style="width:100%;height:500px"></div>

		<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAZNPvpzLwgxnwDZQIhDPER5P_m2rCUjSw"></script>
		<script>

		function generateRandomColor(){
			var letters = '0123456789ABCDEF';
			var color = '#';
			for (var i = 0; i < 6; i++ ) {
				color += letters[Math.floor(Math.random() * 16)];
			}
			return color;
		}

		function myMap() {


			var bounds = new google.maps.LatLngBounds();
			var paths = [];
			<c:forEach var="i" begin="0" end="${startNb - 1}" step="1">
				paths[<c:out value="${i}" />] = [];
				<c:forEach items="${users[i].path[0].path}" var="item">
					var point = new google.maps.LatLng(<c:out value="${item.station.latitude}"/>, <c:out value="${item.station.longitude}"/>);
					paths[<c:out value="${i}"/>].push(point);
					bounds.extend(point);
				</c:forEach>
			</c:forEach>

		  var mapCanvas = document.getElementById("map");
		  var mapOptions = {
		    center: new google.maps.LatLng(46.819041,8.3638133),
		    zoom: 8
		  };
			var map = new google.maps.Map(mapCanvas, mapOptions);
			var lines = [];
			for (var i = 0; i < paths.length; i++) {
				var departure = paths[i][0];
				var infoWindow = new google.maps.InfoWindow({
					content: "TA MERE"
				})
				var marker = new google.maps.Marker({
					position: departure,
					title: "Departure for user "+i,//<c:out value="${users[i].name}" />,
					map: map
				});
				marker.addListener('click',function(){
					infoWindow.open(map,marker);
				});
				lines.push(new google.maps.Polyline({
			        path: paths[i],
			        strokeColor: generateRandomColor(),
			        strokeOpacity: 0.5,
			        strokeWeight: 4
	      		}));

				lines[i].setMap(map);
			}
			map.fitBounds(bounds);
		}

        google.maps.event.addDomListener(window, 'load', myMap);
		</script>
	</body>
</html>
