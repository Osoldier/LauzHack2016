package ch.lauzhack.triphub.social;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;

public class User {

	private String name;
	private Station departure, arrival;
	private Path path;

	public User(String name, Station departure, Station arrival) {
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
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
