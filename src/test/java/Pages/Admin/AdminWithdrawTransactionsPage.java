package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.webaudio.WebAudio;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminWithdrawTransactionsPage {

    public AdminWithdrawTransactionsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[11]")
    public WebElement withdrawTransactions;

    @FindBy(xpath = "(//div[@class='d-flex flex-column'])[1]")
    public WebElement tableFirstUser;

    @FindBy(xpath = "(//span[@class='badge bg-success me-2'])[1]")
    public WebElement tableFirstAmount;

    @FindBy(xpath = "(//span[@class='badge bg-primary me-2'])[1]")
    public WebElement tableFirstPaymentType;

    @FindBy(xpath = "(//span[@class='badge bg-secondary me-2'])[1]")
    public WebElement tableFirstDate;
}
