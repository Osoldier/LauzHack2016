package ch.lauzhack.triphub.social;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Stop;

public class User {

	private String name;
	private Stop departure, arrival;
	private Path path;

	public User(String name, Stop departure, Stop arrival) {
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

	public Stop getDeparture() {
		return departure;
	}

	public void setDeparture(Stop departure) {
		this.departure = departure;
	}

	public Stop getArrival() {
		return arrival;
	}

	public void setArrival(Stop arrival) {
		this.arrival = arrival;
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}
	
	
	
}
