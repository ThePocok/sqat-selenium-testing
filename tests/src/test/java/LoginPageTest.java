import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import webpages.LoginPage;

public class LoginPageTest extends NespressoTestBase{
  private LoginPage loginPage;

  @Before
  public void setup() throws IOException {
    createWebDriver();
    loginPage = new LoginPage(driver);
  }

  @Test
  public void testLoginWithCorrectData(){
    driver.get(LoginPage.URL);

    loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
