package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminCashPaymentPage {

    public AdminCashPaymentPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[6]")
    public WebElement cashPaymentsButonu;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> cashPaymentWebTable;

    @FindBy(xpath = "//div[@*='text-muted ms-sm-3 pagination-record']")
    public WebElement result;


}
