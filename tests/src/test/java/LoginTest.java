import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import webpages.HomePage;

public class LoginTest extends NespressoTestBase{
  private HomePage homePage;

  @Before
  public void setup() throws IOException {
    //createWebDriver();
    //homePage = new HomePage(driver);
  }

  @Test
  public void testLoginWithCorrectData() throws MalformedURLException {
    ChromeOptions options = new ChromeOptions();
    driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    driver.manage().window().maximize();

    driver.get(HomePage.URL);

    //homePage.login(properties.getProperty("email"), properties.getProperty("password"));
  }
}
