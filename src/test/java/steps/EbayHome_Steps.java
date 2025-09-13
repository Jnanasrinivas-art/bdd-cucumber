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

}
