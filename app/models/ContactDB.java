package models;

import java.util.ArrayList;
import java.util.List;
import views.formdata.ContactFormData;

/**
 * Provides a simple in memory repository for Contact data.
 * @author Owner
 *
 */
public class ContactDB {
  
  private static List<Contact> contacts = new ArrayList<>();

  /**
   * Adds a contact to the list.
   * @param formData the contact form data to add.
   * @return Contact the newly created contact to return.
   */
  public static Contact addContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.telephone);
    contacts.add(contact);
    return contact;
  }
  /**
   * Returns the list of contacts.
   * @return List of Contacts.
   */
  public static List<Contact> getContacts() {
    return contacts;
  }

}
