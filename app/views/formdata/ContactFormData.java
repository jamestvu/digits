package views.formdata;

import java.util.ArrayList;
import java.util.List;
import models.Contact;
import models.Standing;
import play.data.validation.ValidationError;

/**
 * Stores the Contact form data object.
 * 
 * @author Owner
 *
 */
public class ContactFormData {
  
  private static final int NUM_TELEPHONE_DIGITS = 12;
  /** The first name. */
  public String firstName = "";
  /** The last name. */
  public String lastName = "";
  /** The phone number. */
  public String telephone = "";
  /** The phone number type. */
  public String telephoneType = "";
  /** The class standing. */
  public String standing = "";
  /** The id. */
  public long id = -1;
  
  /**
   * Default Constructor.
   */
  public ContactFormData() {
    
  }
  /**
   * Creates a Cfd based a contact object.
   * @param formData
   * @param formData the form data.
   */
  public ContactFormData(Contact formData) {
    this.firstName = formData.getFirstName();
    this.id = formData.getId();
    this.lastName = formData.getLastName();
    this.telephone = formData.getTelephone();
    this.telephoneType = formData.getTelephoneType();
    this.standing = formData.getStanding();
  }
  /**
   * Checks that form fields are valid. Called by bindFormRequest().
   * @return null if valid, a list of ValidationError if problem is found.
   */
  public List<ValidationError> validate()  {
    List<ValidationError> errors = new ArrayList<>();
    
    if (firstName == null || firstName.length() == 0) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    
    if (lastName == null || lastName.length() == 0) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    
    if (telephone == null || telephone.length() == 0) {
      errors.add(new ValidationError("telephone", "Telephone number is required."));
    }
    
    if (telephone.length() != NUM_TELEPHONE_DIGITS) {
      errors.add(new ValidationError("telephone", "Telephone number must follow the format xxx-xxx-xxxx."));
    }
    
    if (!TelephoneTypes.isType(telephoneType)) {
      errors.add(new ValidationError("telephoneType", "Please select a telephone type."));
    }
    
    // Grade Level is required and must exist in database.
    if (standing == null || standing.length() == 0) {
      errors.add(new ValidationError("standing", "No standing was given."));
    } 
    else if (Standing.findLevel(standing) == null) {
      errors.add(new ValidationError("standing", "Invalid standing: " + standing + "."));
    }
    
    return errors.isEmpty() ? null : errors;
  }
}
