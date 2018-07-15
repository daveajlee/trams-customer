package de.davelee.trams.customer.repository;

import de.davelee.trams.customer.data.CustomerFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class represents the database operations automatically generated using Spring Data JPA.
 * @author Dave Lee
 */
@Repository
public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedback, Long> {

    /**
     * Return filtered customer feedback based on their email address.
     * @param emailAddress a <code>String</code> containing the email address to search feedback for.
     * @return a <code>CustomerFeedback</code> list representing the feedback which may be null if no feedback found.
     */
    public List<CustomerFeedback> findFeedbackByEmailAddress(@Param("emailAddress") String emailAddress);

}
