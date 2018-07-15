package de.davelee.trams.customer.services;

import de.davelee.trams.customer.data.CustomerFeedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test operations for customer feedback database through the CustomerFeedbackService.
 * @author Dave Lee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/test-database-context.xml")
public class CustomerFeedbackServiceTest {

    @Autowired
    private CustomerFeedbackService customerFeedbackService;

    @Test
    /**
     * Test case: Creates a customer feedback object and saves it to the database. Checks to see if the object was successfully saved into the database.
     * An in-memory database is used for this test.
     * Expected result: the data was inserted into the database as the count is then 1.
     */
    public void testInsertDatabase ( ) {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("max@mustermann.de");
        customerFeedback.setTelephoneNumber("08008008008");
        customerFeedbackService.addCustomerFeedback(customerFeedback);
        assertEquals(1, customerFeedbackService.getNumCustomerFeedback());
    }
}
