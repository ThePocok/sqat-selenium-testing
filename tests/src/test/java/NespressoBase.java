import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NespressoBase {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public NespressoBase(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, 10);
  }
}
