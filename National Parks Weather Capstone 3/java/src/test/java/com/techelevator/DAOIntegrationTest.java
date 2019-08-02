package com.techelevator;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.park.Park;

public abstract class DAOIntegrationTest {

	/*
	 * Using this particular implementation of DataSource so that every database
	 * interaction is part of the same database session and hence the same database
	 * transaction
	 */
	private static SingleConnectionDataSource dataSource;

	/*
	 * Before any tests are run, this method initializes the datasource for testing.
	 */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/*
		 * The following line disables autocommit for connections returned by this
		 * DataSource. This allows us to rollback any changes after each test
		 */
		dataSource.setAutoCommit(false);
	}

	/*
	 * After all tests have finished running, this method will close the DataSource
	 */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/*
	 * After each test, we rollback any changes that were made to the database so
	 * that everything is clean for the next test
	 */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/*
	 * This method provides access to the DataSource for subclasses so that they can
	 * instantiate a DAO for testing
	 */
	public DataSource getDataSource() {
		return dataSource;
	}

	protected void insertWeatherForPark(String parkCode, int day, int high, int low, String forecast) {
		String sql = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) VALUES (?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, parkCode, day, low, high, forecast);
	}

	protected Park insertPark(String parkCode) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Park park = getPark(parkCode);

		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, "
				+ "climate, yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription,"
				+ "entryfee, numberofanimalspecies) VALUES (?,	?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?)";
		jdbcTemplate.update(sql, park.getParkCode(), park.getParkName(), park.getState(), park.getAcreage(),
				park.getElevationInFeet(), park.getMilesOfTrail(), park.getNumberOfCampsites(), park.getClimate(),
				park.getYearFounded(), park.getAnnualVisitorCount(), park.getInspirationalQuote(),
				park.getInspirationalQuoteSource(), park.getParkDescription(), park.getEntryFee(),
				park.getNumberOfAnimalSpecies());
		return park;
	}

	
	private Park getPark(String parkCode) {
		Park park = new Park();
		park.setParkCode(parkCode);
		park.setParkName("TestName");
		park.setState("Wyoming");
		park.setAcreage(2219791);
		park.setElevationInFeet(8000);
		park.setMilesOfTrail(900.0f);
		park.setNumberOfCampsites(1900);
		park.setClimate("Temperate");
		park.setYearFounded(1872);
		park.setAnnualVisitorCount(3394326);
		park.setInspirationalQuote("Quote");
		park.setInspirationalQuoteSource("John Steinbeck");
		park.setParkDescription("ParkDescription");
		park.setEntryFee(15);
		park.setNumberOfAnimalSpecies(420);
		return park;
	}
}
