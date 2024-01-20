package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminCountriesPage {
    public AdminCountriesPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//span[text()='Countries']")
    public WebElement countries;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div")
    public WebElement countriesList;

    @FindBy(xpath = "//*[@type='search']")
    public WebElement search;

    @FindBy(xpath = "//table/thead/tr/th[1]/div/span[1]")
    public WebElement NAME__Arrange;

    @FindBy(xpath = "//table/thead/tr/th[2]")
    public WebElement shortCode;

    @FindBy(xpath = "//table/thead/tr/th[3]/div")
    public WebElement phonceCode;

    @FindBy(xpath = "//*[@id=\"newCountryBtn\"]")
    public WebElement newCountry;

    @FindBy(xpath = "//*[@id=\"countryName\"]")
    public WebElement newCountry_name;

    @FindBy(xpath = "//*[@id=\"short_code\"]")
    public WebElement newCountry_shortCode;

    @FindBy(xpath = "//*[@id=\"phone_code\"]")
    public WebElement newCountry_phoneCode;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    public WebElement newCountry_savebtn;



    @FindBy(xpath = "//div/nav/ul/li[2]/span")
    public WebElement page1; //sayfa 1

    @FindBy(xpath = "//div/nav/ul/li[3]/button")
    public WebElement page2; //sayfa 2
    //Dinamik page
    public String page_Any(int pageAny_sira){
        String page_Any="//div/nav/ul/li["+pageAny_sira+"]/button";

        return page_Any;

    }
    @FindBy(xpath = "//div/nav/ul/li[15]/button")
    public WebElement pageNext; //sonraki sayfa

    @FindBy(xpath = "//div/nav/ul/li[1]/button")
    public WebElement pagePrevious; //onceki sayfa


    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[6]/div[2]/div[1]")
    public WebElement kayitliUlkeSayisi;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/div/a[1]")
    public WebElement countryEdit;
    //Dinamik Edit
    public String countryEdit_Any(int countryEdit_sira){
        String countryEdit_Any="//tbody/tr["+countryEdit_sira+"]/td[4]/div/a[1]";

        return countryEdit_Any;
    }

    @FindBy(xpath = "//*[@id=\"editName\"]")
    public WebElement countryEditName;

    @FindBy(xpath = "//*[@id=\"editShortCode\"]")
    public WebElement countryEditShortCode;

    @FindBy(xpath = "//*[@id=\"editPhoneCode\"]")
    public WebElement countryEditPhone;

    @FindBy(xpath = "//*[@id=\"btnSave\"]")
    public WebElement countryEditSaveBtn;

    @FindBy(xpath = "//tbody/tr[1]/td[4]/div/a[2]")
    public WebElement countryDelete;
    //Dinamik delete
    public String delete_Any(int delete_Any_sira){
        String delete_Any_Any="//tbody/tr["+delete_Any_sira+"]/td[4]/div/a[2]";

        return delete_Any_Any;
    }
    @FindBy(xpath = "/html/body/div[5]/div/div[4]/div[1]/button")
    public WebElement countryDelete_deleteBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div[3]")
    public WebElement countryDeleteApproved;

    @FindBy(xpath = "//*[@id=\"nav-header\"]/div/div/ul/li[13]/a")
    public WebElement statesTab;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[5]/table")
    public WebElement statesTable;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/a[1]")
    public WebElement statesEdit;
    //dinamik states Edit
    public String statesEdit_Any(int statesEdit_sira){
        String statesEdit_Any="//tbody/tr["+statesEdit_sira+"]/td[3]/div/a[1]";

        return statesEdit_Any;
    }
    @FindBy(xpath = "//table/thead/tr/th[2]")
    public WebElement statesCountryName;

    @FindBy(xpath = "//*[@id=\"editName\"]")
    public WebElement statesNewName;

    @FindBy(xpath = "//*[@id=\"select2-editCountryId-container\"]")
    public WebElement statesNewCountryName;

    @FindBy(xpath = "//*[@id=\"editStateModal\"]/span/span/span[1]/input")
    public WebElement statesNewCountryNameInput;

    @FindBy(xpath = "//*[@id=\"editStateForm\"]/div[2]/button[1]")
    public WebElement statesNewSave;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/a[2]")
    public WebElement statesDelete;
    //dinamik states Delete
    public String stateDelete_Any(int statesDelete_sira){
        String statesDelete_Any="//tbody/tr["+statesDelete_sira+"]/td[3]/div/a[2]";

        return statesDelete_Any;
    }

    @FindBy(xpath = "/html/body/div[4]/div/div[4]/div[1]/button")
    public WebElement statesDelete_deleteBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div[3]") //  //*[text()='Deleted !']
    public WebElement statesDeleteApproved;

    @FindBy(xpath = "//*[@id=\"newStateBtn\"]")
    public WebElement statesNew;

    @FindBy(xpath = "//*[@id=\"nav-header\"]/div/div/ul/li[14]/a")
    public WebElement citiesTab;

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[5]/table/tbody")
    public WebElement citiesTable;

    @FindBy(xpath = "//table/thead/tr/th[2]/div/span[1]")
    public WebElement citiesStatesName;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/a[1]")
    public WebElement citiesEdit;
    //dinamik cities Edit
    public String citiesEdit_Any(int citiesEdit_sira){
        String citiesEdit_Any="//tbody/tr["+citiesEdit_sira+"]/td[3]/div/a[1]";

        return citiesEdit_Any;
    }
    @FindBy(xpath = "//tbody/tr[1]/td[3]/div/a[2]")
    public WebElement citiesDelete;
    //dinamik cities Delete
    public String citiesDelete_Any(int citiesDelete_sira){
        String citiesDelete_Any="//tbody/tr["+citiesDelete_sira+"]/td[3]/div/a[2]";

        return citiesDelete_Any;
    }
    @FindBy(xpath = "/html/body/div[4]/div/div[4]/div[1]/button")
    public WebElement citiesDelete_deleteBtn;

    @FindBy(xpath = "/html/body/div[4]/div/div[3]") //  //*[text()='Deleted !']
    public WebElement citiesDeleteApproved;

    @FindBy(xpath = "//*[@id=\"newCityBtn\"]")
    public WebElement citiesNew;





}
