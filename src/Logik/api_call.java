package Logik;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

public class api_call {

	public double getLat() {
		return lat;
	}

	protected void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	protected void setLon(double lon) {
		this.lon = lon;
	}

	private String city;
	private String description;
	private double temp;
	private long humidity;
	private double wind_speed;
	private double lat;
	private double lon;
	private Root root;
	
	
	public api_call(String city) {

		try {
			//API aufruf via URL mit StadtName vom Konstruktor.
			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city
					+ "&units=metric&appid=cd15916a5ebb33e14165bd245b6e4cb8");

			//Verbindung wird gemacht.
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//"GET" code wird benützt um die Infos vom API zu holen.
			conn.setRequestMethod("GET");
			conn.connect();

			// Verbindung wird überprüft.
			int responseCode = conn.getResponseCode();

			// Falls man das Code:200 zurückbekommt ist die Verbindung OK.
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {

				String informationString = null;
				Scanner scanner = new Scanner(url.openStream());

				// As long as there is something, save it in the informationString
				while (scanner.hasNext()) {
					informationString = scanner.nextLine();
				}

				// Close the scanner
				scanner.close();

				Gson gson = new Gson();
				Root root = gson.fromJson(informationString, Root.class);
				
				this.root = root;

				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getCity() {
		return city;
	}

	protected void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}

	public double getTemp() {
		return temp;
	}

	protected void setTemp(double temp) {
		this.temp = temp;
	}

	public long getHumidity() {
		return humidity;
	}

	protected void setHumidity(long humidity) {
		this.humidity = humidity;
	}

	public double getWind_speed() {
		return wind_speed;
	}

	protected void setWind_speed(double wind_speed) {
		this.wind_speed = wind_speed;
	}
	
	public Root getRoot() {
	return this.root;
	}
}
