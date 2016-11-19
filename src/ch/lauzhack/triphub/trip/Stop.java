package ch.lauzhack.triphub.trip;

import java.util.Calendar;

public class Stop {
	private Station station;
	private Calendar dateTime;

	public Stop (Station station, Calendar dateTime) {
		this.station = station;
		this.dateTime = dateTime;
	}

	public Station getStation () {
		return station;
	}

	public Calendar getDateTime () {
		return dateTime;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Stop) {
			return ((Stop)obj).getStation().getId().equals(this.getStation().getId());
		}
		return false;
	}
}
