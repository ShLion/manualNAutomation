package test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomeAmazon;

import java.util.concurrent.TimeUnit;

public class TestAmazon {
    WebDriver driver;
    HomeAmazon homeAmazon;



    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\1\\Desktop\\ChromeDriver89\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseUrl = "https://www.amazon.com/";
        driver.get(baseUrl);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    // Search functionality testing --------

    @Test
    public void isPageLoaded(){
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.verifyHomePage();

    }

    @Test
    public void chooseSportsCategory() {
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.setDropDownSports();
    }


    @Test
    public void chooseBooksCategory() throws InterruptedException {
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.setDropDownBooks();
        Thread.sleep(5000);
    }


    @Test
    public void enterTextSearchAndSubmit(){
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.searchText("Gloves");
        homeAmazon.clickSubmit();
    }

    @Test
    public void chooseBooksAndEnterInvalidSearchText(){
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.setDropDownBooks();
        homeAmazon.searchText("11111111asdf");
        homeAmazon.clickSubmit();

        homeAmazon.negativeSearchVerify();

    }


    @Test
    public void scrollDownAndClickBookRepository() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(100, 2000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(5000);
        homeAmazon = new HomeAmazon(driver);
        homeAmazon.bookRepositoryClick();

    }

    @After
    public void closing(){
        driver.close();
    }

}
