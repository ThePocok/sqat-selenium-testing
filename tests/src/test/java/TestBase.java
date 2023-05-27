import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
  protected WebDriver driver;

  protected Properties properties = new Properties();

  protected void createWebDriver() throws IOException {
    ChromeOptions options = new ChromeOptions();
    driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
    driver.manage().window().maximize();

    properties.load(new FileInputStream("src/test/resources/configuration.properties"));

  }
}
