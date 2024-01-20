package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import javax.xml.xpath.XPath;

public class PaymentPage {

    public PaymentPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@class='CheckoutInput CheckoutInput--tabularnums Input Input--empty'])[1]")
    public WebElement kartNumber;

    @FindBy(id = "cardExpiry")
    public WebElement aa_yy;

    @FindBy(id = "cardCvc")
    public WebElement cvc;

    @FindBy(xpath = "//*[@class='CheckoutInput Input Input--empty']")
    public WebElement cardNameSurname;

    @FindBy(xpath = "//*[@class='SubmitButton-IconContainer']")
    public WebElement payButton;

    @FindBy(xpath = "//*[@class='btn mt-5 btn-back']")
    public WebElement backToSubscriptions;

}

