package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetSubmitPage extends BasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public LinkedinPasswordResetSubmitPage(WebDriver browser) {
        this.browser = browser;
        PageFactory.initElements(browser, this);
    }


    public boolean isLoaded() {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    return resendLinkButton.isDisplayed()
           && getCurrentPageTitle().contains("Проверьте, получили ли вы сообщение эл. почты со ссылкой для изменения пароля")
                 && getCurrentPageUrl().contains("request-password-reset-submit");
}


public LinkedinSetNewPasswordPage navigatedToLinckFromEmail() {
    String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
    String messageTo = "ivanbogun222@gmail.com";
    String messageFrom = "security-noreply@linkedin.com";

    String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 60);
    System.out.println("Content: " + message);

    String resertPasswordLink = StringUtils.substringBetween(message,"нажмите <a href=\\\"<a href=&quot;","\" style=\"cursor:pointer;color:#008CC9").replace("amp","");
    System.out.println(resertPasswordLink);
    browser.get(resertPasswordLink);

    return  new LinkedinSetNewPasswordPage(browser);
    }
}
