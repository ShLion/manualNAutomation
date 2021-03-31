package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomeAmazon {

    WebDriver driver;

    @FindBy(id="nav-logo-sprites")
    WebElement amazonLogo;

    @FindBy(id="twotabsearchtextbox")
    WebElement searchInput;

    @FindBy(id="nav-search-submit-button")
    WebElement clickSubmit;

    @FindBy(id="searchDropdownBox")
    WebElement dropDownId;

    @FindBy(partialLinkText="Book Depository")
    WebElement bookDepositoryText;

    @FindBy(xpath = "//span[text()='Try checking your spelling or use more general terms']")
    WebElement tryToCheck;

    public HomeAmazon(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Search Functionality -----
    public void verifyHomePage(){

        Assert.assertTrue(amazonLogo.isDisplayed());

    }

    public void searchText(String text){
        searchInput.sendKeys(text);
    }

    public void clickSubmit(){
        clickSubmit.click();
    }

    public void negativeSearchVerify(){
        Assert.assertTrue("Try checking your spelling or use more general terms", tryToCheck.isDisplayed());
    }

    public void setDropDownSports(){
        Select dropdown = new Select(dropDownId);
        dropdown.selectByVisibleText("Sports & Outdoors");
    }

    public void setDropDownBooks(){
        Select dropdown = new Select(dropDownId);
        dropdown.selectByIndex(5);
    }


    public void bookRepositoryClick(){
        bookDepositoryText.click();
    }




}
