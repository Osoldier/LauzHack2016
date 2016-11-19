package ch.lauzhack.triphub.data;

import ch.lauzhack.triphub.trip.Path;
import ch.lauzhack.triphub.trip.Stop;

import java.util.ArrayList;
import java.util.Calendar;

public interface Parser {

	ArrayList<Path> getConnections(Stop startingStop, Stop endPoint, Calendar date);

}
