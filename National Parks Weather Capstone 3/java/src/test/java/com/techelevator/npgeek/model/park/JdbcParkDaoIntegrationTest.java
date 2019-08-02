package com.techelevator.npgeek.model.park;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.DAOIntegrationTest;

public class JdbcParkDaoIntegrationTest extends DAOIntegrationTest {

//	private static final String PARK_CODE = "TEST";

	private ParkDao parkDao;

	@Before
	public void setup() {
		parkDao = new JdbcParkDao(getDataSource());
		String sqlInsertTest1 = "INSERT INTO park VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertTest1, "TEST", "Test Park Name", "Test State",
				500, 50, 5.5, 5, "Test Climate", 2019, 10, "Test Quote",
				"Test Quote Source", "Test Park Description", 5, 100);
		}
		
		@Test
		public void test_get_all_parks() {
			List<Park> parkList = new ArrayList<Park>();
			parkList = parkDao.getAllParks();
			
			Park thePark = new Park();
			
			for (Park park: parkList) {
				if (park.getParkCode().equals("TEST")) {
					thePark = park;
				}
			}
			
			Assert.assertNotNull(parkList);
			Assert.assertNotNull(thePark);
		}
		
		@Test
		public void test_get_park_by_park_code() {
			Park park = new Park();
			park = parkDao.getParkByParkCode("TEST");
			Assert.assertNotNull(park);
			Assert.assertEquals("Test Park Name", park.getParkName());
			Assert.assertEquals("Test State", park.getState());
			Assert.assertEquals( "Test Park Description", park.getParkDescription());
			Assert.assertEquals(100, park.getNumberOfAnimalSpecies());
		}

}
