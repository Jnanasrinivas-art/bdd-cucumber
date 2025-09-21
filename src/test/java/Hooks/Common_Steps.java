package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Steps
{
    private WebDriver driver;

    @Before(order = 0)
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Global Before Hook executed");
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws InterruptedException
    {
        if(scenario.isFailed())
        {
            //Takes Screenshot
            final byte[] scr =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(scr,"img/png",scenario.getName());
        }
        driver.quit();
        Thread.sleep(1500);
        System.out.println("Global After Hook Executed");
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
