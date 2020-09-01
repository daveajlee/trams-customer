package de.davelee.trams.customer.admin.panels;

import de.davelee.trams.customer.admin.forms.FilterForm;
import de.davelee.trams.customer.services.WicketServiceCaller;
import de.davelee.trams.customer.api.CustomerFeedbackModel;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import java.util.List;

/**
 * The panel for viewing and filtering customer feedback.
 * @author davelee
 */
public class ViewFilterPanel extends Panel {

    private ListView<CustomerFeedbackModel> customerFeedbackModelListView;

    /**
     * Create a new panel and add the components.
     * @param id a <code>String</code> with the matching id element in HTML.
     */
    public ViewFilterPanel(final String id) {
        super(id);

        List<CustomerFeedbackModel> customerFeedbackModelList = WicketServiceCaller.getAllCustomerFeedbackModels();

        customerFeedbackModelListView = new ListView<CustomerFeedbackModel>("customerFeedbackModelList", new PropertyModel<>(this, "customerFeedbackModelList")) {

            @Override
            protected void populateItem(ListItem<CustomerFeedbackModel> item) {
                item.add(new Label("title", new PropertyModel(item.getModel(), "title")));
                item.add(new Label("firstName", new PropertyModel<>(item.getModel(), "firstName")));
                item.add(new Label("surname", new PropertyModel<>(item.getModel(), "surname")));
                item.add(new Label("emailAddress", new PropertyModel<>(item.getModel(), "emailAddress")));
                item.add(new Label("telephoneNumber", new PropertyModel<>(item.getModel(), "telephoneNumber")));
                item.add(new Label("address", new PropertyModel<>(item.getModel(), "address")));
                item.add(new Label("message", new PropertyModel<>(item.getModel(), "message")));
            }
        };
        add(new FilterForm("filterForm", this));
        add(customerFeedbackModelListView);
    }

    /**
     * Update the table by filtering the email field based on the supplied text.
     * If the text is empty then display all feedbacks again.
     * @param textToFilter a <code>String</code> containing the text to filter email field by.
     */
    public void updateTable ( final String textToFilter ) {
        if ( textToFilter == null || textToFilter.isEmpty() ) {
            customerFeedbackModelListView.setModelObject(WicketServiceCaller.getAllCustomerFeedbackModels());
        } else {
            customerFeedbackModelListView.setModelObject(WicketServiceCaller.getFilteredCustomerFeedbackModels(textToFilter));
        }
    }

}
