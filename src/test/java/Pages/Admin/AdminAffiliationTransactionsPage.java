package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminAffiliationTransactionsPage {

    public AdminAffiliationTransactionsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Affiliation Transactions']")
    public WebElement affiliationTransactionsLinki;

    @FindBy(xpath = "//*[@*='mb-1 text-decoration-none fs-6']")
    public WebElement name;

    @FindBy(xpath = "//*[@*='badge bg-success me-2']")
    public WebElement amountApprovastatus;

    @FindBy(xpath = "//*[@*='badge bg-secondary me-2']")
    public WebElement date;

    @FindBy(xpath = "//*[@*='showAffiliationWithdrawBtn']")
    public WebElement action;

    @FindBy(id = "showAffiliationWithdrawModalBtn")
    public WebElement actionDetails;

    @FindBy(xpath = "//*[@aria-labelledby='showAffiliationWithdrawModal']")
    public WebElement actionClose;

    @FindBy(xpath = "//*[@*='object-fit-cover sidebar-app-logo']")
    public WebElement title;

    @FindBy(xpath = "//*[@*='text-gray-100 fs-20 fw-6 mb-lg-5 mb-4']")
    public WebElement baslikYazi;

    @FindBy(xpath = "//*[@*='text-dark mb-1']")
    public WebElement baslik;

    @FindBy(xpath = "(//a[@class='nav-link mt-1'])[1]")
    public WebElement featuresLink;




}
