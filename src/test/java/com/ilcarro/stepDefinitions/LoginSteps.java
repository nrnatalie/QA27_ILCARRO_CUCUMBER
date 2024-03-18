package com.ilcarro.stepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import com.ilcarro.HomePage;
import com.ilcarro.LoginPage;
import io.cucumber.datatable.DataTable;

public class LoginSteps {

  private WebDriver driver;

  public LoginSteps(WebDriver driver) {
    this.driver = driver;
  }


  @And("User clicks on the Log in Link")
  public void click_on_Login_Link() {
    new HomePage(driver).clickOnLoginLink();
  }

  @And("User enter valid data")
  public void enter_valid_data() {
    new LoginPage(driver).enterData("neuer@gmail.com","Neuer12345$");
  }


  @And("User clicks on the Yalla button")
  public void click_on_Yalla_button() {
    new HomePage(driver).waitForLetTheCarWorkButton();
    new LoginPage(driver).clickOnYallaButton();
  }


  @Then("User verifies Success message is displayed")
  public void verify_Success_message() {
    new LoginPage(driver).isSuccessMessageDisplayed();
  }

  @And("User enter valid email and invalid password")
  public void enter_valid_email_invalid_password(DataTable dataTable) {
    new LoginPage(driver).enterInvalidPassword(dataTable);
  }

  @When("User verifies Error message is displayed")
  public void verify_Error_message() {
    new LoginPage(driver).isErrorDisplayed();
  }
}