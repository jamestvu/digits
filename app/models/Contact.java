package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

/**
 * Provides a model for a contact object.
 * @author James Vu
 *
 */
@Entity
public class Contact extends Model{

  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String telephone;
  private String telephoneType;
  private String standing;
  @Id
  private long id;
  
  //Many of me (contacts) to one of the following (UserInfo)
  @ManyToOne
  private UserInfo userInfo;
  /**
   * @return the userInfo
   */
  public UserInfo getUserInfo() {
    return userInfo;
  }
  /**
   * @param userInfo the userInfo to set
   */
  public void setUserInfo(UserInfo userInfo) {
    this.userInfo = userInfo;
  }
  
  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method for products.
   */
  public static Finder<Long, Contact> find() {
    return new Finder<Long, Contact>(Long.class, Contact.class);
  }

  
  /**
   * Creates a new contact.
   * @param firstName The first name.
   * @param lastName The last name.
   * @param telephone The telephone number.
   * @param telephoneType The telephone type.
   * @param standing The class standing.
   */
   public Contact(String firstName, String lastName, String telephone, String telephoneType, String standing) {
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
