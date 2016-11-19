package ch.lauzhack.triphub.test;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.trip.Station;

import java.util.ArrayList;

public class SBBParserTest {
	public static void main (String[] args) {
		SBBParser parser = new SBBParser();
		ArrayList<Station> stations = parser.getClosestStopFromLocation(46.518979, 6.562485,500);
		for (Station station : stations) {
			System.out.println(station);
		}
	}
}
