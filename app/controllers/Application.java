package controllers;

import models.Standing;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.Index;
import views.html.Login;
import views.html.NewContact;
import views.formdata.ContactFormData;
import views.formdata.LoginFormData;
import views.formdata.RegisterFormData;
import views.formdata.TelephoneTypes;


/**
 * Implements the controllers for this application.
 */
public class Application extends Controller {

  /**
   * Provides the Index page (only to unauthenticated users).
   * @return The Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result index() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    return ok(Index.render("Home", userInfo.getContactDB().getContacts(userInfo.getEmail()), isLoggedIn, userInfo));
  }
  
  /**
   * Returns the new Contact page and/or updates an existing contact.
   * @return The new Contact page
   * @param id The id of the contact.
   */
  @Security.Authenticated(Secured.class)
  public static Result newContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    ContactFormData data = (id == -1) ? new ContactFormData() : new ContactFormData(userInfo.getContactDB().getContact(userInfo.getEmail(), id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render("New Contact", isLoggedIn, userInfo, formData, TelephoneTypes.getTypes(), Standing.getNameList()));
    
  }
  
  /**
   * Returns the Index page, and deletes the contact with the given id.
   * @return The Index page.
   * @param id the id of the contact to delete.
   */
  @Security.Authenticated(Secured.class)
  public static Result deleteContact(long id) {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    userInfo.getContactDB().deleteContact(id);
    return ok(Index.render("Home", userInfo.getContactDB().getContacts(userInfo.getEmail()), isLoggedIn, userInfo));
    
  }
  
  /**
   * Returns the new contact page, with error messages if there were invalid fields.
   * @return The new contact page.
   */
  @Security.Authenticated(Secured.class)
  public static Result postContact() {
    UserInfo userInfo = UserInfoDB.getUser(request().username());
    Boolean isLoggedIn = (userInfo != null);
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();
    
    if (formData.hasErrors()) {
      return badRequest(NewContact.render("New Contact", isLoggedIn, userInfo, formData, TelephoneTypes.getTypes(), Standing.getNameList()));
    }
    else {
      ContactFormData data = formData.get();
      userInfo.getContactDB().addContact(userInfo.getEmail(), data);
      return ok(NewContact.render("New Contact", isLoggedIn, userInfo, formData, TelephoneTypes.getTypes(), Standing.getNameList()));
    }
  }
  
  /**
   * Provides the Login page (only to unauthenticated users). 
   * @return The Login page. 
   */
  public static Result login() {
    Form<LoginFormData> formData = Form.form(LoginFormData.class);
    Form<RegisterFormData> formData2 = Form.form(RegisterFormData.class);
    return ok(Login.render("Login", false, null, formData, formData2));
  }

  /**
   * Processes a login form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> formData = Form.form(LoginFormData.class).bindFromRequest();
    Form<RegisterFormData> formData2 = Form.form(RegisterFormData.class);
    if (formData.hasErrors()) {
      flash("error", "Login credentials not valid.");
      return badRequest(Login.render("Login", false, null, formData, formData2));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", formData.get().email);
      return redirect(routes.Application.index());
    }
  }
  
  /**
   * Processes a registration form submission from an unauthenticated user. 
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data. 
   * If errors not found, render the page with the good data. 
   * @return The index page with the results of validation. 
   */
  public static Result postRegister() {

    // Get the submitted form data from the request object, and run validation.
    Form<RegisterFormData> formData = Form.form(RegisterFormData.class).bindFromRequest();
    Form<LoginFormData> formData2 = Form.form(LoginFormData.class);
    if (formData.hasErrors()) {
      flash("error", "Missing required fields.");
      if (formData.errors().containsKey("email2")) {
        flash("error", "Email already in use.");
      }
      return badRequest(Login.render("Login", false, null, formData2, formData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      //session().clear();
      //session("email", formData.get().email);
      RegisterFormData temp = formData.get();
      UserInfoDB.addUserInfo(temp.name, temp.email, temp.password);
      return login();
    }
  }
  
  /**
   * Logs out (only for authenticated users) and returns them to the Index page. 
   * @return A redirect to the Index page. 
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }
  
}
