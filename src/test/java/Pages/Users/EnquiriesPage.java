package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EnquiriesPage {
    public EnquiriesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//*[@data-icon='eye']")
    public WebElement vcardView;
    @FindBy(xpath = "//*[@data-icon='trash']")
    public WebElement vcardDelete;
    @FindBy(xpath = "//*[text()='Yes, Delete!']")
    public WebElement deleteConfirm;
    @FindBy(xpath = "//*[text()='Deleted !']")
    public WebElement deleted;

    @FindBy(xpath = "//*[@class='modal-title']")
    public WebElement vcardTitle;
    @FindBy(xpath = "(//*[@aria-label='Close'])[1]")
    public WebElement vcardDetailsClose;

    //https://qa.smartcardlink.com/eyupeker
    @FindBy (xpath = "//*[@name='name']")
    public WebElement inquiriesName;
    @FindBy(xpath = "//*[@name='email']")
    public WebElement inquiriesEmail;
    @FindBy(xpath = "//*[@name='phone']")
    public WebElement inquiriesPhone;
    @FindBy(xpath = "//*[@name='message']")
    public WebElement inquiriesMessage;
    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement sendMessage;


}
