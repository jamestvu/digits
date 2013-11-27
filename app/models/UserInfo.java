package models;

/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import play.db.ebean.Model;
import play.db.ebean.Model.Finder;
@Entity
public class UserInfo extends Model{
 
  /**
   * Default UID.
   */
  private static final long serialVersionUID = 1L;
  @Id
  private long id;

  private String name;
  private String email;
  private String password;
  private ContactDB contactDB;
  private boolean admin = false;
  
  @OneToMany(mappedBy="userInfo")
  private List<Contact> contacts = new ArrayList<Contact>();


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
   * The EBean ORM finder method for database queries.
   * @return The finder method for products.
   */
  public static Finder<Long, UserInfo> find() {
    return new Finder<Long, UserInfo>(Long.class, UserInfo.class);
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
   * @return the contacts
   */
  public List<Contact> getContacts() {
    return contacts;
  }
  
  /**
   * Adds a contact.
   * @param contact the contact to add.
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }
  /**
   * @param contacts the contacts to set.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * @return the admin
   */
  public boolean isAdmin() {
    return admin;
  }

  /**
   * @param admin the admin to set
   */
  public void setAdmin(boolean admin) {
    this.admin = admin;
  }
}
