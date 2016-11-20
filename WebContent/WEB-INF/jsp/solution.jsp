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

		<script>

		function myMap() {

			var bounds = new google.maps.LatLngBounds();
			var paths = array();
			//EN java
			//for(i -> chaque user)
			//	paths[i] = array()
			//	for(j -> chaque point du path de l'user i)
			//		paths[i][j].push(new google.maps.LatLng(point.latitude, point.longitude));
			//		bounds.extend(array[i][j])
			//  endfor
			//endfor

		  var mapCanvas = document.getElementById("map");
		  var mapOptions = {
		    center: new google.maps.LatLng(46.819041,8.3638133),
		    zoom: 8
		  };
			var map = new google.maps.Map(mapCanvas, mapOptions);

			var lines = array();
			for (var i = 0; i < paths.length; i++) {
				lines.push(new google.maps.Polyline({
			        path: paths[i],
			        strokeColor: '#FF0000',
			        strokeOpacity: 0.8,
			        strokeWeight: 2,
			        fillColor: '#FF0000',
			        fillOpacity: 0.35
	      		}));

				lines[i].setMap(map);
			}
			map.fitBounds(bounds);
		}
		</script>
		<script src="https://maps.googleapis.com/maps/api/js?callback=myMap"></script>
	</body>
</html>
