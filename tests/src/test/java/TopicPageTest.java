import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import webpages.TopicPage;

@RunWith(Parameterized.class)
public class TopicPageTest extends TestBase{
  private TopicPage topicPage;

  private String URL;
  private String topic;
  private String lastComment;
  private String topicOpened;


  @Parameters
  public static Collection<String[]> data() throws IOException {
    File folder = new File("src/test/resources/pages");
    File[] listOfFiles = folder.listFiles();
    ArrayList<String[]> pageProperties = new ArrayList<>();

    assert listOfFiles != null;
    for (File f  : listOfFiles) {
      Properties properties = new Properties();
      properties.load(new FileInputStream("src/test/resources/pages/" + f.getName()));

      pageProperties.add(new String[]{
          properties.getProperty("url"),
          properties.getProperty("topic"),
          properties.getProperty("lastComment"),
          properties.getProperty("topicOpened"),
      });
    }

    return pageProperties;
  }

  public TopicPageTest(String URL, String topic, String lastComment, String topicOpened) {
    this.URL = URL;
    this.topic = topic;
    this.lastComment = lastComment;
    this.topicOpened = topicOpened;
  }

  @Before
  public void setup() throws IOException {
    createWebDriver();
    topicPage = new TopicPage(driver, URL);
  }

  @Test
  public void testTopicName() {
    topicPage.connect();

    Assert.assertEquals(topic, topicPage.getTopic());
  }

  @Test
  public void testTopicOpenedDate() {
    topicPage.connect();

    Assert.assertEquals(topicOpened, topicPage.getTopicOpenedDate());
  }

  @Test
  public void testLastCommentId() {
    topicPage.connect();

    Assert.assertTrue(topicPage.getLastCommentId() >= Integer.parseInt(lastComment));
  }

  @After
  public void close() {
    if (driver != null) {
      driver.quit();
    }
  }
}
