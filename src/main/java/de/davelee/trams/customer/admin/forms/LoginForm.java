package de.davelee.trams.customer.admin.forms;

import de.davelee.trams.customer.admin.pages.CustomerWelcomePage;
import de.davelee.trams.customer.config.WicketPropertyConfiguration;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import java.util.List;

/**
 * This class implements the login form with three fields: operator (as drop-down), username and password.
 * The operators can be set through the property operators.list in application.properties.
 * @author Dave Lee
 */
public class LoginForm extends Form {

    private List<String> operators = WicketPropertyConfiguration.getOperators();
    private String selectedOperator = operators.get(0);

    private DropDownChoice<String> operatorSelect;
    private TextField<String> usernameField;
    private TextField<String> passwordField;

    /**
     * Create a new login form with the supplied wicket id as name and add all components.
     * @param name a <code>String</code> containing the wicket id to use to embed this form in the HTML page.
     */
    public LoginForm(final String name) {
        super(name);

        add(new FeedbackPanel("feedback"));

        add(new Label("operatorLabel", "Operator:"));

        operatorSelect = new DropDownChoice<String>("operatorSelect", new PropertyModel(this, "selectedOperator"), operators);
        add(operatorSelect);

        add(new Label("usernameLabel", "Username:"));

        usernameField = new TextField<String>("usernameField", new Model<String>(""));
        add(usernameField.setRequired(true));

        add(new Label("passwordLabel", "Password:"));

        passwordField = new PasswordTextField("passwordField", new Model<String>(""));
        add(passwordField.setRequired(true));

        add(new Button("loginButton"));
    }

    @Override
    /**
     * When the user clicks on the submit button, the username and password will be checked and if successful
     * redirect to the customer welcome page. Otherwise, display an error message to the user.
     */
    public void onSubmit() {
        AuthenticatedWebSession session = AuthenticatedWebSession.get();
        if (session.signIn(usernameField.getModelObject(), passwordField.getModelObject())) {
            setResponsePage(CustomerWelcomePage.class);
            getSession().setAttribute("displayName", "Max Mustermann");
            getSession().setAttribute("operator", operatorSelect.getModel().getObject());
        } else {
            error("Login failed");
        }
    }

}
