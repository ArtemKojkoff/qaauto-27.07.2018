import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinChangePasswordPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Новый пароль']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@class='form__submit form__submit--stretch']")
    private WebElement sendButton;

    public LinkedinChangePasswordPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }
    public void changePassword(String passwordNew, String confirm) {
        newPassword.sendKeys(passwordNew);
        confirmPassword.sendKeys(confirm);
        sendButton.click();


    }


    public LinkedinChangePasswordPage() {

    }



    public boolean isLoaded() {
        return false;
    }

    public LinkedinHomePage loginReturnHomePage(String s, String art0931531661) {
        return null;
    }
}
