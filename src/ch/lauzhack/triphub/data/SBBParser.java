package ch.lauzhack.triphub.data;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;
import lib.JSONArray;
import lib.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Calendar;

public class SBBParser implements Parser {
	private final String baseURL = "http://transport.opendata.ch/v1/";

	public SBBParser () {
	}

	@Override
	public ArrayList<Path> getConnections (Station startingStation, Station endStation, Calendar date) {
		
		return null;
	}

	public ArrayList<Station> getClosestStopFromLocation (double x, double y, int maxDistanceFromStop){
		ArrayList<Station> stationList = new ArrayList<>();
		try {
			URL url = new URL(baseURL + "locations?x=" + String.valueOf(x) + "&y=" + String.valueOf(y));
			URLConnection urlConnection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			StringBuilder jsonBuilder = new StringBuilder();
			int ch;

			while ((ch = reader.read()) != -1) {
				jsonBuilder.append((char) ch);
			}
			String jsonText = jsonBuilder.toString();
			JSONObject json = new JSONObject(jsonText);
			JSONArray stations = json.getJSONArray("stations");
			for (int i = 0; i < stations.length(); i++) {
				JSONObject station = stations.getJSONObject(i);
				if (station.getDouble("distance") <= maxDistanceFromStop){
					JSONObject coordinates = station.getJSONObject("coordinate");
					stationList.add(new Station(station.getString("name"),coordinates.getDouble("x"),coordinates.getDouble("y")));
				}
			}
			reader.close();
			return stationList;
		} catch (MalformedURLException e){
			System.out.println("Something went wrong");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
