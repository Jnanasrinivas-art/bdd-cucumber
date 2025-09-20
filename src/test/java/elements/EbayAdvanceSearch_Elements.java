package elements;

import Hooks.Common_Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v137.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayAdvanceSearch_Elements
{
    WebDriver driver;
    public EbayAdvanceSearch_Elements(WebDriver driver)
    {
       this.driver=driver;
       PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='gh-header__logo-cats-wrap']/a")
    public WebElement ebayLogo;

    @FindBy(xpath = "//input[@id='_nkw']")
    public WebElement searchString;

    @FindBy(xpath = "//input[@id='_ex_kw']")
    public WebElement excludeString;

    @FindBy(xpath = "//input[@name='_udlo']")
    public WebElement minPrice;

    @FindBy(xpath = "//input[@name='_udhi']")
    public WebElement maxPrice;

    @FindBy(xpath = "//fieldset[@class='adv-fieldset__keyword']//button[text()='Search']')")
    public WebElement srchBtn;

}
