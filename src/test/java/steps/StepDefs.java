package steps;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import java.util.List;

public class StepDefs extends BasePage implements En {

    public StepDefs() {
        Given("I go to url (.*)$", (final String url) -> openUrl(url));

        Then("I should be on the (.*) page$", (final String title) -> {
            waitForTitle(title, 5);
        });

        When("^I click on the link by id with: (.*)$", (final String id) -> {
            clickLinkById(id);
        });

        When("^I click on the link by text with: (.*)$", (final String linkText) -> {
            clickLinkByText(linkText);
        });

        When("^I click on the submit button$", () -> clickLinkByClass("govuk-button"));

        When("^I remove the booking$", () -> {
            String bookingId = getText("bookingId");
            clickLinkByText("Remove");
            waitForTitle("Book a Resource", 5);
            clickLinkById("remove");
            sendKeys("bookingRemovalId", bookingId);
        });

        When("^I fill in the form$", (DataTable data) -> {
            List<List<String>> formItems = data.asLists(String.class);
            for (int i = 1; i < formItems.size(); i++) {
                sendKeys(formItems.get(i).get(0), formItems.get(i).get(1));
            }
        });
    }
}
