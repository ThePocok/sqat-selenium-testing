import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import webpages.HomePage;

public class HomePageTest extends NespressoTestBase{
  private HomePage homePage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    homePage = new HomePage(driver);
  }

  //@Test
  public void testLoginWithCorrectData(){
    driver.get(HomePage.URL);

    homePage.login(properties.getProperty("email"), properties.getProperty("password"));
  }

  @Test
  public void testPageLoaded() {
    driver.get(HomePage.URL);

    Assert.assertTrue(homePage.getTitle().getText().contains("NESPRESSO"));
  }

  @Test
  public void testDisableCookies() {
    driver.get(HomePage.URL);

    Assert.assertTrue(homePage.getCookieConsentTitle().getText().contains("COOKIE"));
    homePage.declineCookies();
    Assert.assertFalse(homePage.isCookieConsentPopupShown());
  }

  @Test
  public void testDisableCookiesWithoutClicking() {
    driver.get(HomePage.URL);
    Assert.assertTrue(homePage.isCookieConsentPopupShown());

    driver.manage().addCookie(new Cookie("_evidon_consent_cookie",
        "{\"consent_date\":\"2023-05-26T06:16:40.102Z\",\"gpc\":0,\"consent_type\":1}"));
    driver.navigate().refresh();

    Assert.assertFalse(homePage.isCookieConsentPopupShown());
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
