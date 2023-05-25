import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import webpages.HomePage;

public class LoginTest extends NespressoTestBase{
  private HomePage homePage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    homePage = new HomePage(driver);
  }

  @Test
  public void testLoginWithCorrectData() throws MalformedURLException {
    driver.get(HomePage.URL);

    homePage.login(properties.getProperty("email"), properties.getProperty("password"));
  }

  @Test
  public void testPageLoaded() {
    driver.get(HomePage.URL);
    Assert.assertTrue(homePage.getTitle().getText().contains("NESPRESSO"));
  }

  //@After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
