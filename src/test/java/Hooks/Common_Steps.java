package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common_Steps
{
    private WebDriver driver;

    @Before
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Global Hook executed");
    }

    @After
    public void tearDown() throws InterruptedException
    {
        driver.quit();
        Thread.sleep(1500);
    }

    @Before("@setCookies")
    public void setCookies()
    {
        System.out.println("Scenario specific hook - setCookies executed");
    }

    @After("Test")
    public void testAfterHook()
    {
        System.out.println("Scenario specific hook - testAfterHook executed");
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
