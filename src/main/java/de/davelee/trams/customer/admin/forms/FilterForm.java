package de.davelee.trams.customer.admin.forms;

import de.davelee.trams.customer.admin.panels.ViewFilterPanel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

/**
 * This class implements the filter form with one field: filter text.
 * @author Dave Lee
 */
public class FilterForm extends Form {

    private TextField<String> filterField;
    private ViewFilterPanel viewFilterPanel;

    /**
     * Create a new filter form with the supplied wicket id as name and add all components.
     * @param name a <code>String</code> containing the wicket id to use to embed this form in the HTML page.
     * @param viewFilterPanel a <code>ViewFilterPanel</code> to display the results of the filtering.
     */
    public FilterForm(final String name, final ViewFilterPanel viewFilterPanel) {
        super(name);

        this.viewFilterPanel = viewFilterPanel;

        add(new Label("filterLabel", "Filter by Email (Empty = display all):"));

        filterField = new TextField<String>("filterField", new Model<String>(""));
        add(filterField);

        add(new Button("filterButton"));

    }

    @Override
    /**
     * When the user clicks on the submit button, the table will be filtered by email.
     */
    public void onSubmit() {
        viewFilterPanel.updateTable(filterField.getModelObject());
    }

}
