package ch.lauzhack.triphub.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ch.lauzhack.triphub.engine.Meetup;
import ch.lauzhack.triphub.social.User;
import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;
import ch.lauzhack.triphub.trip.Stop;

public class MeetupTester {

	private static Station geneva = new Station("Geneva", 0, 0, "GE");
	private static Station zurich = new Station("Zurich", 0, 0, "ZU");
	private static Station yverdon = new Station("Yverdon", 0, 0, "YV");
	
	private static Calendar cs = Calendar.getInstance();
	private static Calendar cs1 = Calendar.getInstance();
	private static Calendar cs2 = Calendar.getInstance();
	
	
	static {
		cs.set(Calendar.HOUR, 7);
		cs2.set(Calendar.MINUTE, 00);
		cs1.set(Calendar.HOUR, 8);
		cs1.set(Calendar.MINUTE, 30);
		cs2.set(Calendar.HOUR, 9);
		cs2.set(Calendar.MINUTE, 30);
	}
	/*
	private static Stop gs = new Stop(geneva, cs);
	private static Stop ys = new Stop(geneva, cs1);
	private static Stop zs = new Stop(zurich, cs2);
	
	private static Object pg1 = new ArrayList<>();

	static {
		((ArrayList<Stop>)pg1).add(gs);
		((ArrayList<Stop>)pg1).add(ys);
		((ArrayList<Stop>)pg1).add(zs);
		pg1 = new Path((ArrayList<Stop>)pg1);
	}
	
	public static void main(String[] args) {
		List<User> users = new ArrayList<>();
		Path p1 = new Path();
		
		//users.add(new User("Thomas", geneva, zurich, (Path)pg1));
		Meetup.getBestTrip(users);
	}
	*/
}
