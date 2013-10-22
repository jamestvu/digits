

import models.ContactDB;
import models.Standing;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;



/**
 * Overrides the startup.
 * @author Owner
 *
 */
public class Global extends GlobalSettings {

  public void onStart(Application app) {
      ContactFormData c1 = new ContactFormData();
      c1.firstName = "Phillip";
      c1.lastName = "Johnson";
      c1.telephone = "123-456-7890";
      c1.telephoneType = "Home";
      c1.standing = Standing.findLevel("N/A").getName();
      ContactDB.addContact(c1);
      
      c1 = new ContactFormData();
      c1.firstName = "Phillip2";
      c1.lastName = "Johnson2";
      c1.telephone = "123-456-7890";
      c1.telephoneType = "Home1";
      c1.standing = Standing.findLevel("Freshman").getName();
      ContactDB.addContact(c1);
      
      c1 = new ContactFormData();
      c1.firstName = "Phillip3";
      c1.lastName = "Johnson3";
      c1.telephone = "123-456-7890";
      c1.telephoneType = "Home1";
      c1.standing = "burp";
      ContactDB.addContact(c1);
      
      c1 = new ContactFormData();
      c1.firstName = "Phillip4";
      c1.lastName = "Johnson4";
      c1.telephone = "123-456-7890";
      c1.telephoneType = "Home1";
      c1.standing = Standing.findLevel("Junior").getName();
      ContactDB.addContact(c1);
      
  }

}