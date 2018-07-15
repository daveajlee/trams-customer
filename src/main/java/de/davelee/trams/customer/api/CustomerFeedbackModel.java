package de.davelee.trams.customer.api;

import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * This class represents a feedback message from a customer which can be returned to the client.
 * @author Dave Lee
 */
public class CustomerFeedbackModel implements java.io.Serializable {

    private String title;
    private String firstName;
    private String surname;
    private String emailAddress;
    private String telephoneNumber;
    private String address;
    private String message;
    private Map<String,String> extraInfos;

    @ApiModelProperty(position=1, required=true, value="title of the customer")
    /**
     * Return the title of the customer as a String.
     * @return a <code>String</code> containing the title of the customer.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of the customer as a String.
     * @param title a <code>String</code> containing the new title of the customer.
     */
    public void setTitle(final String title) {
        this.title = title;
    }

    @ApiModelProperty(position=2, required=true, value="first name of the customer")
    /**
     * Get the first name of the customer as a String.
     * @return a <code>String</code> containing the first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the customer as a String.
     * @param firstName a <code>String</code> containing the new first name of the customer.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    @ApiModelProperty(position=3, required=true, value="surname of the customer")
    /**
     * Return the surname of the customer as a String.
     * @return a <code>String</code> containing the surname of the customer.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Set the surname of the customer as a String.
     * @param surname a <code>String</code> containing the new surname of the customer.
     */
    public void setSurname(final String surname) {
        this.surname = surname;
    }

    @ApiModelProperty(position=4, required=true, value="email address of the customer")
    /**
     * Return the email address of the customer as a String.
     * @return a <code>String</code> containing the email address of the customer.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address of the customer as a String.
     * @param emailAddress a <code>String</code> containing the new email address of the customer.
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @ApiModelProperty(position=5, required=true, value="telephone number of the customer")
    /**
     * Return the telephone number of the customer as a String.
     * @return a <code>String</code> containing the telephone number of the customer.
     */
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    /**
     * Set the telephone number of the customer as a String.
     * @param telephoneNumber a <code>String</code> containing the new telephone number of the customer.
     */
    public void setTelephoneNumber(final String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @ApiModelProperty(position=6, required=false, value="postal address of the customer")
    /**
     * Return the address of the customer as a String.
     * @return a <code>String</code> containing the address of the customer.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the customer as a String.
     * @param address a <code>String</code> containing the new address of the customer.
     */
    public void setAddress(final String address) {
        this.address = address;
    }

    @ApiModelProperty(position=7, required=false, value="general feedback for the customer")
    /**
     * Return the message of the customer as a String.
     * @return a <code>String</code> containing the message of the customer.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the message of the customer.
     * @param message a <code>String</code> containing the new message of the customer.
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    @ApiModelProperty(position=8, required=false, value="mapping of extra infos")
    /**
     * Return a map of extra infos as key/value pair where additional information can be stored.
     * @return a <code>Map</code> of extra infos as key/value pair as Strings.
     */
    public Map<String, String> getExtraInfos() {
        return extraInfos;
    }

    /**
     * Set a map of extra infos as key/value pair where additional information can be stored.
     * @param extraInfos a <code>Map</code> of extra infos as key/value pair as Strings.
     */
    public void setExtraInfos(final Map<String, String> extraInfos) {
        this.extraInfos = extraInfos;
    }
}
