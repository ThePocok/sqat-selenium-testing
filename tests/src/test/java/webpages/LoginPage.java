package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends NespressoBase {
  public static final String URL = "https://www.nespresso.com/hu/hu/secure/login";

  public final By emailBy = By.xpath("//*[@id=\"emailField\"]");
  public final By passwordBy = By.xpath("//*[@id=\"passwordField\"]");
  public final By loginButtonBy = By.xpath("//*[@id=\"ta-login-page-login-submit\"]");



  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public void login(String email, String password) {
    waitAndReturnElement(emailBy).sendKeys(email);
    waitAndReturnElement(passwordBy).sendKeys(password);

    waitAndReturnElement(loginButtonBy).click();
  }
}
