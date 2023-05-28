package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {
  public static final String URL = "https://forum.index.hu/Topic/showTopicList";

  private final By titleImageBy = By.xpath("//*[@id=\"mainheader\"]/table/tbody/tr/td[1]/img");
  private final By footerLinkBy = By.xpath("//*[@id=\"inda_footer\"]/div[1]/h4/a");
  private final By loginErrorBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[1]");
  private final By blogHuIconBy = By.xpath("//*[@id=\"inda_footer\"]/div[4]/ul[1]/li[1]/a[1]");
  private final By generalCategoryBy = By.xpath("//*[@id=\"content-left\"]/div[1]/p[1]/a");

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

  public String getLoginErrorMessage() {
    return waitAndReturnElement(loginErrorBy).getText();
  }

  public WebElement getBlogHuIcon() {
    return waitAndReturnElement(blogHuIconBy);
  }

  public void openGeneralCategory() {
    waitAndReturnElement(generalCategoryBy).click();
  }
}
