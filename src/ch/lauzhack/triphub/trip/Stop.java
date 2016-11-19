package ch.lauzhack.triphub.trip;

import java.util.Calendar;

public class Stop {
	private Station station;
	private Calendar dateTime;
	private Train train;

	public Stop(Station station, Calendar dateTime, Train train) {
		this.station = station;
		this.dateTime = dateTime;
		this.train = train;
	}

	public Station getStation() {
		return station;
	}

	public Calendar getDateTime() {
		return dateTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Stop) {
			return ((Stop) obj).getStation().getId().equals(this.getStation().getId());
		}
		return false;
	}
}
