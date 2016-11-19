package ch.lauzhack.triphub.engine;

import java.util.List;

import ch.lauzhack.triphub.social.User;
import ch.lauzhack.triphub.trip.Stop;
import ch.lauzhack.triphub.trip.Trip;

public class Meetup {

	public static Trip getBestTrip(List<User> users) {
		Trip t = new Trip();
		/*
		for (User user : users) {
			t.getTrip().add(user);
			for (Stop p : user.getPath().getPath()) {
				for (User user2 : users) {
					if(user2 == user) continue;
					for (Stop p2 : user2.getPath().getPath()) {
						if(user.getPath().isMergableAt(p, p2)) {
							user2.mergePaths(user.getPath(), p2);
						}
					}
				}
			}
		}
		*/
		return t;
	}
	
}
