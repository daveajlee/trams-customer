package de.davelee.trams.customer.services;

import de.davelee.trams.customer.data.CustomerFeedback;
import de.davelee.trams.customer.repository.CustomerFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * This class controls access to the customer feedback database and uses the repository object to access
 * data from the database.
 * @author Dave Lee
 */
@Service
public class CustomerFeedbackService {

    @Autowired
    private CustomerFeedbackRepository customerFeedbackRepository;

    @Transactional
    /**
     * Add a customer feedback to the database.
     * @param customerFeedback a <code>CustomerFeedback</code> object to be stored in the database.
     * @return a <code>CustomerFeedback</code> object which matches the supplied customerFeedback as parameter
     * if the data was successfully stored in the database.
     */
    public CustomerFeedback addCustomerFeedback ( final CustomerFeedback customerFeedback ) {
        return customerFeedbackRepository.save(customerFeedback);
    }

    /**
     * Get the number of customer feedbacks in the database.
     * @return a <code>long</code> containing the number of customer feedbacks in the database.
     */
    public long getNumCustomerFeedback ( ) {
        return customerFeedbackRepository.count();
    }

    /**
     * Get all of the customer feedbacks in the database.
     * @return a <code>CustomerFeedback</code> List containing all feedbacks in the database.
     */
    public List<CustomerFeedback> getAllCustomerFeedbacks ( ) {
        return customerFeedbackRepository.findAll();
    }

    /**
     * Get all of the customer feedbacks matching the filtered email address in the database.
     * @param emailAddress a <code>String</code> containing the email address to filter by.
     * @return a <code>CustomerFeedback</code> List containing all feedbacks matching the email address in the database.
     */
    public List<CustomerFeedback> getFilteredCustomerFeedbacks ( final String emailAddress ) {
        return customerFeedbackRepository.findFeedbackByEmailAddress(emailAddress);
    }

}
