package de.davelee.trams.customer.rest.controllers;

import de.davelee.trams.customer.api.CustomerFeedbackModel;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test the customer interaction rest controller and in particular the validateInput method.
 * @author Dave Lee
 */
public class CustomerInteractionRestControllerTest {

    @Test
    /**
     * Test case: customer feedback without a title.
     * Expected result: false (input is not valid).
     */
    public void titleMayNotBeNull ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("max@mustermann.de");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback without a first name.
     * Expected result: false (input is not valid).
     */
    public void firstNameMayNotBeNull ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("max@mustermann.de");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback without a surname.
     * Expected result: false (input is not valid).
     */
    public void surnameMayNotBeNull ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setEmailAddress("max@mustermann.de");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback without an email address.
     * Expected result: false (input is not valid).
     */
    public void emailAddressMayNotBeNull ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback without a telephone number.
     * Expected result: false (input is not valid).
     */
    public void telephoneNumberMayNotBeNull ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("max@mustermann.de");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback has an invalid email address.
     * Expected result: false (input is not valid).
     */
    public void emailIsNotValid ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("maxmustermannde");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertFalse(restController.validateInput(customerFeedback));
    }

    @Test
    /**
     * Test case: customer feedback object is valid.
     * Expected result: true (input is valid).
     */
    public void inputIsValid ( ) {
        CustomerFeedbackModel customerFeedback = new CustomerFeedbackModel();
        customerFeedback.setTitle("Mr");
        customerFeedback.setFirstName("Max");
        customerFeedback.setSurname("Mustermann");
        customerFeedback.setEmailAddress("max@mustermann.de");
        customerFeedback.setTelephoneNumber("08008008008");
        CustomerInteractionRestController restController = new CustomerInteractionRestController();
        assertTrue(restController.validateInput(customerFeedback));
    }

}
