package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminSubscribedUserPlansPage {

    public AdminSubscribedUserPlansPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td[3]")
    public WebElement tableStartDate;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    public WebElement tableEndDate;

    @FindBy(xpath = "(//*[@class='btn px-1 text-info fs-3 subscribed-user-plan-view-btn'])[1]")
    public WebElement tableViewIcon;

    @FindBy(xpath = "//*[@class='modal-body pb-0 pt-2']")
    public WebElement planDetailContent;

    @FindBy(xpath = "(//*[@class='btn px-1 text-primary fs-3 subscribed-user-plan-edit-btn'])[1]")
    public WebElement tableEditIcon;

    @FindBy(xpath = "//*[@class='form-control bg-white flatpickr-input active']")
    public WebElement endDateTextBox;

    @FindBy(id = "EndDate")
    public WebElement id;

    @FindBy(xpath = "(//*[@class='btn btn-primary m-0'])[1]")
    public WebElement saveButton;

    @FindBy(xpath = "(//span[@class='flatpickr-day'])[1]")
    public WebElement date;

    @FindBy(id = "editSubscriptionForm")
    public WebElement form;
}
