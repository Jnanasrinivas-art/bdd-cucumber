package Utility;

import Hooks.Common_Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common_Actions
{
     WebDriver driver;
    public Common_Actions(Common_Steps common_steps)
    {
        this.driver= common_steps.getDriver();
    }

    public void goToUrl(String url)
    {
        driver.get(url);
    }

    public void clickElement(WebElement pElement)
    {
        pElement.click();
    }

    public void maximizeWindow()
    {
        driver.manage().window().maximize();
    }
}
