package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchPage extends PageBase {
  public static final String URL = "https://forum.index.hu/Search/fastSearchTopic";

  public final By cookieConsentButtonBy = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");
  public final By searchBoxBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[1]");
  public final By searchButtonBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[2]");
  public final By resultTopicBy = By.xpath("//*[@id=\"content1col\"]/tbody/tr[2]/td[2]/a");
  public final By hitCountBy = By.xpath("//*[@id=\"maintd\"]/form[1]/table/tbody/tr/td[2]/select");

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

  public String getFirstResultTopic() {
    return waitAndReturnElement(resultTopicBy).getText();
  }

  public int getHitCountPerPage() {
    return Integer.parseInt(new Select(waitAndReturnElement(hitCountBy)).getFirstSelectedOption().getText());
  }
}
