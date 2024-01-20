package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddVirtualBackgroundPage {

    public AddVirtualBackgroundPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "select2-e-vcard-id-container")
    public WebElement VcardName;

    @FindBy(id = "exampleInputImage")
    public WebElement AddEcard;

    @FindBy(id = "profileImageIcon")
    public WebElement AddEcardClick;

    @FindBy(id = "e-card-first-name")
    public WebElement firstName;

    @FindBy(id = "e-card-last-name")
    public WebElement lastName;

    @FindBy(id = "e-card-email")
    public WebElement Email;

    @FindBy(id = "e-card-occupation")
    public WebElement occupation;

    @FindBy(id = "e-card-location")
    public WebElement location;

    @FindBy(id = "phoneNumber")
    public WebElement phone;

    @FindBy(id = "e-card-website")
    public WebElement webSite;

    @FindBy(xpath = "//*[@class='btn btn-primary me-3']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[@class='select2-results']")
    public WebElement adaVcardName;
}
