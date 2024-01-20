package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class NewAccountPage {
    public NewAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='link-info fs-6 text-decoration-none'])[2]")
    public WebElement createAnAccountButonu;

    @FindBy(xpath = "//*[@aria-describedby='firstName']")
    public WebElement firstnameButonu;

    @FindBy(xpath = "//*[@aria-describedby='lastName']")
    public WebElement lastnameButonu;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailButonu;

    @FindBy(xpath = "//*[@aria-describedby='password']")
    public WebElement passwordButonu;

    @FindBy(xpath = "//*[@id='password_confirmation']")
    public WebElement passwordOnayButonu;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement checkboxButonu;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButonu;

    @FindBy(xpath = "//h1")
    public WebElement createAccountyazisi;

    @FindBy(xpath = "//*[@role='alert']")
    public WebElement successText;












}
