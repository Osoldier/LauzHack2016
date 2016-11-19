package ch.lauzhack.triphub.engine;

import java.util.ArrayList;
import java.util.List;

import ch.lauzhack.triphub.data.SBBParser;
import ch.lauzhack.triphub.social.User;
import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Stop;
import ch.lauzhack.triphub.trip.Trip;

public class Meetup {

	public static Trip getBestTrip(List<User> users) {
		
		SBBParser sbbParser = new SBBParser();
		
		Trip t = new Trip();
		Path masterPath = null; 
		User masterUser = null;
		for (User user : users) {
			for (Path p : user.getPath()) {
				if(masterPath == null || p.getPath().size() > masterPath.getPath().size()) {
					masterPath = p;
					masterUser = user;
				}
			}
		}
		
		for (User user : users) {
			if(user == masterUser) continue;
			List<Path> p = sbbParser.getConnections(user.getDeparture(), masterUser.getDeparture(), user.getPreferedTime());
			Path bestJoiner = p.get(0);
			Stop mergePoint = null;
			int bjc = Integer.MAX_VALUE;
			for (Path path : p) {
				loop1: for (Stop s : path.getPath()) {
					int i = 0;
					for (Stop stop2 : masterPath.getPath()) {
						i++;
						if(s.getStation().equals(stop2.getStation())) {
							if(path.isMergableAt(s, stop2)) {
								if(bestJoiner == null || i < bjc) {
									bestJoiner = path;
									bjc = i;
									mergePoint = s;
									break loop1;
								}
							}
						}
					}
				}
			}
			assert(bestJoiner != null);
			bestJoiner.mergePaths(masterPath, mergePoint);
			user.getPath().clear();
			user.getPath().add(bestJoiner);
			t.getTrip().add(user);
		}
		t.getTrip().add(masterUser);
		
		return t;
	}
	
}
