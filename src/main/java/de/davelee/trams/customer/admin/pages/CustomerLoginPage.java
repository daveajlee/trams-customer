package de.davelee.trams.customer.admin.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketSignInPage;
import de.davelee.trams.customer.admin.forms.LoginForm;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

@WicketSignInPage
/**
 * Create the login page for the customer management wicket application which acts as the page to allow signing
 * in through Spring Security & Wicket.
 * @author Dave Lee
 */
public class CustomerLoginPage extends WebPage {

    /**
     * Create a new login page with the login form. If the user is already signed in then we simply redirect
     * them to their destination.
     * @param pageParameters a <code>PageParameters</code> object of which none of the properties are read on the page.
     */
    public CustomerLoginPage(final PageParameters pageParameters) {
        super(pageParameters);

        if (((AbstractAuthenticatedWebSession) getSession()).isSignedIn()) {
            continueToOriginalDestination();
        }

        add(new Label("title", "Customer Administration"));

        add(new LoginForm("loginForm"));
    }



}