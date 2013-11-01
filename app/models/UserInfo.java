package models;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
public class UserInfo {
 
  private String name;
  private String email;
  private String password;
  private ContactDB contactDB;
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    setContactDB(new ContactDB());
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the contactDB
   */
  public ContactDB getContactDB() {
    return contactDB;
  }

  /**
   * @param contactDB the contactDB to set
   */
  public void setContactDB(ContactDB contactDB) {
    this.contactDB = contactDB;
  }

}
