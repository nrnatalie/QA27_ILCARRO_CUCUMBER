package com.ilcarro;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

  public HomePage(WebDriver driver) {
    super(driver);

  }

  @FindBy(css = "h1")
  WebElement title;

  public HomePage isHomePageTitleDisplayed() {
    assert isElementDisplayed(title);
    return this;
  }

  @FindBy(css = ".navigation-link:nth-child(6)")
  WebElement loginLink;

  public LoginPage clickOnLoginLink() {
    click(loginLink);
    return new LoginPage(driver);
  }

  @FindBy(css = "a.navigation-link#1")
  WebElement addCarButton;

  public AddCarPage clickOnAddCarButton() {
    click(addCarButton);
    return new AddCarPage(driver);
  }

  public void waitForLetTheCarWorkButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.navigation-link#1")));
  }


  }



  



