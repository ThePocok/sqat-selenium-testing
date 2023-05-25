package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends NespressoBase {
  public static final String URL = "https://www.nespresso.com/hu/hu";

  public final By titleBy = By.xpath("//*[@id=\"visible_h3\"]/div/h1");
  public final By emailBy = By.xpath("//*[@id=\"ta-header-username\"]");
  public final By passwordBy = By.xpath("//*[@id=\"ta-header-password\"]");
  public final By loginButtonBy = By.xpath("//*[@id=\"ta-login-form__submit\"]");
  public final By declineCookiesButtonBy = By.id("_evidon-decline-button");


  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void connect() {
    driver.get(URL);
  }

  public void login(String email, String password) {
    waitAndReturnElement(declineCookiesButtonBy).click();
    waitAndReturnElement(emailBy).sendKeys(email);
    waitAndReturnElement(passwordBy).sendKeys(password);

    waitAndReturnElement(loginButtonBy).click();
  }

  public WebElement getTitle() {
    return waitAndReturnElement(titleBy);
  }
}
