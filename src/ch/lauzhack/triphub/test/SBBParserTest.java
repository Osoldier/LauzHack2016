package ch.lauzhack.triphub.test;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.trip.Station;

import java.util.ArrayList;
import java.util.Calendar;

public class SBBParserTest {
	public static void main (String[] args) {
		SBBParser parser = new SBBParser();
		ArrayList<Station> stations = parser.getClosestStopFromLocation(46.518979, 6.562485,500);
		parser.getConnections(stations.get(0),stations.get(1), Calendar.getInstance());

	}
}
