package de.davelee.trams.customer.admin.pages;

import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the welcome page and ensure that it can be displayed successfully.
 * Use test wicket class to prevent Spring Security problems.
 * @author Dave Lee
 */
public class CustomerWelcomePageTest {

    private WicketTester tester;

    @Before
    /**
     * Setup the test by creating a new Wicket test application.
     */
    public void setup ( ) {
        tester = new WicketTester(new TramsCustomerAdminWicketTestApplication());
    }

    @Test
    /**
     * Test case: Check that the homepage can be rendered successfully.
     * Expected result: all assertions are fulfilled.
     */
    public void homepageRendersSuccessfully(){
        //start and render the test page
        tester.startPage(CustomerWelcomePage.class);
        //assert rendered page class
        tester.assertRenderedPage(CustomerWelcomePage.class);
    }

}
