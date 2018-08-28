import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class LinkedinResertPasswardPage extends BasePage {

    @FindBy(xpath = "//input[@autocomplete='email tel']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement resetPasswordSubmitButton;

    public LinkedinResertPasswardPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser,this);
    }




    public LinkedinVerificationOfReceipt email(String email) {
        gMailService = new GMailService(email,"art0931531661");
        gMailService.connect();

        emailField.sendKeys(email);
        resetPasswordSubmitButton.click();

        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "ivanbogun222@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
        System.out.println("Content: " + message);
        return new LinkedinVerificationOfReceipt(browser);
    }



    public boolean isLoaded() {
        return false;
    }

    public LinkedinHomePage loginReturnHomePage(String s, String art0931531661) {
        return null;
    }
}