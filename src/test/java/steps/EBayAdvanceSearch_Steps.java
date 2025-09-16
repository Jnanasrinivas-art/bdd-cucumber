package steps;

import Hooks.Common_Steps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class EBayAdvanceSearch_Steps
{
    WebDriver driver;

    public EBayAdvanceSearch_Steps(Common_Steps common_steps)
    {
        this.driver=common_steps.getDriver();
    }

    @Given("Iam on EBay Advanced Search Page")
    public void iam_on_e_bay_advanced_search_page()
    {
        driver.get("https://www.ebay.com/sch/ebayadvsearch");
    }
    @When("I click on EBay Logo")
    public void i_click_on_e_bay_logo() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='gh-header__logo-cats-wrap']/a")).click();
        Thread.sleep(4000);
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

    @When("I click on {string}")
    public void i_click_on(String string) throws InterruptedException
    {
        driver.findElement(By.linkText(string)).click();
        Thread.sleep(2000);
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
