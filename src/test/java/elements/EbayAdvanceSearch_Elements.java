package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayAdvanceSearch_Elements
{
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
