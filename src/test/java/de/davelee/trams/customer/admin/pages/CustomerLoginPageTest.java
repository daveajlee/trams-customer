package de.davelee.trams.customer.admin.pages;

import com.giffing.wicket.spring.boot.starter.configuration.extensions.external.spring.security.SecureWebSession;
import de.davelee.trams.customer.TramsCustomerApplication;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TramsCustomerApplication.class)
@EnableWebSecurity
/**
 * Test the login page and ensure that a login is possible.
 * @author Dave Lee
 */
public class CustomerLoginPageTest {


    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    private WicketTester tester;

    @Autowired
    private WebApplication wicketApplication;

    @Autowired
    private ApplicationContext applicationContextMock;


    @Before
    /**
     * Set up the test by creating a new Wicket test application.
     */
    public void setUp() {
        ReflectionTestUtils.setField(wicketApplication, "applicationContext", applicationContextMock);
        tester = new WicketTester(wicketApplication);
    }

    @Test
    /**
     * Test case: it is possible to login.
     * Expected result: all asserts are fulfilled.
     */
    public void testLogin() {
        assertTrue(login(USERNAME, PASSWORD));
    }

    /**
     * Private helper method to perform the login test with the supplied username and password.
     * @param username a <code>String</code> containing the username to use in the test.
     * @param password a <code>String</code> containing the password to use in the test.
     */
    private boolean login(final String username, final String password) {
        SecureWebSession session = (SecureWebSession) tester.getSession();
        session.signOut();
        tester.startPage(CustomerLoginPage.class);
        FormTester formTester = tester.newFormTester("loginForm");
        formTester.setValue("usernameField", username);
        formTester.setValue("passwordField", password);
        formTester.submit();
        tester.assertNoErrorMessage();
        tester.assertNoInfoMessage();
        tester.assertRenderedPage(CustomerWelcomePage.class);
        return true;
    }

}
