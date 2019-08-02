package com.techelevator.npgeek.model.weather;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.*;

import com.techelevator.npgeek.model.TemperatureUnit;


public class WeatherUnitTest {
	
	@Test
	public void day_is_not_empty() {
		Weather weather = new Weather(0, 0, 0, null, null);
		int day = 2;
		int high = 70;
		int low = 56;
		String forecast = "thunderstorms";
		TemperatureUnit temperatureUnit = null;
				
	}
	
	@Test
	public void temperature_converts_correctly() {
		Weather weather = new Weather(0, 0, 0, null, null);
		int high = 70;
		int low = 58;
		int actual = (int) Math.round(((int)high - 32) * 5d / 9d);
		int expected = 21;
		
		assertEquals(expected, actual);
		
	}
	
}
