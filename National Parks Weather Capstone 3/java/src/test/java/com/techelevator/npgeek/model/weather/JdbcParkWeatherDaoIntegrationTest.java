package com.techelevator.npgeek.model.weather;

import org.junit.Assert;
import org.junit.Test;

import com.techelevator.DAOIntegrationTest;


public class JdbcParkWeatherDaoIntegrationTest extends DAOIntegrationTest {
	
	
	@Test
	public void test_get_park_weather_by_park_code () {
		ParkWeather publicWeather = new ParkWeather(null, null);
			
		Assert.assertNotNull(publicWeather);
		Assert.assertEquals(publicWeather.getParkCode(), publicWeather.getTemperatureUnit());

	}
	
}