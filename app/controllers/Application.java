package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Index;
import views.html.NewContact;
import views.formdata.ContactFormData;
import views.formdata.TelephoneTypes;


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
   * Returns the new Contact page and/or updates an existing contact.
   * @return The new Contact page
   * @param id The id of the contact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData, TelephoneTypes.getTypes()));
    
  }
  
  /**
   * Returns the Index page, and deletes the contact with the given id.
   * @return The Index page.
   * @param id the id of the contact to delete.
   */
  public static Result deleteContact(long id) {
    ContactDB.deleteContact(id);
    return ok(Index.render(ContactDB.getContacts()));
    
  }
  
  /**
   * Returns the new contact page, with error messages if there were invalid fields.
   * @return The new contact page.
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.addContact(data);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
  }
  
  
}
