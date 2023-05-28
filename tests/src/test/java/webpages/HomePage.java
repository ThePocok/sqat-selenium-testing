package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
  public static final String URL = "https://forum.index.hu/Topic/showTopicList";

  private final By titleImageBy = By.xpath("//*[@id=\"mainheader\"]/table/tbody/tr/td[1]/img");
  private final By footerLinkBy = By.xpath("//*[@id=\"inda_footer\"]/div[1]/h4/a");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void connect() {
    driver.get(URL);
    waitAndReturnElement(cookieConsentButtonBy).click();
  }

  public String getTitleImageAlt() {
    return waitAndReturnElement(titleImageBy).getAttribute("alt");
  }

  public String getFooterLink() {
    return waitAndReturnElement(footerLinkBy).getText();
  }
}
