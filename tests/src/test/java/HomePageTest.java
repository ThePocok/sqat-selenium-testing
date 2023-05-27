import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.HomePage;

public class HomePageTest extends TestBase {
  private HomePage homePage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    homePage = new HomePage(driver);
  }

  @Test
  public void testPageLoaded() {
    homePage.connect();

    Assert.assertEquals("Index Fórumok", homePage.getTitleImageAlt());
  }

  @Test
  public void testPageTitle() {
    homePage.connect();

    Assert.assertEquals("Index Fórum", driver.getTitle());
  }

  @Test
  public void testLogin() {
    homePage.connect();

    homePage.login(properties.getProperty("email"), properties.getProperty("password"));
    Assert.assertEquals(properties.getProperty("name"), homePage.getLoggedInUsername());
  }

  @Test
  public void testLogout() {
    homePage.connect();

    homePage.login(properties.getProperty("email"), properties.getProperty("password"));
    homePage.logout();
    Assert.assertEquals("https://kilepes.blog.hu/", driver.getCurrentUrl());
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
