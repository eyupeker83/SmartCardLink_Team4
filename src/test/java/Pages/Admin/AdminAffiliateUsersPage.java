package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminAffiliateUsersPage {


    public AdminAffiliateUsersPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[9]")
    public WebElement affiliateUsersMenuSekme;

    @FindBy(xpath = "//*[text()='Affiliated By']")
    public WebElement affiliatedBySutunBaslik;


    @FindBy(xpath = "//*[text()='User']")
    public WebElement userSutunBaslik;


    @FindBy(xpath = "//*[text()='Affiliation Amount']")
    public WebElement affiliatedAmountSutunBaslik;

    @FindBy(xpath = "//*[text()='Date']")
    public WebElement dateSutunBaslik;

    @FindBy(xpath = "//tr/td[1]")
    public List<WebElement> affiliatedByDataList;

    @FindBy(xpath = "//tr/td[2]")
    public List<WebElement> userDataList;

    @FindBy(xpath = "//tr/td[3]")
    public List<WebElement> affiliationAmountDataList;


    @FindBy(xpath = "//tr/td[4]")
    public List<WebElement> dateDataList;

    @FindBy(xpath = "//*[@id='perPage']")
    public WebElement sayfaShowResultDropDown;





}

