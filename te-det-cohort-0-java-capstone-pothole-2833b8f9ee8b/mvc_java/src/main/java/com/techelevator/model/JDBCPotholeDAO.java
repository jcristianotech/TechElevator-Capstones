package com.techelevator.model;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


@Component 
public class JDBCPotholeDAO implements PotholeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCPotholeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void savePothole(String dateReported, String userId, String latitude, String longitude) {
		//duplication? multiple reports are kinda good maybe? gives a sense of importance
		jdbcTemplate.update("INSERT INTO potholes(pothole_id, date_reported, user_id, latitude, longitude) VALUES (?, ?, ?, ?, ?)", 
				LocalDate.now(), userId, latitude, longitude);
	}

	@Override
	public void addPhoto(String photoURL) {
		// not gonna touch this just yet
	}
	
	@Override
	public void deletePothole(String potholeId) {
		jdbcTemplate.update("DELETE FROM potholes WHERE pothole_id = ? ", Integer.parseInt(potholeId));
	}
	
	@Override
	public List<Pothole> showAllPotholes() {
		List<Pothole> allPotholes = new ArrayList<>();
		String sqlSelectAllPotholes = "SELECT * FROM potholes ORDER BY pothole_id asc";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPotholes);
		while (results.next()) {
			Pothole potholes = new Pothole();
			potholes.setPotholeId(results.getString("pothole_id"));
			potholes.setUserId(results.getString("user_id"));
			potholes.setLatitude(results.getString("latitude"));
			potholes.setLongitude(results.getString("longitude"));
			potholes.setDateReported(results.getString("date_reported"));
			potholes.setDateInspected(results.getString("date_inspected"));
			potholes.setRank(results.getString("rank"));
			potholes.setDescription(results.getString("description"));
			potholes.setDateRepaired(results.getString("date_repaired"));
			
			allPotholes.add(potholes);
		}
		return allPotholes;
	}

	@Override
	public Object getPotholeById(String potholeId) {
		// this should be good
		String sqlSearchForUsername = "SELECT * " + "FROM potholes " + "WHERE pothole_id = ? ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUsername, Integer.parseInt(potholeId));
		Pothole pothole = new Pothole();
		while (results.next()) {
			pothole.setPotholeId(results.getString("pothole_id"));
			pothole.setUserId(results.getString("user_id"));
			pothole.setLatitude(results.getString("latitude"));
			pothole.setLongitude(results.getString("longitude"));
			pothole.setDateReported(results.getString("date_reported"));
			pothole.setDateInspected(results.getString("date_inspected"));
			pothole.setRank(results.getString("rank"));
			pothole.setDescription(results.getString("description"));
			pothole.setDateRepaired(results.getString("date_repaired"));
		}

		return pothole;
	}

	@Override
	public Object getPotholeByDate(String dateReported) {
		// revisit all this too
		//this might want to be a list instead of a single object?
		String sqlSearchForUsername = "SELECT * " + "FROM potholes " + "WHERE date_reported = ? ";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, dateReported.toUpperCase());
		User thisUser = null;
		if (user.next()) {
			thisUser = new User();
			thisUser.setUserId(user.getString("user_name"));
			thisUser.setPassword(user.getString("password"));
		}

		return thisUser;
	}

 
	@Override
	public Object getPotholeByLocation(String location) {
		// jk this is probably just a single pothole
		String sqlSearchForUsername = "SELECT * " + "FROM potholes " + "WHERE location = ? ";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, location);
		User thisUser = null;
		if (user.next()) {
			thisUser = new User();
			thisUser.setUserId(user.getString("user_name"));
			thisUser.setPassword(user.getString("password"));
		}

		return thisUser;
	}

	@Override
	public void updateInspection(String potholeId, String dateInspection, String rank, String description) {
		int rankNum = Integer.parseInt(rank);
		int idNum = Integer.parseInt(potholeId);

		try {
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateInspection);
	
		jdbcTemplate.update("UPDATE potholes SET date_inspected = ?, rank = ?, description = ? WHERE pothole_id = ?",
				date1, rankNum, description, idNum);
		} catch (ParseException e) {
			//This is required for the date parse to work
			e.printStackTrace();
		}
	}

	@Override
	public void updateRepair(String potholeId, String dateRepaired) {
		int idNum = Integer.parseInt(potholeId);
		try {
			Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(dateRepaired);
	
		jdbcTemplate.update("UPDATE potholes SET date_repaired = ? WHERE pothole_id = ?", 
				date1, idNum);
		} catch (ParseException e) {
			//This is required for the date parse to work
			e.printStackTrace();
		}

	}
	

}
