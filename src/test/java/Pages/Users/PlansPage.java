package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PlansPage {

    public PlansPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "paymentType")
    public WebElement selectPaymentGateway;

    @FindBy(xpath = "//*[@class='mt-5 stripePayment proceed-to-payment']")
    public WebElement Pay_SwitchPlan;

}
