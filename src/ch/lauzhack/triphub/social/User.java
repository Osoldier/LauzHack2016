package ch.lauzhack.triphub.social;

import java.util.List;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Station;

public class User {

	private String name;
	private Station departure, arrival;
	private List<Path> path;

	public User(String name, Station departure, Station arrival, List<Path> path) {
		this.name = name;
		this.departure = departure;
		this.arrival = arrival;
		this.path = path;
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

	public List<Path> getPath() {
		return path;
	}

	public void setPath(List<Path> path) {
		this.path = path;
	}
	
	
	
}
