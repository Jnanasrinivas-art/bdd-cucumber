package steps;

import Hooks.Common_Steps;
import Utility.Common_Actions;
import actions.EbayHome_Actions;
import elements.EbayHome_Elements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.fail;

public class EbayHome_Steps
{
    public WebDriver driver;

    Common_Actions common_actions;
    EbayHome_Actions ebayHome_actions;

    public EbayHome_Steps(Common_Actions common_actions,EbayHome_Actions ebayHome_actions)

    {
        this.common_actions=common_actions;
        this.ebayHome_actions=ebayHome_actions;
    }

    @Given("Iam on Ebay Home Page")
    public void iam_on_ebay_home_page()
    {
        //driver.get("https://www.ebay.com/");
        common_actions.goToUrl("https://www.ebay.com/");
    }
    @When("I click on Advance Link")
    public void i_click_on_advance_link()
    {
        //driver.manage().window().maximize();
        //driver.findElement(By.xpath("//a[text()='Advanced']")).click();
        common_actions.maximizeWindow();
        ebayHome_actions.clickAdvanced();

    }
    @Then("I navigate to Advance search page")
    public void i_navigate_to_advance_search_page()
    {
         common_actions.validatePageTitleforAdvanced();
    }

    @When("I search for {string}")
    public void i_search_for_i_phone11(String value) throws InterruptedException {
        ebayHome_actions.doSearch(value);
        //driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(str1);
        //driver.findElement(By.xpath("//button[@id='gh-search-btn']")).click();

    }

    @When("I search for {string} in {string} category")
    public void i_search_for_in_category(String str1, String str2) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys(str1);
        Thread.sleep(3000);
        List<WebElement> cat =driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
        for(WebElement x:cat)
        {
            System.out.println(x.getText());
            if(x.getText().trim().equalsIgnoreCase(str2))
            {
                x.click();
                break;
            }
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='gh-search-btn']")).click();
        Thread.sleep(3000);
    }

    @Then("I validate atleast {int} search items present")
    public void i_validate_atleast_search_items_present(int count) throws InterruptedException {
        Thread.sleep(4000);
        String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText();
        String itemCount2=itemCount.replace(",","");
        int itemCountInt = Integer.parseInt(itemCount2);
        if(itemCountInt<count)
        {
            fail("Less than 1000 results ");
        }
    }

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException
    {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(4000);
    }

    @Then("I validate that page navigates to {string} and title contains {string}")
    public void i_validate_that_page_navigates_to_and_title_contains(String url, String title)
    {
        String actUrl=driver.getCurrentUrl();
        String actTitle=driver.getTitle();
        if(!actUrl.equals(url))
        {
            fail("page does not navigate to expected url" +url);
        }
        if(!actTitle.equals(title))
        {
            fail("Title mismatch");
        }
    }

}
