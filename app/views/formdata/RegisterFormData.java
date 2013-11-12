package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.UserInfoDB;
import play.data.validation.ValidationError;


/**
 * Backing class for the login form.
 */
public class RegisterFormData {
  
  /** The submitted name. */
  public String name = "";
  /** The submitted email. */
  public String email = "";
  /** The submitted password. */
  public String password = "";

  /** Required for form instantiation. */
  public RegisterFormData() {
  }

  /**
   * Validates Form<LoginFormData>.
   * Called automatically in the controller by bindFromRequest().
   * Checks to see that email and password are valid credentials.
   * @return Null if valid, or a List[ValidationError] if problems found.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();
    
    if (email.isEmpty()) {
      errors.add(new ValidationError("email", "email address required."));
    }
    
    if (UserInfoDB.isUser(email)) {
      errors.add(new ValidationError("email2", "email address already in use."));
    }
    
    if (password.isEmpty()) {
      errors.add(new ValidationError("password", "Password required."));
    }
    
    if (name.isEmpty()) {
      errors.add(new ValidationError("name", "Name field required."));
    }
    return (errors.size() > 0) ? errors : null;
  }

}
