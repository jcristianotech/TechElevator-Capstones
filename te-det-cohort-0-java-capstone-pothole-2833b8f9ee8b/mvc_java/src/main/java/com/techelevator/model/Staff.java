package com.techelevator.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

public class Staff {
	private String staffId;
	@NotBlank(message = "Email is required")
	@Email(message = "Email must be a valid email address")
	private String email;
	private String firstName;
	private String lastName;

	@Size(min = 10, message = "Password too short, must be at least 10")
	@Pattern.List({ @Pattern(regexp = ".*[a-z].*", message = "Must have a lower case"),
	@Pattern(regexp = ".*[A-Z].*", message = "Must have a capital") })
	@NotBlank(message = "Password is required")
	private String password;
	private String confirmPassword;

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword() {
		this.confirmPassword = confirmPassword;
	}
}
