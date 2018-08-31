package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


/**
 * Page Object class for LinkedinLoginPage.
 */
    public class LinkedinLoginPage extends BasePage {

        @FindBy(xpath = "//input[@id='login-email']")
        private WebElement userEmailField;

        @FindBy(xpath = "//input[@id='login-password']")
        private WebElement userPasswordField;

        @FindBy(xpath = "//input[@id='login-submit']")
        private WebElement signInButton;

        @FindBy(xpath = "//a[@class='link-forgot-password']")
        private WebElement buttomResetPassword;

        /**
         * Constructor of LinkedinLoginPage class.
         * @param browser - WebDriver instance from test.
         */
        public LinkedinLoginPage(WebDriver browser) {
            this.browser = browser;
            PageFactory.initElements(browser, this);
        }

        public LinkedinLoginSubmitPage loginReturnLoginSubmitPage(String userEmail, String userPass) {
            userEmailField.sendKeys(userEmail);
            userPasswordField.sendKeys(userPass);
            signInButton.click();
            return new LinkedinLoginSubmitPage(browser);
        }


        public boolean isLoaded() {
            return userEmailField.isDisplayed()
                    && getCurrentPageTitle().contains("LinkedIn: Войти или зарегистрироваться");
        }


        public void loginReturnLoginPage(String userEmail, String userPass) {
        }

        public LinkedinRequestPasswordResetPage clickOnForgortPassword() {
            buttomResetPassword.click();
            return new LinkedinRequestPasswordResetPage(browser);

        }

        public LinkedinHomePage loginReturnHomePage(String userEmail, String userPass) {
            return null;
        }

    }

