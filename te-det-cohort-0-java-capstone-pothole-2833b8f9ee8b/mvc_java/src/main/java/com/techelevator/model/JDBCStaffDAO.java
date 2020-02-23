package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.security.PasswordHasher;

@Component
public class JDBCStaffDAO implements StaffDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher hashMaster;

	@Autowired
	public JDBCStaffDAO(DataSource dataSource, PasswordHasher hashMaster) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.hashMaster = hashMaster;
	}

	@Override
	public boolean saveStaff(String staffId, String firstName, String lastName, String password, String email) {
		// Pulled from example code.
		byte[] salt = hashMaster.generateRandomSalt();
		String hashedPassword = hashMaster.computeHash(password, salt);
		String saltString = new String(Base64.encode(salt));
		int idNum = Integer.parseInt(staffId);
		
		//int idNum = Integer.parseInt(staffId); this is gonna happen alot
		
		// this should be good. same as users, we check to make sure the email is
		// unique.
		// we might not even have employees register, but its here anyways.
		if (getStaffByEmail(email) == null) {
			jdbcTemplate.update("INSERT INTO staff(staff_id, first_name, last_name, email, password, salt) VALUES (?, ?, ?, ?, ?, ?)", 
					idNum, firstName, lastName, email, hashedPassword, saltString);
			return true;
		}
		return false;
	}

	@Override
	public boolean searchForEmailAndPassword(String email, String password) {
		String sqlSearchForStaff = "SELECT * " + "FROM staff " + "WHERE email = ?";
		SqlRowSet staff = jdbcTemplate.queryForRowSet(sqlSearchForStaff, email);
		
		if (staff.next()) {
			String dbSalt = staff.getString("salt");
			String dbHashedPassword = staff.getString("password");
			String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
			return dbHashedPassword.equals(givenPassword);
		} else {
			return false;
		}
	}

	@Override
	public void updatePassword(String staffId, String email, String password) {
		// this should work maybe?
		jdbcTemplate.update("UPDATE staff SET password = ? WHERE staff_id = ? AND email = ?" + password, staffId, email);
	}

	@Override
	public Object getStaffByStaffId(String staffId) {
		// this is probably good
		String sqlSearchForUsername = "SELECT * " + "FROM staff " + "WHERE staff_id = ? ";
		int idNum = Integer.parseInt(staffId);
		SqlRowSet staff = jdbcTemplate.queryForRowSet(sqlSearchForUsername, idNum);
		Staff thisStaff = null;
		if (staff.next()) {
			thisStaff = new Staff();
			thisStaff.setStaffId(staff.getString("staff_id"));
			thisStaff.setEmail(staff.getString("email"));
			thisStaff.setFirstName(staff.getString("first_name"));
			thisStaff.setLastName(staff.getString("last_name"));
			thisStaff.setPassword(staff.getString("password"));
		}

		return thisStaff;
	}

	@Override
	public Object getStaffByEmail(String email) {
		// this should work
		String sqlSearchForUsername = "SELECT * " + "FROM staff " + "WHERE email = ? ";

		SqlRowSet staff = jdbcTemplate.queryForRowSet(sqlSearchForUsername, email);
		Staff thisStaff = null;
		if (staff.next()) {
			thisStaff = new Staff();
			thisStaff.setStaffId(staff.getString("staff_id"));
			thisStaff.setEmail(staff.getString("email"));
			thisStaff.setFirstName(staff.getString("first_name"));
			thisStaff.setLastName(staff.getString("last_name"));
			thisStaff.setPassword(staff.getString("password"));
		}

		return thisStaff;
	}

}
