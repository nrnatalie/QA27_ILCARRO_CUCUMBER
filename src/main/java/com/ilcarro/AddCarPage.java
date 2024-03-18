package com.ilcarro;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.Map;

public class AddCarPage extends BasePage {

  @FindBy(id = "location")
  WebElement locationInput;

  @FindBy(id = "manufacture")
  WebElement manufactureInput;

  @FindBy(id = "model")
  WebElement modelInput;

  @FindBy(id = "year")
  WebElement yearInput;

  @FindBy(id = "fuel")
  WebElement fuelInput;

  @FindBy(id = "seats")
  WebElement seatsInput;

  @FindBy(id = "carClass")
  WebElement carClassInput;

  @FindBy(id = "registrationNumber")
  WebElement registrationNumberInput;

  @FindBy(id = "price")
  WebElement priceInput;




  public AddCarPage(WebDriver driver) {
    super(driver);
  }

  public void enterCarDetails(DataTable dataTable) {
    List<Map<String, String>> carData = dataTable.asMaps();
    String location = carData.get(0).get("Location");
    String manufacture = carData.get(0).get("Manufacture");
    String model = carData.get(0).get("Model");
    String year = carData.get(0).get("Year");
    String fuel = carData.get(0).get("Fuel");
    String seats = carData.get(0).get("Seats");
    String carClass = carData.get(0).get("CarClass");
    String registrationNumber = carData.get(0).get("RegistrationNumber");
    String price = carData.get(0).get("Price");

    type(locationInput, location);
    type(manufactureInput, manufacture);
    type(modelInput, model);
    type(yearInput, year);
    type(seatsInput, seats);
    type(fuelInput, fuel);
    type(carClassInput, carClass);
    type(registrationNumberInput, registrationNumber);
    type(priceInput, price);

  }

  public void uploadPhotos() {
    WebElement fileInput = driver.findElement(By.id("photos"));
    fileInput.sendKeys("src/main/image/840px-Bmw_i3_photo.png");
  }

  public void clickSubmit() {
    WebElement submitButton = driver.findElement(By.id("submitButton"));
    click(submitButton);
  }

  public void verifySuccessMessage() {
    WebElement successMessage = driver.findElement(By.xpath("//div[contains(text(), 'Car successfully added')]"));
    Assert.assertTrue(successMessage.isDisplayed());
  }

  public void clickOnLetTheCarWorkLink() {
    WebElement letTheCarWorkLink = driver.findElement(By.cssSelector("a.navigation-link#1"));
    letTheCarWorkLink.click();
  }
}

