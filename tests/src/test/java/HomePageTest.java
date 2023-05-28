import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;
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
    Assert.assertEquals("forum.index.hu", homePage.getFooterLink());
  }

  @Test
  public void testPageTitleCorrect() {
    homePage.connect();

    Assert.assertEquals("Index Fórum", driver.getTitle());
  }

  @Test
  public void testBlogHuIconHover() {
    homePage.connect();
    Assert.assertEquals("0px -100px", homePage.getBlogHuIcon().getCssValue("background-position"));

    Actions actions = new Actions(driver);
    actions.moveToElement(homePage.getBlogHuIcon()).perform();
    Assert.assertEquals("-100px -100px", homePage.getBlogHuIcon().getCssValue("background-position"));
  }

  @Test
  public void testLoginSuccessful() {
    homePage.connect();

    homePage.login(properties.getProperty("email"), properties.getProperty("password"));
    Assert.assertEquals(properties.getProperty("name"), homePage.getLoggedInUsername());
  }

  @Test
  public void testLoginUnsuccessful() {
    homePage.connect();

    homePage.login(properties.getProperty("email"), "asdf1234");
    Assert.assertEquals("Hibás felhasználónév vagy jelszó!", homePage.getLoginErrorMessage());
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
