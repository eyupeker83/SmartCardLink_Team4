package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ManageSubscriptionPage {

    public ManageSubscriptionPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h2")
    public WebElement silverText;
}
