import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.SearchPage;

public class SearchPageTest extends TestBase {
  private SearchPage searchPage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    searchPage = new SearchPage(driver);
  }

  @Test
  public void testSearch() {
    searchPage.connect();
    String keyword = "vonat";
    searchPage.search(keyword);
    Assert.assertEquals("https://forum.index.hu/Search/fastSearchTopic", driver.getCurrentUrl());

    Assert.assertTrue(searchPage.getFirstResultTopic().contains(keyword));
  }

  @Test
  public void testSearchAfterLogin() {
    searchPage.connect();

    searchPage.login(properties.getProperty("email"), properties.getProperty("password"));
    Assert.assertEquals(properties.getProperty("name"), searchPage.getLoggedInUsername());

    String keyword = "busz";
    searchPage.search(keyword);
    Assert.assertEquals("https://forum.index.hu/Search/fastSearchTopic", driver.getCurrentUrl());

    Assert.assertTrue(searchPage.getFirstResultTopic().contains(keyword));
  }

  @Test
  public void testSearchForNickname() {
    searchPage.connect();

    searchPage.searchForNickname(properties.getProperty("name"));

    Assert.assertEquals("https://forum.index.hu/User/UserSearch", driver.getCurrentUrl());
    Assert.assertEquals(properties.getProperty("name"), searchPage.getFirstResultTopic());
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
