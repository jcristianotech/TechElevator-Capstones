package com.techelevator.npgeek.model.survey;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.DAOIntegrationTest;

public class JdbcSurveyDaoIntegrationTest extends DAOIntegrationTest {

	private JdbcSurveyDao surveyDao;
	private JdbcTemplate jdbcTemplate;

	@Before
	public void surveySetup() {

		jdbcTemplate = new JdbcTemplate(getDataSource());
		surveyDao = new JdbcSurveyDao(getDataSource());

	}

	@Test
	public void save_survey_saves_survey() {

		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + "annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + "VALUES ('CODE', 'TEST', 'TEST', 500, 50, 5.5, 5, 'TEST', 2019, 10, 'TEST', 'TEST', 'TEST', 5, 100);";
		jdbcTemplate.update(sql);

		Survey survey = makeSurvey();

		surveyDao.insertSurvey(survey);

		String sql2 = "SELECT * FROM survey_result WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql2, "CODE");
		result.next();
		String actual = result.getString("parkcode");

		Assert.assertEquals("CODE", actual);

	}

	@Test
	public void get_survey_results_returns_results() {

		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + "annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + "VALUES ('CODE', 'TEST', 'TEST', 500, 50, 5.5, 5, 'TEST', 2019, 10, 'TEST', 'TEST', 'TEST', 5, 100);";
		jdbcTemplate.update(sql);

		List<SurveyResult> results = surveyDao.getSurveyResults();

		Survey survey = makeSurvey();

		surveyDao.insertSurvey(survey);

		List<SurveyResult> actual = surveyDao.getSurveyResults();

		Assert.assertEquals(results.size() + 1, actual.size());
	}

	private Survey makeSurvey() {

		Survey survey = new Survey();
		survey.setParkCode("CODE");
		survey.setEmailAddress("TEST");
		survey.setActivityLevel("inactive");
		survey.setState("Michigan");

		return survey;
	}
}