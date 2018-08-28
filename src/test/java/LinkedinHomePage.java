import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


public class LinkedinHomePage extends BasePage {

        @FindBy(xpath = "//*[@id='profile-nav-item']" )
        private WebElement profileNavigationItem;

        @FindBy(xpath = "//input[@placeholder and @role]" )
        private WebElement searchField;

        public LinkedinHomePage(WebDriver browser) {
            this.browser = browser;
            PageFactory.initElements(browser, this);
        }


    public boolean isLoaded() {
            return profileNavigationItem.isDisplayed()
                    && getCurrentPageTitle().contains("LinkedIn")
                    && getCurrentPageUrl().contains("/feed/");
        }

    public LinkedinHomePage loginReturnHomePage(String s, String art0931531661) {
        return null;
    }

    public LinkedinSearchPage search(String searchTerm) {
            searchField.sendKeys(searchTerm);
            searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new LinkedinSearchPage(browser);

    }
}

