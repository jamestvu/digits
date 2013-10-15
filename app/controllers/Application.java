package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page. 
   * @return The resulting home page. 
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result newContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));
    
  }
  
  /**
   * Returns page1, a simple example of a second page to illustrate navigation.
   * @return The Page1.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      return ok(NewContact.render(formData));
    }
  }
  
  
}
