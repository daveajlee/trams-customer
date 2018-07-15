package de.davelee.trams.customer.admin.pages;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import de.davelee.trams.customer.admin.panels.ViewFilterPanel;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.extensions.ajax.markup.html.tabs.AjaxTabbedPanel;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;


@WicketHomePage
@AuthorizeInstantiation("USER")
/**
 * Create the start page for the customer management wicket application which acts as the page to allow access
 * to all functions using a tab interface.
 * @author Dave Lee
 */
public class CustomerWelcomePage extends WebPage {

    /**
     * Create a new welcome page with the standard header and the tab interface to access other panels.
     */
    public CustomerWelcomePage() {

        add(new Label("title", "Customer Administration"));

        add(new Label("userOperator", getSession().getAttribute("displayName") + ", " + getSession().getAttribute("operator")));

        add(new AjaxTabbedPanel("mytabpanel", newTabList()));
    }

    /**
     * Create the tab list of functions.
     * @return a <code>List</code> of <code>ITab</code> objects representing the tabs in the interface.
     */
    private List<ITab> newTabList () {
        List<ITab> tabs = new ArrayList<ITab>();
        //View & Filter
        tabs.add(new AbstractTab(Model.of("View & Filter")) {
            @Override
            public WebMarkupContainer getPanel(String panelId) {
                return new ViewFilterPanel(panelId);
            }
        });

        return tabs;
    }

}