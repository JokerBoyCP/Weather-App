package interfaces;

import Logik.Map;
import Logik.Root;

public interface WeatherApp {
	
	 public abstract Root getWeather(String city);
	 
	 public abstract String getMap(double lat,double lon);
}
