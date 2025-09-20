package steps;

import Hooks.Common_Steps;
import Utility.Common_Actions;
import actions.EbayAdvanceSearch_Actions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EBayAdvanceSearch_Steps
{
    private WebDriver driver;
    Common_Actions common_actions;
    EbayAdvanceSearch_Actions ebayAdvanceSearch_actions;

    public EBayAdvanceSearch_Steps(Common_Actions common_actions,EbayAdvanceSearch_Actions ebayAdvanceSearch_actions)
    {
         this.common_actions=common_actions;
         this.ebayAdvanceSearch_actions=ebayAdvanceSearch_actions;
    }

    @Given("Iam on EBay Advanced Search Page")
    public void iam_on_e_bay_advanced_search_page()
    {
        //driver.get("https://www.ebay.com/sch/ebayadvsearch");
        common_actions.goToUrl("https://www.ebay.com/sch/ebayadvsearch");

    }
    @When("I click on EBay Logo")
    public void i_click_on_e_bay_logo() throws InterruptedException
    {
        common_actions.maximizeWindow();
        ebayAdvanceSearch_actions.clickOnEbayLogo();
        Thread.sleep(2000);
    }
    @Then("Iam navigated to EBay Home Page")
    public void iam_navigated_to_e_bay_home_page()
    {
        String expUrl ="https://www.ebay.com/";
        String actUrl= driver.getCurrentUrl();
        if(!expUrl.equals(actUrl))
        {
            fail("Page does not navigate to Home Page");
        }
    }

    @When("I advanced search an item")
    public void i_advanced_search_an_item(DataTable dataTable) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='_nkw']")).sendKeys(dataTable.cell(1,0));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='_ex_kw']")).sendKeys((dataTable.cell(1,1)));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='_udlo']")).sendKeys(dataTable.cell(1,2));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='_udhi']")).sendKeys(dataTable.cell(1,3));
        Thread.sleep(1000);
        driver.findElement(By.xpath("//fieldset[@class='adv-fieldset__keyword']//button[text()='Search']")).click();
        Thread.sleep(2700);
    }

}
