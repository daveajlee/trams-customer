package de.davelee.trams.customer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
/**
 * This class makes it possible to read properties from the application.properties file and make them accessible
 * to Wicket forms and pages.
 * @author Dave Lee
 */
public class WicketPropertyConfiguration {

    //List of operators to display on login page
    private static List<String> operators;

    @Autowired
    /**
     * Construct a new WicketPropertyConfiguration setting the operator as parameter.
     * @param operators a <code>List</code> of operators to display during the login page.
     */
    public WicketPropertyConfiguration(@Value("#{'${operators.list}'.split(',')}") final List<String> operators) {
        this.operators = operators;
    }

    /**
     * Return the list of operators to display on the login page.
     * @return a <code>List</code> of operators to display on the login page.
     */
    public static List<String> getOperators ( ) {
        return operators;
    }

}
