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
  
  private Map<Long, Contact> contacts = new HashMap<Long, Contact>();

  /**
   * Updates the repo with a new Contact if id = 0 or update a pre existing contact if id != 0.
   * @param formData the contact form data to add.
   * @return Contact the newly created contact to return.
   */
  public Contact addContact(ContactFormData formData) {
    List<Contact> tempList = getContacts();
    long idVal;
    if (!tempList.isEmpty()) {
      idVal = (formData.id == 0) ? tempList.get(tempList.size() - 1).getId() + 1 : formData.id;
    }
    else {
      idVal = 1;
    }
    Contact contact = new Contact(idVal, formData.firstName, formData.lastName, formData.telephone, 
          formData.telephoneType, formData.standing);
    contacts.put(idVal,  contact);
    return contact;
  }
  
  /**
   * Updates the repository with a new Contact if id = 0 or update a pre-existing contact if id != 0.
   * @param id the id.
   */
  public void deleteContact(long id) {
    contacts.remove(id);
  }
  
  
  /**
   * Returns the list of contacts.
   * @return List of Contacts.
   */
  public List<Contact> getContacts() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Returns the list of contacts.
   * @return List of Contacts.
   */
  public List<Contact> getContacts2() {
    return new ArrayList<>(contacts.values());
  }
  
  /**
   * Returns a Contact object.
   * @param id the id.
   * @return Contact based on the id.
   */
  public Contact getContact(long id) {
    Contact contact = contacts.get(id);
    if (contact == null) {
      throw new RuntimeException("Passed an invalid id: " + id); 
    }
    return contact;
  }

}
