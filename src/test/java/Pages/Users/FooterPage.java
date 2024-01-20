package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FooterPage {
    public FooterPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
     @FindBy(xpath = "//footer//*[@title='Facebook']")
     public   WebElement faceBookIcon;
    @FindBy(xpath = "//*[@title='Twitter']")
    public   WebElement twitterIcon;
    @FindBy (xpath = "//*[@data-icon='instagram']")
    public   WebElement instagramIcon;
    @FindBy(xpath = "//*[@data-icon='linkedin']")
    public   WebElement linkedinIcon;
    @FindBy(xpath = "//*[@data-icon='pinterest']")
    public   WebElement pinterestIcon;
    @FindBy (xpath = "//*[text()='Terms & Conditions']")
    public   WebElement termsOfConditions;
    @FindBy(xpath = "//*[text()='Privacy Policy']")
    public  WebElement privacyPolicy;
    @FindBy(xpath = "//*[text()='FAQ']")
    public  WebElement faq;
    @FindBy(xpath = "(//div[@class='col-4'])[1]")
    public WebElement sayfaSonu;



}
