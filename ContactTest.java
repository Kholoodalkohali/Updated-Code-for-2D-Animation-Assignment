import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testContactValidation() {
        // Test valid contact
        Contact contact = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Assertions.assertEquals("1", contact.getContactId());
        Assertions.assertEquals("John", contact.getFirstName());
        Assertions.assertEquals("Doe", contact.getLastName());
        Assertions.assertEquals("1234567890", contact.getPhone());
        Assertions.assertEquals("123 Main St", contact.getAddress());

        // Test invalid contact ID (more than 10 characters)
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });

        // Test invalid phone number (less than 10 digits)
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("2", "John", "Doe", "123456789", "123 Main St");
        });

        // Test null firstName
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("3", null, "Doe", "1234567890", "123 Main St");
        });

        // Test firstName longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("4", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });

        // Test null lastName
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("5", "John", null, "1234567890", "123 Main St");
        });

        // Test lastName longer than 10 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("6", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });

        // Test null phone number
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("7", "John", "Doe", null, "123 Main St");
        });

        // Test phone number with non-digit characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("8", "John", "Doe", "1234abc789", "123 Main St");
        });

        // Test null address
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("9", "John", "Doe", "1234567890", null);
        });

        // Test address longer than 30 characters
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("10", "John", "Doe", "1234567890", "1234567890123456789012345678901");
        });
    }
}
