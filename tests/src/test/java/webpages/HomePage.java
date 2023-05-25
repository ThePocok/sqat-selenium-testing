package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends NespressoBase {
  public static final String URL = "https://www.nespresso.com/hu/hu";

  public final By emailBy = By.xpath("//*[@id=\"ta-header-username\"]");
  public final By passwordBy = By.xpath("//*[@id=\"ta-header-password\"]");
  public final By loginButtonBy = By.xpath("//*[@id=\"ta-login-form__submit\"]");


  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void connect() {
    System.out.println("Na akkor most csatlakozom");
    driver.get(URL);
  }

  public void login(String email, String password) {
    waitAndReturnElement(emailBy).sendKeys(email);
    waitAndReturnElement(passwordBy).sendKeys(password);

    waitAndReturnElement(loginButtonBy).click();
  }
}
