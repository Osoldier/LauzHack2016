package ch.lauzhack.triphub.test;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.trip.Station;

import java.util.ArrayList;
import java.util.Calendar;

public class SBBParserTest {
	public static void main (String[] args) {
		SBBParser parser = new SBBParser();
		Station genevaStation = parser.getStation("Geneva");
		Station lausanneStation = parser.getStation("Zurich");
		System.out.println(genevaStation);
		System.out.println(lausanneStation);

	}
}
