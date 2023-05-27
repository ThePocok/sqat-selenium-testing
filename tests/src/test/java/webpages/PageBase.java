package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public PageBase(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }

  public WebElement waitAndReturnElement(By locator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    return driver.findElement(locator);
  }

}
