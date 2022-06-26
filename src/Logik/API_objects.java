package Logik;

import interfaces.WeatherApp;

public  class API_objects implements WeatherApp {
	
	/*getWeather Methode erstellt ein Objekt von der Klasse api_call welches 
	der Stadtname als Parameter mitliefert.*/
	
	public Root getWeather(String city) {
		api_call apc = new api_call(city);
		return apc.getRoot();
	}

	public String getMap(double lat, double lon) {
		Map mpp = new Map(lat, lon);
		return mpp.destinationFile;
	}

}
