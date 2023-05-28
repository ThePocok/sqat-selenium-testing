package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopicPage extends PageBase {
  private String URL;
  private By topicBy = By.xpath("//*[@id=\"navilast\"]/a");
  private By lastCommentBy = By.xpath("//*[@id=\"maintd\"]/table[1]/tbody/tr[1]/td[3]/span[2]");
  private By topicOpenedDateBy = By.xpath("//*[@id=\"naviheader\"]/div[5]");

  public TopicPage(WebDriver driver, String URL) {
    super(driver);
    this.URL = URL;
  }

  public void connect() {
    driver.get(URL);
    waitAndReturnElement(cookieConsentButtonBy).click();
  }

  public String getTopic() {
    return waitAndReturnElement(topicBy).getText();
  }

  public Integer getLastCommentId() {
    return Integer.parseInt(waitAndReturnElement(lastCommentBy).getText());
  }

  public String getTopicOpenedDate() {
    String topicMetaData = waitAndReturnElement(topicOpenedDateBy).getText();
    String topicOpenerAndDate = topicMetaData.split("\\|")[0];
    return topicOpenerAndDate.split(",")[1].trim();
  }
}
