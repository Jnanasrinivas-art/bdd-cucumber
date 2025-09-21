package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
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

    @After(order = 0)
    public void tearDown() throws InterruptedException
    {
        driver.quit();
        Thread.sleep(1500);
        System.out.println("Global After Hook Executed");
    }

    public WebDriver getDriver()
    {
        return driver;
    }
}
