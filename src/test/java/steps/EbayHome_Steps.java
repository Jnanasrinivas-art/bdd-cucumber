package steps;

import Hooks.Common_Steps;
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

    public EbayHome_Steps(Common_Steps common_steps)
    {
        this.driver=common_steps.getDriver();
    }

    @Given("Iam on Ebay Home Page")
    public void iam_on_ebay_home_page()
    {
        driver.get("https://www.ebay.com/");
    }
    @When("I click on Advance Link")
    public void i_click_on_advance_link()
    {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Advanced']")).click();
    }
    @Then("I navigate to Advance search page")
    public void i_navigate_to_advance_search_page()
    {
        String expUrl="https://www.ebay.com/sch/ebayadvsearch";
        String actUrl=driver.getCurrentUrl();
        if(!expUrl.equals(actUrl))
        {
            fail("Page does not navigate to Home Page");
        }
        driver.quit();
    }

    @When("I search for {string}")
    public void i_search_for_i_phone11(String str1)
    {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(str1);
        driver.findElement(By.xpath("//button[@id='gh-search-btn']")).click();

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

}
