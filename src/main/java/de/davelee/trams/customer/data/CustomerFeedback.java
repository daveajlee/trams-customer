package de.davelee.trams.customer.data;

import javax.persistence.*;
import java.util.Map;

/**
 * This class represents a customer complaint or suggestion.
 * JIRA Ticket: TRAMS-52
 * @author Dave Lee
 */
@Entity
@Table(name="CUSTOMER_FEEDBACK")
/**
 * This class represents a feedback message from a customer which can be stored in the database.
 * @author Dave Lee
 */
public class CustomerFeedback implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private String firstName;

    @Column
    private String surname;

    @Column
    private String emailAddress;

    @Column
    private String telephoneNumber;

    @Column
    private String address;

    @Column
    private String message;

    @ElementCollection
    @JoinTable(name="EXTRA_INFOS_RANGE", joinColumns=@JoinColumn(name="ID"))
    @MapKeyColumn (name="RANGE_ID")
    @Column(name="EXTRA_INFOS")
    private Map<String,String> extraInfos;

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
