package de.davelee.trams.customer.data;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class tests the CustomerFeedback class to make sure it works properly.
 * @author Dave Lee
 */
public class CustomerFeedbackTest {

    @Test
    /**
     * Test case: check that the getters and setters work as expected.
     * Expected result: the getters return the values given by the setters.
     */
    public void testGettersAndSetters() {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setAddress("Landuff Road");
        assertEquals(customerFeedback.getAddress(), "Landuff Road");
        customerFeedback.setExtraInfos(new HashMap<String, String>());
        assertNotNull(customerFeedback.getExtraInfos());
        customerFeedback.setEmailAddress("test@test.com");
        assertEquals(customerFeedback.getEmailAddress(), "test@test.com");
        customerFeedback.setFirstName("Max");
        assertEquals(customerFeedback.getFirstName(), "Max");
        customerFeedback.setMessage("Test Message");
        assertEquals(customerFeedback.getMessage(), "Test Message");
        customerFeedback.setSurname("Mustermann");
        assertEquals(customerFeedback.getSurname(), "Mustermann");
        customerFeedback.setTelephoneNumber("01234567890");
        assertEquals(customerFeedback.getTelephoneNumber(), "01234567890");
        customerFeedback.setTitle("Mr");
        assertEquals(customerFeedback.getTitle(), "Mr");
    }

}
