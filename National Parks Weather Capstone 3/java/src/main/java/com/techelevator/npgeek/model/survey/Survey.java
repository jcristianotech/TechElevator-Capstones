package com.techelevator.npgeek.model.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

  private long surveyId;

  @NotBlank(message = "Please select a park")
  private String parkCode;

  @NotBlank(message = "Email address is required")
  @Email(message = "Email must be a valid email address")
  private String emailAddress;

  @NotBlank(message = "Please select your state of residence")
  private String state;

  @NotBlank(message = "Please select your activity level")
  private String activityLevel;

  public String getParkCode() {
    return parkCode;
  }

  public void setParkCode(String parkCode) {
    this.parkCode = parkCode;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getActivityLevel() {
    return activityLevel;
  }

  public void setActivityLevel(String activityLevel) {
    this.activityLevel = activityLevel;
  }

  public long getSurveyId() {
    return surveyId;
  }

  public void setSurveyId(long surveyId) {
    this.surveyId = surveyId;
  }
}
