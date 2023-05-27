package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SearchPage extends PageBase {
  public static final String URL = "https://forum.index.hu/Search/fastSearchTopic";

  private final By cookieConsentButtonBy = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");
  private final By searchBoxBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[1]");
  private final By searchButtonBy = By.xpath("//*[@id=\"kereso\"]/div/form/input[2]");
  private final By resultTopicBy = By.xpath("//*[@id=\"content1col\"]/tbody/tr[2]/td[2]/a");
  private final By searchInCategoryBy = By.xpath("//*[@id=\"kereso\"]/div/form/select");

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

  public void searchForNickname(String nickname) {
    waitAndReturnElement(searchBoxBy).sendKeys(nickname);
    setSearchCategoryToNicknames();

    waitAndReturnElement(searchButtonBy).click();
  }

  public String getFirstResultTopic() {
    return waitAndReturnElement(resultTopicBy).getText();
  }

  private void setSearchCategoryToNicknames() {
    Select select = new Select(waitAndReturnElement(searchInCategoryBy));
    select.selectByValue("/User/UserSearch");

    implicitWait(1, TimeUnit.SECONDS);
  }
}
