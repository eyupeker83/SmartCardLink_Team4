package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signInButton;

    @FindBy(xpath = "//h1[@class='text-center mb-7']")
    public WebElement signBaslik;


    @FindBy(xpath = "//label[@for='email']")
    public WebElement emailBaslik;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;


    @FindBy(xpath = "//*[@for='password']")
    public WebElement passwordBaslik;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@class='bi bi-eye-fill']")
    public WebElement showPasswordButton;

    @FindBy(xpath = "//*[@class='link-info fs-6 text-decoration-none']")
    public WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@id='remember_me']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "(//*[@class='link-info fs-6 text-decoration-none'])[2]")
    public WebElement createNewAccountLink;

    @FindBy(xpath = "//*[@class='alert alert-danger']")
    public WebElement failedLoginText;
}
