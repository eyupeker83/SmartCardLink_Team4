package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminFrontCMSPage {
    public AdminFrontCMSPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Front CMS']")
    public WebElement frontCmsBtn;
    @FindBy(xpath = "//*[text()='Subscribers']")
    public WebElement subscribersBtn;
}
