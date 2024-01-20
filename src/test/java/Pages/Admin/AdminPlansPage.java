package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminPlansPage {

    public AdminPlansPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement userFirst;

    @FindBy(xpath = "//*[@class='btn btn-primary ms-auto']")
    public WebElement newPlanButtonu;


    @FindBy(id = "name")
    public WebElement nameTextBox;

    @FindBy(xpath = "(//*[@role='combobox'])[1]")
    public WebElement frequencyDropDown;

    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> frequencyOptions;

    @FindBy(xpath = "(//*[@class='select2-selection select2-selection--single'])[2]")
    public WebElement CurrencyDropDown;

    @FindBy(xpath = "//li[@role='option']")
    public List<WebElement> currencyOptions;

    @FindBy(id = "price")
    public WebElement priceTextBox;

    @FindBy(id = "no_of_vcards")
    public WebElement no_of_vcardsTextBox;

    @FindBy(id = "trial_days")
    public WebElement trial_daysTextBox;

    @FindBy(xpath = "(//*[@class='col-lg-3 img-box mb-2'])[1]")
    public WebElement multiTemplates;

    @FindBy(id = "featureAll")
    public WebElement featureAll;

    @FindBy(id = "planFormSubmit")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-trash'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    public WebElement tableFirsName;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement onayAlert;

    @FindBy(xpath = "//*[@class='swal-button swal-button--confirm']")
    public WebElement yesDelete;




}
