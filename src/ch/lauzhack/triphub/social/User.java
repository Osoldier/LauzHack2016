package ch.lauzhack.triphub.social;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;
import ch.lauzhack.triphub.trip.Stop;

public class User {

	private String name;
	private Station departure, arrival;
	private Path path;

	public User(String name, Station departure, Station arrival, Path path) {
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
		this.path = path;
	}

	public void mergePaths(Path p, Stop s) {
		Path p2 = new Path();
		for (Stop st : p.getPath()) {
			if(st.equals(s)) {
				break;
			}
			p2.getPath().add(st);
		}
		p2.getPath().add(s);
		boolean add = false;
		for (int i = 0; i < p.getPath().size(); i++) {
			if(add) {
				p2.getPath().add(p.getPath().get(i));
			}
			if(p.getPath().get(i).equals(s)) {
				add = true;
			}
		}
		this.path = p2;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Station getDeparture() {
		return departure;
	}

	public void setDeparture(Station departure) {
		this.departure = departure;
	}

	public Station getArrival() {
		return arrival;
	}

	public void setArrival(Station arrival) {
		this.arrival = arrival;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	
	
}
