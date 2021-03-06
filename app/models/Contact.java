package models;

/**
 * Provides a model for a contact object.
 * @author James Vu
 *
 */
public class Contact {
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  private String standing;
  private long id;
  
  /**
   * Creates a new contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param id The id of the contact.
   * @param telephoneType The telephone type.
   * @param standing The class standing.
   */
   public Contact(long id, String firstName, String lastName, String telephone, String telephoneType, String standing) {
     this.setId(id);
     this.firstName = firstName;
     this.lastName = lastName;
     this.telephone = telephone;
     this.telephoneType = telephoneType;
     this.standing = standing;
   }
  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }
  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  /**
   * @return the telephone
   */
  public String getTelephone() {
    return telephone;
  }
  /**
   * @param telephone the telephone to set
   */
  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }
  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }
  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  /**
   * @return the id
   */
  public long getId() {
    return id;
  }
  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }
  /**
   * @return the telephoneType
   */
  public String getTelephoneType() {
    return telephoneType;
  }
  /**
   * @param telephoneType the telephoneType to set
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }
  /**
   * @return the standing
   */
  public String getStanding() {
    return standing;
  }
  /**
   * @param standing the standing to set
   */
  public void setStanding(String standing) {
    this.standing = standing;
  }
}
