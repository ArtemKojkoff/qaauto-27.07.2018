import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest {
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;
    LinkedinChangePasswordPage linkedinChangePasswordPage;

    @BeforeClass
    public void beforeMethod() {
        browser = new FirefoxDriver();
        browser.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(browser);

    }

    @AfterClass
    public void afterMethod() {
        browser.close();
    }


    @Test
    public void ResertPassward() throws InterruptedException {



        LinkedinResertPasswardPage linkedinResertPasswardPage = linkedinLoginPage.clickOnForgortPassword();




        LinkedinVerificationOfReceipt linkedinVerificationOfReceipt = linkedinResertPasswardPage.email("ivanbogun222@gmail.com");
        sleep(200000);


        LinkedinChangePasswordPage linkedinChangePasswordPage = linkedinVerificationOfReceipt.navigatedToLinckFromEmail();

        Assert.assertTrue(linkedinVerificationOfReceipt.isLoaded(),"VerificationOfReceipt is not loaded");



        LinkedinSuccessfulChangePage linkedinSuccessfulChangePage = new LinkedinSuccessfulChangePage(browser);
        linkedinChangePasswordPage.changePassword("artem0931531661","artem0931531661");










    }
}