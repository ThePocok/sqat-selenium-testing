package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageBase {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public static final By emailBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[1]");
  public static final By passwordBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[2]");
  public static final By sendLoginFormButtonBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[2]/input");
  public final By logoutButtonBy = By.xpath("//*[@id=\"leftcol\"]/div[1]/ul/li[9]/a");
  public final By loggedInUsernameBy = By.xpath("//*[@id=\"leftcol\"]/div[1]/h4");

  public PageBase(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }

  public WebElement waitAndReturnElement(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return driver.findElement(locator);
  }

  public void implicitWait(int time, TimeUnit timeUnit) {
    driver.manage().timeouts().implicitlyWait(time, timeUnit);
  }

  public void login(String email, String password) {
    waitAndReturnElement(emailBy).sendKeys(email);
    waitAndReturnElement(passwordBy).sendKeys(password);

    implicitWait(2, TimeUnit.SECONDS);

    waitAndReturnElement(sendLoginFormButtonBy).click();
  }

  public String getLoggedInUsername() {
    return waitAndReturnElement(loggedInUsernameBy).getText();
  }

  public void logout() {
    waitAndReturnElement(logoutButtonBy).click();
  }

}
