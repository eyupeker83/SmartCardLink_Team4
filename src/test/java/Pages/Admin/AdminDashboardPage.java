package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AdminDashboardPage {
    public AdminDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


   @FindBy(xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[1]")
    public WebElement activeusers;

    @FindBy(xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[2]")
    public WebElement activeVcard;

    @FindBy(xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[3]")
    public WebElement deActiveUsers;

    @FindBy(xpath = "(//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget'])[4]")
    public WebElement deActiveVcards;



    @FindBy(xpath = "//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget']") //Bodys kisminda gonunen renkli kartlarin listesi
    public List<WebElement> cards;

    @FindBy(xpath = "//*[@class='fs-1-xxl fw-bolder text-white']") //kartlarin uzerinde/icinde bulunan sayilarin listesi
    public List<WebElement> numberOfCards;

    @FindBy(xpath = "//*[@class='mb-0 fs-4 fw-light']") //kartlarin uzerinde/icinde bulunan text elementleri
    public List<WebElement> cardsText;

    @FindBy(xpath = "//div[@class='col-xxl-4 col-12 mb-7 mb-xxl-0']")
    public WebElement plansbyUsers;

    @FindBy(xpath = "//div[@class='col-xxl-8 col-12 mb-7 mb-xxl-0']")
    public WebElement gelirGrafigi;


    @FindBy(id = "overview-tab")
    public WebElement dayButonu;

    @FindBy(id = "vweekData")
    public WebElement weekButonu;

    @FindBy(id = "monthData")
    public WebElement monthButonu;

    @FindBy(xpath = "//*[@class='border-top w-100 pt-4 mt-7']")
    public WebElement clickButonu;

    @FindBy(xpath = "//tbody//tr//td[1]")
    public List<WebElement> nameData;




    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[8]")
    public WebElement plansLink;


    @FindBy(xpath = "(//*[@class='aside-menu-title'])[7]")
    public WebElement subscribedUserPlansLink;

    @FindBy(xpath = "//button[@id='dropdownMenuButton1']")
    public WebElement usersButton;

}
