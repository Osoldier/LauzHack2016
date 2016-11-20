package ch.lauzhack.triphub.data;

import ch.lauzhack.triphub.trip.Gateway;
import ch.lauzhack.triphub.trip.Path;
import com.sun.javafx.fxml.builder.URLBuilder;
import sun.net.www.http.HttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class SSParser implements Parser {
	private final String API_KEY = "la541642382195614772535973946708";

	public SSParser () {
	}


	public ArrayList<Path> getConnections (String startingGateway, String endGateway, Calendar date){
		return null;
	}

	@Override
	public ArrayList<Path> getConnections (Gateway startingGateway, Gateway endGateway, Calendar date) {
		try {
			//locale / currency / country / outbounddate / adults
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateAsString = df.format(date.getTime());
			URL sessionURL = new URL("http://partners.api.skyscanner.net/apiservices/pricing/v1.0?apiKey="+API_KEY+"&adults=1&locale=en-us&currency=usd&country=usa&locationschema=Iata&originplace="+startingGateway.getId()+"&destinationplace="+endGateway.getId()+"&outbounddate="+dateAsString);
			System.out.println(sessionURL);
			HttpURLConnection http = (HttpURLConnection) sessionURL.openConnection();
			http.setDoOutput(true);
			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setRequestProperty("Accept","application/json");
			http.setRequestProperty("Content-Length",String.valueOf(sessionURL.toString().length()));


			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));

			String s = "";
			int ch;
			while ((ch = reader.read()) != -1) s += (char) ch;

			System.out.println(s);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


		return null;
	}
}
