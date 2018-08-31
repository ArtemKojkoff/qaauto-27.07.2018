package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinRequestPasswordResetPage extends BasePage {

    @FindBy(xpath = "//input[@autocomplete='email tel']")
    private WebElement userEmailField;
    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public LinkedinRequestPasswordResetPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }

    public boolean isLoaded() {
        return findAccountButton.isDisplayed()
                && getCurrentPageTitle().equals("Изменить пароль | LinkedIn")
                && getCurrentPageUrl().contains("uas/request-password-reset");
    }


    public LinkedinPasswordResetSubmitPage findAccount(String email) {

        gMailService.connect();

        userEmailField.sendKeys(email);
        findAccountButton.click();


        return new LinkedinPasswordResetSubmitPage(browser);
    }
}




