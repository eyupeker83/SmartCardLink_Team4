package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DashboardPage {

    public DashboardPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "(//*[@class='nav-link d-flex align-items-center py-3'])[5]")
    public WebElement virtualBackgroundsLink; //Dashboard sayfasındaki menü'de Virtual Backgrounds linki
    @FindBy (xpath ="(//*[text()='Enquiries'])[1]" )
    public WebElement enquiriesLink; //Dashboard sayfasındaki menü'de Enquiries linki


    @FindBy(xpath = "//*[@class='text-decoration-none sidebar-logo']")
    public WebElement smartCardHomeLink;//Sol üst anasayfa geçiş linki.


    //User dashboard header bolumu
    @FindBy(xpath = "//*[@class='nav-link p-0 active']") //Dashboard yazi elementi
    public WebElement dashboardText;

    @FindBy(xpath = "(//*[@class='img-fluid'])[1]") //Profil fotografi
    public WebElement profileImage;

    @FindBy(id = "dropdownMenuButton1") //sag ust kullanıcı bilgileri butonu
    public WebElement usersButton;

    //-----------kullanıcı bilgileri dropdown menu-----------
    @FindBy(xpath = "(//*[@class='dropdown-item text-gray-900'])[1]")
    public WebElement accountSettingsButon;

    @FindBy(xpath = "(//*[@class='dropdown-item text-gray-900'])[2]")
    public WebElement manageSubscriptionButton;

    @FindBy(xpath = "(//*[@class='dropdown-item text-gray-900'])[3]")
    public WebElement changePasswordButton;

    @FindBy(xpath = "(//*[@class='dropdown-item text-gray-900'])[4]")
    public WebElement changeLanguageButton;

    @FindBy(xpath = "//*[@class='dropdown-item text-gray-900 d-flex']")
    public WebElement signOutButton;

    //--------------------------User dasboard body bolumu--------------------------------------

    //---- Soldaki page butonlari
    @FindBy(xpath = "(//*[@class='aside-menu-title'])[1]") //dashboard page butonu
    public WebElement dashboard;

    @FindBy(xpath = "(//*[@class='nav-item '])[1]") //vCards page butonu
    public WebElement vCards;

    @FindBy(xpath = "(//*[@class='nav-item '])[2]") //enquiries page butonu
    public WebElement enquiries;

    @FindBy(xpath = "(//*[@class='nav-item '])[3]") //appointments page butonu
    public WebElement appointments;

    @FindBy(xpath = "(//*[@class='nav-item '])[4]") //virtual backgrounds page butonu
    public WebElement virtualBackgrounds;

    @FindBy(xpath = "(//*[@class='nav-item '])[5]") //affiliations page butonu
    public WebElement affiliations;
// affilations olarak verilen locate aslında settings'i isaret ediyor

    @FindBy(xpath = "(//*[@class='nav-item '])[6]") //settings page butonu
    public WebElement settings;


    //---- Kart satiri
    @FindBy(xpath = "//div[@class='col-xxl-3 col-xl-4 col-sm-6 widget']") //Bodys kisminda gonunen renkli kartlarin listesi
    public List<WebElement> cards;

    @FindBy(xpath = "//*[@class='fs-1-xxl fw-bolder text-white']") //kartlarin uzerinde/icinde bulunan sayilarin listesi
    public List<WebElement> numberOfCards;

    @FindBy(xpath = "//*[@class='mb-0 fs-4 fw-light']") //kartlarin uzerinde/icinde bulunan text elementleri
    public List<WebElement> cardsText;


    //Vcard Analytic tablo
    @FindBy(xpath = "(//div[@class='col-12 mb-4'])[2]") //Vcard Analytic table tamami
    public WebElement vCardAnalyticTable;

    //Today Appointments tablo
    @FindBy(xpath = "//div[@class='col-12']") //Today Appointments table tamami
    public WebElement todayAppointmentsTable;

    @FindBy(xpath = "//thead//tr") //Today Appointments table baslik satiri
    public WebElement todayAppointmentsTableHeader;

    @FindBy(xpath = "//tbody//tr") //Today Appointments table satirlarin listesi
    public List<WebElement> todayAppointmentsTableRows;

}
