
import models.ContactDB;
import models.Standing;
import models.UserInfoDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;



/**
 * Overrides the startup.
 * @author Owner
 *
 */
public class Global extends GlobalSettings {
  
  /**
   * Initializes four contacts on start.
   * @param app The application.
   */
  public void onStart(Application app) {
    ContactDB contactDB1 = new ContactDB();
    ContactDB contactDB2 = new ContactDB();
    
    ContactFormData c1 = new ContactFormData();
    c1.id = 1;
    c1.firstName = "Phillip";
    c1.lastName = "Johnson";
    c1.telephone = "123-456-7890";
    c1.telephoneType = "Home";
    c1.standing = Standing.findLevel("N/A").getName();
    contactDB1.addContact(c1);
    
    c1 = new ContactFormData();
    c1.id = 2;
    c1.firstName = "Phillip2";
    c1.lastName = "Johnson2";
    c1.telephone = "123-456-7890";
    c1.telephoneType = "Home";
    c1.standing = Standing.findLevel("Freshman").getName();
    contactDB1.addContact(c1);
    
    c1 = new ContactFormData();
    c1.id = 3;
    c1.firstName = "Phillip3";
    c1.lastName = "Johnson3";
    c1.telephone = "123-456-7890";
    c1.telephoneType = "Home";
    c1.standing = "Senior";
    contactDB1.addContact(c1);
    
    c1 = new ContactFormData();
    c1.id = 4;
    c1.firstName = "Phillip5";
    c1.lastName = "Johnson4";
    c1.telephone = "123-456-7890";
    c1.telephoneType = "Home";
    c1.standing = Standing.findLevel("Junior").getName();
    contactDB1.addContact(c1);
    contactDB2.addContact(c1);
    
    UserInfoDB.addUserInfo("John Smith", "smith@example.com", "password");
    UserInfoDB.getUser("smith@example.com").setContactDB(contactDB1);
    UserInfoDB.addUserInfo("John Smith2", "smith2@example.com", "password");
    UserInfoDB.getUser("smith2@example.com").setContactDB(contactDB2);
    
  }

}