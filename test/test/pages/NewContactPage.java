package test.pages;

import org.fluentlenium.core.FluentPage;
import org.openqa.selenium.WebDriver;
import play.Play;
// Although Eclipse marks the following two methods as deprecated, 
// the no-arg versions of the methods used here are not deprecated.  (as of May, 2013).
import static org.fluentlenium.core.filter.FilterConstructor.withText; 
import static org.fluentlenium.core.filter.FilterConstructor.withId;  
import static org.fest.assertions.Assertions.assertThat;

/**
 * Implements index page behavior.  
 * @author Philip Johnson
 */
public class NewContactPage extends FluentPage {
  private String url;
  
  /**
   * Create the IndexPage.
   * @param webDriver The driver.
   * @param port The port.
   */
  public NewContactPage(WebDriver webDriver, int port) {
    super(webDriver);
    this.url = "http://localhost:" + port + "/newContact";
  }
  
  @Override
  public String getUrl() {
    return this.url;
  }
  
  @Override
  public void isAt() {
    assertThat(title()).isEqualTo("Home");
  }
  
  public void isAtNewContactPage()   {
    assertThat(title()).isEqualTo("New Contact");
  }
  
  public void login() {
    String adminEmail = "admin@example.com";
    String adminPassword = Play.application().configuration().getString("digits.admin.password");
    fill("#email").with(adminEmail);
    fill("#password").with(adminPassword);
    submit("#submit");
  }
  
  public void addContact() {
    click("#newContact");
    isAtNewContactPage();
    fill("#firstName").with("Test");
    fill("#lastName").with("Test");
    fill("#telephone").with("808-123-4567");
    fill("#telephoneType").with("Mobile");
    fill("#Senior");
    submit("#submit");
    isAtNewContactPage();
    click("#home");
    isAt();
    
  }
}
