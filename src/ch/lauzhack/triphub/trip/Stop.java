package ch.lauzhack.triphub.trip;

import java.util.Calendar;

public class Stop {
	private Station station;
	private Calendar arrivalTime;
	private Calendar departureTime;
	private Train train;

	public Stop (Station station, Calendar arrivalTime, Calendar departureTime, Train train) {
		this.station = station;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.train = train;
	}

	public Station getStation() {
		return station;
	}

	public Calendar getArrivalTime () {
		return arrivalTime;
	}
	
	public Calendar getDepartureTime() {
		return departureTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Stop) {
			return ((Stop) obj).getStation().getId().equals(this.getStation().getId());
		}
		return false;
	}

	public Train getTrain () {
		return train;
	}
}
