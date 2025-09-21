package actions;

import Hooks.Common_Steps;
import Utility.Common_Actions;
import elements.EbayHome_Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class EbayHome_Actions
{
    private WebDriver driver;
    EbayHome_Elements ebayHome_elements;

    public EbayHome_Actions(Common_Steps common_steps)
    {
        this.driver=common_steps.getDriver();
        ebayHome_elements=new EbayHome_Elements(driver);
    }

    public void clickAdvanced()
    {
        ebayHome_elements.Advanced.click();
    }

    public void enterInSearch(String value)
    {
        ebayHome_elements.search.sendKeys(value);
    }

    public void clickSearchBtn()
    {
        ebayHome_elements.srchBtn.click();
    }

    public void doSearch(String value) throws InterruptedException
    {
        this.enterInSearch(value);
        this.clickSearchBtn();
        Thread.sleep(2000);
    }

}
