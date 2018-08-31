package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.LinkedinLoginPage;
import page.LinkedinPasswordResetSubmitPage;
import page.LinkedinRequestPasswordResetPage;
import page.LinkedinSetNewPasswordPage;

import static java.lang.Thread.sleep;

public class LinkedinResetPasswordTest {
    WebDriver browser;
    LinkedinLoginPage linkedinLoginPage;
    LinkedinSetNewPasswordPage linkedinSetNewPasswordPage;

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
    public void successfulResetPasswordTest() throws InterruptedException {

        Assert.assertTrue(linkedinLoginPage.isLoaded(),
                "LoginPage is not loaded.");

        LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgortPassword();

        Assert.assertTrue(linkedinRequestPasswordResetPage.isLoaded(),
                "RequestPasswordResetPage is not loaded.");



        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinRequestPasswordResetPage.findAccount("ivanbogun222@gmail.com");
        sleep(120000);

        //Assert.assertTrue(linkedinPasswordResetSubmitPage.isLoaded(),
         //       "PasswordResetSubmitPage is not loaded.");



        LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinPasswordResetSubmitPage.navigatedToLinckFromEmail();



        Assert.assertTrue(linkedinSetNewPasswordPage.isLoaded(),
               "SetNewPasswordPage is not loaded.");


      //  page.LinkedinSuccessfulChangePage linkedinSuccessfulChangePage = new page.LinkedinSuccessfulChangePage(browser);
       // linkedinSetNewPasswordPage.changePassword("artem0931531661","artem0931531661");










    }
}