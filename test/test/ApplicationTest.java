package test;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are interested in mocking a whole application, see
 * the wiki for more details.
 * 
 */
public class ApplicationTest {

  /**
   * Illustrates a simple test.
   */
  @Ignore
  public void simpleCheck() {
    int a = 1 + 1;
    assertThat(a).isEqualTo(2);
  }

  /**
   * Illustrates how to render a template for testing.
   *
  @Test
  public void renderTemplate() {
    Content html = views.html.Index.render(null);
    assertThat(contentType(html)).isEqualTo("text/html");
    assertThat(contentAsString(html)).contains("home page");
  }*/
}
