package com.techelevator.npgeek.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDao;
import com.techelevator.npgeek.model.weather.ParkWeather;
import com.techelevator.npgeek.model.weather.ParkWeatherDao;

import com.techelevator.npgeek.model.TemperatureUnit;

@Controller
@SessionAttributes("temperatureUnit")
public class HomeController {

	@Autowired
	private ParkDao parkDao;

	@Autowired
	private ParkWeatherDao weatherDao;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showAllParks(ModelMap map) {
		map.addAttribute("parks", parkDao.getAllParks());
		return "home";
	}

	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String showParkDetail(@RequestParam(required = false) String parkCode, ModelMap map) {
		if (parkCode == null || parkCode.length() < 1) {
			return "redirect:/";
		}
		map.addAttribute("park", parkDao.getParkByParkCode(parkCode));
		map.addAttribute("weather", getParkWeather(parkCode, map));

		return "parkDetail";

	}

	@RequestMapping(path = "/switchTempUnit", method = RequestMethod.GET)
	public String switchTempUnit(@RequestParam String parkCode, @RequestParam boolean isCelsius, ModelMap map) {

		((TemperatureUnit) map.get("temperatureUnit")).setCelsius(isCelsius);
		map.addAttribute("parkCode", parkCode);
		return "redirect:/parkDetail";
	}

	private ParkWeather getParkWeather(String parkCode, ModelMap map) {
		if (!map.containsKey("temperatureUnit")) {
			map.addAttribute("temperatureUnit", new TemperatureUnit());
		}
		ParkWeather weather = weatherDao
				.getParkWeatherByParkCode(new ParkWeather(parkCode, (TemperatureUnit) map.get("temperatureUnit")));
		return weather;
	}
}
