package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SettingsPage {

    public SettingsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[6]")
    public WebElement settingTab;

    @FindBy(xpath = "//input[@id='stripeEnable']")
    public WebElement stripeCheckBox;

    @FindBy(xpath = "//input[@id='stripeKey']")
    public WebElement stripeKeyTextBox;

    @FindBy(xpath = "//input[@id='stripeSecret']")
    public WebElement stripeSecretTextBox;

    @FindBy(xpath = "//input[@id='paypalEnable']")
    public WebElement paypalCheckBox;

    @FindBy(xpath = "//input[@id='paypalKey']")
    public WebElement paypalClientIdTextBox;

    @FindBy(xpath = "//input[@id='paypalSecret']")
    public WebElement paypalSecretTextBox;

    @FindBy(xpath = "//input[@id='paypalMode']")
    public WebElement paypalModeTextBox;

    @FindBy(xpath = "(//span[@class='selection'])[1]")
    public WebElement currencyDropdownMenu;

    @FindBy(xpath = "//input[@name='enable_contact']")
    public WebElement enableContactCheckbox;

    @FindBy(xpath = "//input[@name='hide_stickybar']")
    public WebElement hidevCardStickyBarCheckbox;

    @FindBy(xpath = "//input[@name='whatsapp_share']")
    public WebElement whatsappShareCheckbox;

    @FindBy(xpath = "//label[text()='24 Hour']")
    public WebElement timeFormat24Hour;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement saveConfirmationAlert;
}
