import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, Contact updatedContact) {
        if (contacts.containsKey(contactId)) {
            contacts.put(contactId, updatedContact);
        }
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }
}
