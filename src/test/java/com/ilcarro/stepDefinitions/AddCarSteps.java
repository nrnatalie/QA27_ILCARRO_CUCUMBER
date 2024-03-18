package com.ilcarro.stepDefinitions;

import com.ilcarro.AddCarPage;
import com.ilcarro.HomePage;
import io.cucumber.datatable.DataTable;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddCarSteps {

  private WebDriver driver;
  private HomePage homePage;
  private AddCarPage addCarPage;


  @Before
  public void setUp() {
    driver = new ChromeDriver();
    homePage = new HomePage(driver);
  }


  @Given("User launches Chrome Browser for adding car")
  public void launch_ChromeBrowser_add_car() {
    driver = new ChromeDriver();
  }

  @When("User opens ilcarro Home Page for adding car")
  public void open_ilcarro_HomePage_add_car() {
    homePage = new HomePage(driver);
    homePage.openURL();
  }

  @And("User clicks on the Add Car button")
  public void click_on_Add_Car_button() {
    addCarPage = homePage.clickOnAddCarButton();
  }

  @And("User enters car details as follows:")
  public void enter_car_details(DataTable dataTable) {
    addCarPage.enterCarDetails(dataTable);
  }

  @And("User uploads photos of the car")
  public void upload_photos_of_the_car() {
    addCarPage.uploadPhotos();
  }

  @And("User clicks on the Submit button")
  public void click_on_Submit_button() {
    addCarPage.clickOnLetTheCarWorkLink();
  }

  @Then("User verifies that the car is successfully added")
  public void verify_car_added_successfully() {
    addCarPage.verifySuccessMessage();
  }

  @And("User quites browser after adding car")
  public void quit_browser_add_car() {
    driver.quit();
  }
}