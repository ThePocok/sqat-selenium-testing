package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends PageBase {
  public static final String URL = "https://forum.index.hu/Topic/showTopicList";

  public final By titleImageBy = By.xpath("//*[@id=\"mainheader\"]/table/tbody/tr/td[1]/img");
  public final By logoutButtonBy = By.xpath("//*[@id=\"leftcol\"]/div[1]/ul/li[9]/a");
  public final By emailBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[1]");
  public final By passwordBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[1]/input[2]");
  public final By sendLoginFormButtonBy = By.xpath("//*[@id=\"indpl_login_box_180\"]/form/div[3]/div[2]/div[2]/input");
  public final By loggedInUsernameBy = By.xpath("//*[@id=\"leftcol\"]/div[1]/h4");
  public final By cookieConsentButtonBy = By.xpath("//*[@id=\"qc-cmp2-ui\"]/div[2]/div/button[2]");


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

  public void login(String email, String password) {
    waitAndReturnElement(emailBy).sendKeys(email);
    waitAndReturnElement(passwordBy).sendKeys(password);

    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    waitAndReturnElement(sendLoginFormButtonBy).click();
  }

  public String getLoggedInUsername() {
    return waitAndReturnElement(loggedInUsernameBy).getText();
  }

  public void logout() {
    waitAndReturnElement(logoutButtonBy).click();
  }
}
