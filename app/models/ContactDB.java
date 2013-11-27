package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import views.formdata.ContactFormData;

/**
 * Provides a simple in memory repository for Contact data.
 * @author Owner
 *
 */
public class ContactDB {
  
  /**
   * Updates the repo with a new Contact if id = -1 or update a pre existing contact if id != -1.
   * @param formData the contact form data to add.
   * @return Contact the newly created contact to return.
   */
  public void addContact(String user, ContactFormData formData) {
    boolean isNewContact = formData.id == -1;
    if (isNewContact) {
      Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone, 
          formData.telephoneType, formData.standing);
      UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
      if (userInfo == null) {
        throw new RuntimeException("Could not find user: " + user);
      }
      userInfo.addContact(contact);
      contact.setUserInfo(userInfo);
      contact.save();
      userInfo.save();
    }
    else {
      Contact contact = Contact.find().byId(formData.id);
      contact.setFirstName(formData.firstName);
      contact.setLastName(formData.lastName);
      contact.setTelephone(formData.telephone);
      contact.setTelephoneType(formData.telephoneType);
      contact.save();
    }
  }
  
  /**
   * Updates the repository with a new Contact if id = -1 or update a pre-existing contact if id != -1.
   * @param id the id.
   */
  public void deleteContact(long id) {
    //contacts.remove(id);
  }
  
  /**
   * Returns true if the user is defined in the Contacts DB.
   * @param user The user.
   * @return True if the user is defind.
   */
  public boolean isUser(String user) {
    return UserInfo.find().where().eq("email", user).findUnique() != null;
  }
  /**
   * Returns the list of contacts.
   * @return List of Contacts.
   */
  public List<Contact> getContacts(String user) {
    UserInfo userInfo = UserInfo.find().where().eq("email", user).findUnique();
    if (userInfo == null) {
      return null;
    }
    else {
      return userInfo.getContacts();
    }
  }
  
  /**
   * Returns a Contact object.
   * @param id the id.
   * @return Contact based on the id.
   */
  public Contact getContact(String user, long id) {
    Contact contact = Contact.find().byId(id);
    if (contact == null) {
      throw new RuntimeException("Contact ID not found");
    }
    UserInfo userInfo = contact.getUserInfo();
    if (!user.equals(userInfo.getEmail())) {
      throw new RuntimeException("User not the same one stored with the contact.");
    }
    return contact;
  }

}
