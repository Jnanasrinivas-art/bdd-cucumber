package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHome_Steps
{
    @Given("Iam on Ebay Home Page")
    public void iam_on_ebay_home_page()
    {
        System.out.println("Iam on Ebay Home Page");
    }
    @When("I click on Advance Link")
    public void i_click_on_advance_link()
    {
        System.out.println("I click on Advance Link");
    }
    @Then("I navigate to Advance search page")
    public void i_navigate_to_advance_search_page()
    {
        System.out.println("I navigate to Advance search page");
    }
}
