package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends NespressoBase {
  public static final String URL = "https://www.nespresso.com/hu/hu";

  public final By titleBy = By.xpath("//*[@id=\"visible_h3\"]/div/h1");
  public final By declineCookiesButtonBy = By.id("_evidon-decline-button");
  public final By cookieConsentTitleBy = By.xpath("//*[@id=\"_evidon-title\"]");


  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void connect() {
    driver.get(URL);
  }

  public WebElement getTitle() {
    return waitAndReturnElement(titleBy);
  }

  public WebElement getCookieConsentTitle() {
    return waitAndReturnElement(cookieConsentTitleBy);
  }

  public boolean isCookieConsentPopupShown() {
    return driver.findElements(cookieConsentTitleBy).size() > 0;
  }

  public void declineCookies() {
    waitAndReturnElement(declineCookiesButtonBy).click();
  }
}
