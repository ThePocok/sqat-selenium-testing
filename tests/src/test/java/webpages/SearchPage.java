package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends PageBase {
  public static final String URL = "https://forum.index.hu/Search/fastSearchTopic";

  public final By cookieConsentButtonBy = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");
  public final By searchBoxBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[1]");
  public final By searchButtonBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[1]");

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public void connect() {
    driver.get(URL);
    waitAndReturnElement(cookieConsentButtonBy).click();
  }

  public void search(String keyword) {
    waitAndReturnElement(searchBoxBy).sendKeys(keyword);
    waitAndReturnElement(searchButtonBy).click();
  }
}
