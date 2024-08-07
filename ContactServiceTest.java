import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        Assertions.assertTrue(contactService.getContacts().containsKey("1"));
        Assertions.assertEquals(contact, contactService.getContacts().get("1"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        contactService.deleteContact("1");

        Assertions.assertFalse(contactService.getContacts().containsKey("1"));
    }

    @Test
    public void testUpdateContact() {
        Contact originalContact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact updatedContact = new Contact("1", "Jane", "Smith", "9876543210", "456 Oak St");

        contactService.addContact(originalContact);
        contactService.updateContact("1", updatedContact);

        Assertions.assertEquals(updatedContact, contactService.getContacts().get("1"));
    }
}
