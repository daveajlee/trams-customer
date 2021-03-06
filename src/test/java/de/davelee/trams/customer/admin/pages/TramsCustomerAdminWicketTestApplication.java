package de.davelee.trams.customer.admin.pages;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

/**
 * This test wicket application is used to prevent it being necessary to login with Spring Security for tests.
 * @author Dave Lee
 */
public class TramsCustomerAdminWicketTestApplication extends WebApplication {

    @Override
    /**
     * Get the home page for this Wicket application.
     * @return the <code>Page</code> object representing the start page.
     */
    public Class<? extends Page> getHomePage() {
        return CustomerWelcomePage.class;
    }

}
