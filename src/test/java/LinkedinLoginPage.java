import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;



    public class LinkedinLoginPage extends BasePage {

        @FindBy(xpath = "//input[@id='login-email']")
        private WebElement userEmailField;

        @FindBy(xpath = "//input[@id='login-password']")
        private WebElement userPasswordField;

        @FindBy(xpath = "//input[@id='login-submit']")
        private WebElement signInButton;

        @FindBy(xpath = "//a[@class='link-forgot-password']")
        private WebElement buttomResetPassword;

        public LinkedinLoginPage(WebDriver browser) {
            this.browser = browser;
            PageFactory.initElements(browser,this);
        }

        public LinkedinLoginSubmitPage loginReturnLoginSubmitPage(String userEmail, String userPass) {
            userEmailField.sendKeys(userEmail);
            userPasswordField.sendKeys(userPass);
            signInButton.click();
            try {
                sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new LinkedinLoginSubmitPage(browser);
        }


        public boolean isLoaded() {
            return false;
        }

        public LinkedinHomePage loginReturnHomePage(String s, String art0931531661) {
            return null;
        }

        public void loginReturnLoginPage(String userEmail, String userPass) {
        }

        public LinkedinResertPasswardPage clickOnForgortPassword() {
            buttomResetPassword.click();
            return new LinkedinResertPasswardPage(browser);

        }
    }

