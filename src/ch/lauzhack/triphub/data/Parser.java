package ch.lauzhack.triphub.data;

import ch.lauzhack.triphub.trip.Gateway;
import ch.lauzhack.triphub.trip.Path;

import java.util.ArrayList;
import java.util.Calendar;

public interface Parser {

	ArrayList<Path> getConnections(Gateway startingGateway, Gateway endGateway, Calendar date);

}
