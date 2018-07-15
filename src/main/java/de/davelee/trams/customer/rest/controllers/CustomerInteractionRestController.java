package de.davelee.trams.customer.rest.controllers;

import de.davelee.trams.customer.api.CustomerFeedbackModel;
import de.davelee.trams.customer.data.CustomerFeedback;
import de.davelee.trams.customer.services.CustomerFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

@RestController
@Api(value="customer", description="Customer Interaction Operations")
@RequestMapping(value="/customer")
/**
 * This class contains the REST endpoints for customer feedback which at the moment is a single method to post feedback.
 * @author Dave Lee
 */
public class CustomerInteractionRestController {

    @Autowired
    private CustomerFeedbackService customerFeedbackService;

    @ApiOperation(value = "Send customer feedback", notes="Method to submit customer feedback to transport operator.")
    @RequestMapping(method = RequestMethod.POST, produces="text/plain", value="/feedback")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code=201,message="Successfully submitted feedback to database"), @ApiResponse(code=500,message="Database not available")})
    /**
     * Save the supplied feedback into the system and return an appropriate http status code as follows:
     * 201 - data stored successfully, 400 - validation failed, 500 - data could not be saved because of database problems.
     * @param feedbackModel a <code>CustomerFeedbackModel</code> object containg the data to store.
     * @return a <code>ResponseEntity</code> object with the appropriate http status code.
     */
    public ResponseEntity<Void> feedback (@RequestBody final CustomerFeedbackModel feedbackModel ) {
        if (!validateInput(feedbackModel) ) {
            return ResponseEntity.badRequest().build();
        } else if ( customerFeedbackService.addCustomerFeedback(convertToCustomerFeedback(feedbackModel)) != null ) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Validate the supplied data based on the following validation rules:
     * title, first name, surname, email address and telephone number are required.
     * Email address must be in form: text"AT"server.domainExtension
     * @param customerFeedbackModel a <code>CustomerFeedbackModel</code> object to validate.
     * @return a <code>boolean</code> which is true iff the input is correct.
     */
    public boolean validateInput ( final CustomerFeedbackModel customerFeedbackModel ) {
        if ( isFieldEmpty(customerFeedbackModel.getTitle()) ) {
            return false;
        } else if ( isFieldEmpty(customerFeedbackModel.getFirstName()) ) {
            return false;
        } else if ( isFieldEmpty(customerFeedbackModel.getSurname()) ) {
            return false;
        } else if ( isFieldEmpty(customerFeedbackModel.getEmailAddress()) ) {
            return false;
        } else if ( isFieldEmpty(customerFeedbackModel.getTelephoneNumber()) ) {
            return false;
        } else if (!Pattern.matches(".*@.*[.]?.*$", customerFeedbackModel.getEmailAddress())) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Private helper method to check if a field value is either null or empty.
     * @param fieldValue a <code>String</code> with the field value to check.
     * @return a <code>boolean</code> which is true iff the fieldValue is not empty.
     */
    private boolean isFieldEmpty ( final String fieldValue ) {
        return fieldValue == null || fieldValue.isEmpty();
    }

    /**
     * Private helper method to convert a CustomerFeedbackModel object to a CustomerFeedback object which can
     * be stored in the database.
     * @param customerFeedbackModel a <code>CustomerFeedbackModel</code> object to convert.
     * @return a <code>CustomerFeedback</code> object which can be stored in the database.
     */
    private CustomerFeedback convertToCustomerFeedback ( final CustomerFeedbackModel customerFeedbackModel ) {
        CustomerFeedback customerFeedback = new CustomerFeedback();
        customerFeedback.setAddress(customerFeedbackModel.getAddress());
        customerFeedback.setExtraInfos(customerFeedbackModel.getExtraInfos());
        customerFeedback.setEmailAddress(customerFeedbackModel.getEmailAddress());
        customerFeedback.setFirstName(customerFeedbackModel.getFirstName());
        customerFeedback.setMessage(customerFeedbackModel.getMessage());
        customerFeedback.setSurname(customerFeedbackModel.getSurname());
        customerFeedback.setTelephoneNumber(customerFeedbackModel.getTelephoneNumber());
        customerFeedback.setTitle(customerFeedbackModel.getTitle());
        return customerFeedback;
    }

}
