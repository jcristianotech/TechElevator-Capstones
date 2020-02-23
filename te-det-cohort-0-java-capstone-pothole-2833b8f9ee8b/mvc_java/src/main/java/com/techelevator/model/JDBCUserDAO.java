package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;
import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher hashMaster;

	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher hashMaster) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.hashMaster = hashMaster;
	}

	@Override
	public boolean saveUser(String firstName, String lastName, String email, String password) {
		//so emails should be unique
		byte[] salt = hashMaster.generateRandomSalt();
		String hashedPassword = hashMaster.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		
		if (getUserByEmail(email)==null) {
			// this should work 
			//we're checking to make sure that the given email is unique. if we can't find a user with that email
			//then we let them make an account. if we can, nothing happens since their account already exists.
			//our return type is changing to boolean to let us know if a user was created or not
			jdbcTemplate.update("INSERT INTO users(first_name, last_name, email, password, salt) "
				+ "VALUES (?, ?, ?, ?, ?)", 
				firstName, lastName, email, hashedPassword, saltString);
			return true;
		}
		return false;
	}

	// this might work
	@Override
	public boolean searchForEmailAndPassword(String email, String password) {
		String sqlSearchForUser = "SELECT * " + "FROM users " + "WHERE email = ?";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, email);
		if (user.next()) {
			String dbSalt = user.getString("salt");
			String dbHashedPassword = user.getString("password");
			String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
			return dbHashedPassword.equals(givenPassword);
		} else {
			return false;
		}
	}

	@Override
	public void updatePassword(String userId, String email, String password) {
		// this should work
		jdbcTemplate.update("UPDATE users SET password = ? WHERE user_id = ? AND email = ?", 
				password, userId, email);
	}

	@Override
	public Object getUserByUserId(String userId) {
		// this one should work.
		String sqlSearchForUsername = "SELECT * " + "FROM users " + "WHERE user_id = ? ";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, userId);
		User thisUser = null;
		if (user.next()) {
			thisUser = new User();
			thisUser.setUserId(user.getString("user_id"));
			thisUser.setFirstName(user.getString("first_name"));
			thisUser.setLastName(user.getString("last_name"));
			thisUser.setPassword(user.getString("password"));
		}

		return thisUser;
	}

	@Override
	public Object getUserByEmail(String email) {
		// this should work
		String sqlSearchForUsername = "SELECT * " + "FROM users " + "WHERE email = ? ";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, email);
		User thisUser = null;
		if (user.next()) {
			thisUser = new User();
			thisUser.setUserId(user.getString("user_id"));
			thisUser.setFirstName(user.getString("first_name"));
			thisUser.setLastName(user.getString("last_name"));
			thisUser.setPassword(user.getString("password"));
		}

		return thisUser;
	}

}
