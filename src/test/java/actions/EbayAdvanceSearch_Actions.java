package actions;

import Hooks.Common_Steps;
import Utility.Common_Actions;
import elements.EbayAdvanceSearch_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EbayAdvanceSearch_Actions
{
    private WebDriver driver;
    EbayAdvanceSearch_Elements ebayAdvanceSearch_elements;
    public EbayAdvanceSearch_Actions(Common_Steps common_steps)
    {
        this.driver=common_steps.getDriver();
        ebayAdvanceSearch_elements = new EbayAdvanceSearch_Elements(driver);
    }

    public void clickOnEbayLogo()
    {

    }

}
