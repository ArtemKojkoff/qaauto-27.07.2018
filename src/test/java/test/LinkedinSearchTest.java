package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginPage;
import page.LinkedinSearchPage;

public class LinkedinSearchTest {
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);
    }

    @AfterMethod
    public void afterMethod() {
        browser.close();
    }


    @Test
    public void basicSearchTest(){
        LinkedinHomePage linkedinHomePage =
                linkedinLoginPage.loginReturnHomePage("ivanbogun222@gmail.com", "art0931531661");
        Assert.assertTrue(linkedinHomePage.isLoaded(),
                "Home page is not loaded.");

        LinkedinSearchPage linkedinSearchPage = linkedinHomePage.search("HR");


        Assert.assertTrue(linkedinSearchPage.isLoaded(), "Search page is not loaded");

        Assert.assertEquals(linkedinSearchPage.getCurrentPageTitle(),"Title is incorrect");




    }
}
