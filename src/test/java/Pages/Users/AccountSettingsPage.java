package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AccountSettingsPage {

    public AccountSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@id='dropdownMenuButton1']")
    public WebElement profilDropDownMenu;

    @FindBy(xpath = "//a[@class='dropdown-item text-gray-900']")
    public WebElement accountSettingsSekmesi;

    @FindBy(xpath = "//*[text()='Avatar:']")
    public WebElement avatarBaslik;


    @FindBy(xpath = "//div[@class='image previewImage']")
    public WebElement avatarPhoto;

    @FindBy(xpath = "//*[@title='edit']")
    public WebElement avatarEditButton;


    @FindBy(xpath = "//*[text()='Full Name:']")
    public WebElement fullNameBaslik;

    @FindBy(xpath = "//*[@name='first_name']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//*[@name='last_name']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//*[text()='Email:']")
    public WebElement eMailBaslik;

    @FindBy(xpath = "//*[@name='email']")
    public WebElement eMailBox;

    @FindBy(xpath = "//*[text()='Contact Number:']")
    public WebElement contactNoBaslik;

    @FindBy(xpath = "//div[@class='iti__flag-container']")
    public WebElement phoneCountryDropDown;

    @FindBy(xpath = "//*[text()='Italy (Italia)']")
    public WebElement italyPhoneCode;

    @FindBy(xpath = "//*[@id='phoneNumber']")
    public WebElement phoneNumberBox;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@class='btn btn-secondary']")
    public WebElement discardButton;

    @FindBy(xpath = "(//*[@*='link-info fs-6 text-decoration-none'])[2]")
    public WebElement accountCreate;

    @FindBy(xpath = "//input[@*='Password must be at least 8 characters long and contain at least one letter, one number and one special character.']")
    public WebElement password;

    @FindBy(id = "password_confirmation")
    public WebElement passwordConfirmation;
}
