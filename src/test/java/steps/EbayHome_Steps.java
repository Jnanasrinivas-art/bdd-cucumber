package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EbayHome_Steps
{
    public WebDriver driver;

    @Given("Iam on Ebay Home Page")
    public void iam_on_ebay_home_page()
    {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
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

    @When("I search for iPhone11")
    public void i_search_for_i_phone_i_phone11()
    {
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("iPhone 11");
        driver.findElement(By.xpath("//button[@id='gh-search-btn']")).click();

    }
    @Then("I validate atleast 1000 search items present")
    public void i_validate_atleast_search_items_present() throws InterruptedException {
        Thread.sleep(4000);
        String itemCount = driver.findElement(By.cssSelector("h1.srp-controls__count-heading>span.BOLD:first-child")).getText();
        String itemCount2=itemCount.replace(",","");
        int itemCountInt = Integer.parseInt(itemCount2);
        if(itemCountInt<1000)
        {
            fail("Less than 1000 results ");
        }
        driver.quit();
    }

}
