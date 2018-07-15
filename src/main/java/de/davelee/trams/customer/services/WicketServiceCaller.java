package de.davelee.trams.customer.services;

import de.davelee.trams.customer.api.CustomerFeedbackModel;
import de.davelee.trams.customer.data.CustomerFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class WicketServiceCaller {

    @Autowired
    private CustomerFeedbackService customerFeedbackService;

    private static CustomerFeedbackService staticCustomerFeedbackService;

    @PostConstruct
    public void init ( ) {
        staticCustomerFeedbackService = this.customerFeedbackService;
    }

    /**
     * Get all of the customer feedbacks in the database.
     * @return a <code>CustomerFeedbackModel</code> List containing all feedbacks in the database.
     */
    public static List<CustomerFeedbackModel> getAllCustomerFeedbackModels() {
        List<CustomerFeedback> customerFeedbacks = staticCustomerFeedbackService.getAllCustomerFeedbacks();
        List<CustomerFeedbackModel> customerFeedbackModels = new ArrayList<>();
        for ( CustomerFeedback customerFeedback : customerFeedbacks ) {
            customerFeedbackModels.add(convertToCustomerFeedbackModel(customerFeedback));
        }
        return customerFeedbackModels;
    }

    /**
     * Get all of the customer feedbacks matching the filtered email address in the database.
     * @param emailAddress a <code>String</code> containing the email address to filter by.
     * @return a <code>CustomerFeedbackModel</code> List containing all feedbacks matching the email address in the database.
     */
    public static List<CustomerFeedbackModel> getFilteredCustomerFeedbackModels(final String emailAddress) {
        List<CustomerFeedback> customerFeedbacks = staticCustomerFeedbackService.getFilteredCustomerFeedbacks(emailAddress);
        List<CustomerFeedbackModel> customerFeedbackModels = new ArrayList<>();
        for ( CustomerFeedback customerFeedback : customerFeedbacks ) {
            customerFeedbackModels.add(convertToCustomerFeedbackModel(customerFeedback));
        }
        return customerFeedbackModels;
    }

    /**
     * Private helper method to convert a CustomerFeedback object from the database to a CustomerFeedbackModel object which can
     * be displayed in the User Interface.
     * @param customerFeedback a <code>CustomerFeedback</code> object to convert.
     * @return a <code>CustomerFeedbackModel</code> object which can be displayed in the user interface.
     */
    private static CustomerFeedbackModel convertToCustomerFeedbackModel (final CustomerFeedback customerFeedback ) {
        CustomerFeedbackModel customerFeedbackModel = new CustomerFeedbackModel();
        customerFeedbackModel.setAddress(customerFeedback.getAddress());
        customerFeedbackModel.setExtraInfos(customerFeedback.getExtraInfos());
        customerFeedbackModel.setEmailAddress(customerFeedback.getEmailAddress());
        customerFeedbackModel.setFirstName(customerFeedback.getFirstName());
        customerFeedbackModel.setMessage(customerFeedback.getMessage());
        customerFeedbackModel.setSurname(customerFeedback.getSurname());
        customerFeedbackModel.setTelephoneNumber(customerFeedback.getTelephoneNumber());
        customerFeedbackModel.setTitle(customerFeedback.getTitle());
        return customerFeedbackModel;
    }

}
