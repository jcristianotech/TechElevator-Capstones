package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.model.TemperatureUnit;

public class ParkWeather {

	private String parkCode;
	private TemperatureUnit temperatureUnit;
	private List<Weather> dailyWeather = new ArrayList<Weather>();
	
	public ParkWeather(String parkCode, TemperatureUnit temperatureUnit) {
		this.parkCode = parkCode;
		this.temperatureUnit = temperatureUnit;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public boolean isCelius() {
		return temperatureUnit.isCelsius();
	}
	
	public TemperatureUnit getTemperatureUnit() {
		return this.temperatureUnit;
	}
	
	public List<Weather> getDailyWeather() {
		return dailyWeather;
	}
	
	public void addDailyWeather(Weather weather) {
		this.dailyWeather.add(weather);
	}
	
}
