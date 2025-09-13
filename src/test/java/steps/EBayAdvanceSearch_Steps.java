package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class EBayAdvanceSearch_Steps
{
    WebDriver driver;

    @Given("Iam on EBay Advanced Search Page")
    public void iam_on_e_bay_advanced_search_page()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
        driver.quit();

    }

}
