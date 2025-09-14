package steps;

import Hooks.Common_Steps;
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

}
