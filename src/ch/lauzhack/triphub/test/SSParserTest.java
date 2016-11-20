package ch.lauzhack.triphub.test;

import ch.lauzhack.triphub.data.SSParser;
import ch.lauzhack.triphub.trip.Airport;
import ch.lauzhack.triphub.trip.Gateway;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SSParserTest {
	public static void main (String[] args) {
		SSParser parser = new SSParser();
		Airport airportZRH = new Airport("Zurich airport","ZRH");
		Airport airportJFK = new Airport("JFK NYC", "JFK");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(new SimpleDateFormat("yyyy-MM-dd'/'HH:mm").parse("2016-11-24/11:00"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser.getConnections(airportZRH,airportJFK,c);
	}

}
