import org.openqa.selenium.WebDriver;
import util.GMailService;

public class LinkedinVerificationOfReceipt extends BasePage {






    public LinkedinVerificationOfReceipt(WebDriver browser) {
        super();
    }

    public boolean isLoaded() {
        return false;
    }

    public LinkedinHomePage loginReturnHomePage(String s, String art0931531661) {
        return null;
    }

    public LinkedinChangePasswordPage navigatedToLinckFromEmail() {
        String messageSubject = "данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "ivanbogun222@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";



        //ToDo
        //Fixme
        return  new LinkedinChangePasswordPage(browser);
    }
}
