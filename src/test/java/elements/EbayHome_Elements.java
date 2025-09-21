package elements;

import Hooks.Common_Steps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayHome_Elements
{
    private WebDriver driver;

    public EbayHome_Elements(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()='Advanced']")
    public WebElement Advanced;

    @FindBy(xpath = "//input[@title='Search']")
    public WebElement search;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    public WebElement srchBtn;

    @FindBy(css ="h1.srp-controls__count-heading>span.BOLD:first-child")
    public WebElement itemCount;


}
