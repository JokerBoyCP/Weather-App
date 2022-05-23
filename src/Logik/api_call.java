package Logik;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
	
	
	public api_call(String city) {

		try {

			URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city
					+ "&units=metric&appid=cd15916a5ebb33e14165bd245b6e4cb8");

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			// Check if connect is made
			int responseCode = conn.getResponseCode();

			// 200 OK
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

				
				this.description = root.getWeather().get(0).getDescription();
				this.city = root.getName();
				this.temp = root.getMain().getTemp();
				this.humidity = root.getMain().getHumidity();
				this.wind_speed = root.getWind().getSpeed();
				this.lat = root.getCoord().getLat();
				this.lon = root.getCoord().getLon();
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

}
