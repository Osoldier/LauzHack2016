package ch.lauzhack.triphub.test;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.trip.Stop;

import java.util.ArrayList;

public class SBBParserTest {
	public static void main (String[] args) {
		SBBParser parser = new SBBParser();
		ArrayList<Stop> stops = parser.getClosestStopFromLocation(46.518979, 6.562485,500);
		for (Stop stop : stops) {
			System.out.println(stop);
		}
	}
}
