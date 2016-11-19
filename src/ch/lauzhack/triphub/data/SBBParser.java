package ch.lauzhack.triphub.data;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;
import ch.lauzhack.triphub.trip.Stop;
import lib.JSONArray;
import lib.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class SBBParser implements Parser {
	private final String baseURL = "http://transport.opendata.ch/v1/";

	public SBBParser () {
	}

	@Override
	public ArrayList<Path> getConnections (Station startingStation, Station endStation, Calendar date) {
		String startId = startingStation.getId();
		String endId = endStation.getId();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
		try {
			URL url = new URL(baseURL+"connections?from="+startId+"&to="+endId+"&date="+dateFormat.format(date.getTime())+"&time="+timeFormat.format(date.getTime()));
			JSONObject json = getJSONFromURL(url);
			JSONArray connections = json.getJSONArray("connections");
			for (int i = 0; i < connections.length(); i++) {
				ArrayList<Stop> stops = new ArrayList<>();
				JSONArray sections = connections.getJSONObject(i).getJSONArray("sections");
				for (int j = 0; j < sections.length(); j++) {
					JSONArray pathList = sections.getJSONObject(i).getJSONObject("journey").getJSONArray("passlist");
					for (int k = 0; k < pathList.length(); k++) {

					}
				}
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private JSONObject getJSONFromURL(URL url) throws IOException {
		URLConnection urlConnection = url.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		StringBuilder jsonBuilder = new StringBuilder();
		int ch;

		while ((ch = reader.read()) != -1) {
			jsonBuilder.append((char) ch);
		}
		String jsonText = jsonBuilder.toString();
		reader.close();
		return new JSONObject(jsonText);
	}

	public ArrayList<Station> getClosestStopFromLocation (double x, double y, int maxDistanceFromStop){
		ArrayList<Station> stationList = new ArrayList<>();
		try {
			URL url = new URL(baseURL + "locations?x=" + String.valueOf(x) + "&y=" + String.valueOf(y));
			JSONObject json = getJSONFromURL(url);
			JSONArray stations = json.getJSONArray("stations");
			for (int i = 0; i < stations.length(); i++) {
				JSONObject station = stations.getJSONObject(i);
				if (station.getDouble("distance") <= maxDistanceFromStop){
					JSONObject coordinates = station.getJSONObject("coordinate");
					stationList.add(new Station(station.getString("name"),coordinates.getDouble("x"),coordinates.getDouble("y"), station.getString("id")));
				}
			}
			return stationList;
		} catch (MalformedURLException e){
			System.out.println("Something went wrong");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
