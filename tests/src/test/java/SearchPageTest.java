import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import webpages.HomePage;
import webpages.SearchPage;

public class SearchPageTest extends NespressoTestBase{
  private SearchPage searchPage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    searchPage = new SearchPage(driver);
  }

  @Test
  public void testSearch() {
    searchPage.connect();

    searchPage.search("vonat");
    Assert.assertEquals("https://forum.index.hu/Search/fastSearchTopic", driver.getCurrentUrl());
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
