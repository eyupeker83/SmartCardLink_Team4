package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VcardsPage {

    public VcardsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[@class='aside-menu-title'])[2]")
    public WebElement vCardsTab;

    @FindBy(xpath = "//div[@class='d-flex justify-content-end']")
    public WebElement newVCardsButton;

    @FindBy(xpath = "//input[@id='vcard-url-alias']")
    public WebElement urlTextBox;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement vCardNameTextBox;

    @FindBy(xpath = "//input[@id='occupation']")
    public WebElement occupationTextBox;

    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//input[@class='btn btn-primary me-3']")
    public WebElement vCardSaveButton;

    @FindBy(xpath = "//h1[text()='Edit VCard']")
    public WebElement editvCardText;

    @FindBy(xpath = "//a[text()='Back']")
    public WebElement vCardBackButton;

    @FindBy(xpath = "(//a[@class='mb-1 text-decoration-none fs-6'])[1]")
    public WebElement lastCreatedVCardName;
    // assertion ile vCard isimlerini karsilastirmak icin
    @FindBy(xpath = "(//a[@class='mb-1 text-decoration-none fs-6'])[2]")
    public WebElement previousCreatedVCardName;

    @FindBy(xpath = "(//div[@class='col-12 text-muted pagination-record ms-sm-3'])")
    public WebElement numberOfVCardsResult;

    @FindBy(xpath = "//a[@title='QR Code']//*[name()='svg']")
    public WebElement qrCodeButton;

    @FindBy(xpath = "(//a[@title='Download VCard'])[1]")
    public WebElement downloadVCardButton;

    @FindBy(xpath = "(//a[@title='Enquiries'])[1]")
    public WebElement enquiriesButton;

    @FindBy(xpath = "//a[@title='Duplicate VCard']")
    public WebElement duplicateVCardButton;

    @FindBy(xpath = "//button[text()='Yes']")
    public WebElement duplicateAcceptanceButton;

    @FindBy(xpath = "//button[text()='Yes, Delete!']")
    public WebElement yesDeleteButton;

    @FindBy(xpath = "(//a[@title='Edit'])[2]")
    public WebElement previousCreatedEditVCardButton;

    @FindBy(xpath = "(//a[@title='Delete'])[2]")
    public WebElement previousCreatedDeleteVCardButton;

    @FindBy(xpath = "(//a[@title='Delete'])[1]")
    public WebElement lastCreatedDeleteVCardButton;

    @FindBy(xpath = "//td[@class='text-center']")
    public WebElement noDataTBodyChart;

    @FindBy(xpath = "//*[@*='Enter First Name']")
    public WebElement firstName;

    @FindBy(xpath = "//*[@*='Enter Last Name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@*='Enter Email Address']")
    public WebElement email;

    @FindBy(xpath = "(//*[@*='iti__country-name'])[471]")
    public WebElement ulkeKodu;

    @FindBy(xpath = "//*[@*='Enter Phone Number']")
    public WebElement phone;

    @FindBy(id = "alternative_email")
    public WebElement alternativeEmail;

    @FindBy(xpath = "//*[@*='alternativePhone']")
    public WebElement altenativePhone;

    @FindBy(xpath = "(//div[@class='iti__arrow'])[1]")
    public WebElement ulkeKoduButon1;

    @FindBy(xpath = "(//div[@class='iti__arrow'])[2]")
    public WebElement ulkeKoduButon2;

    @FindBy(xpath = "//textarea[@*='Enter Your Location']")
    public WebElement location;

    @FindBy(xpath = "//*[@*='Enter Your Location URL']")
    public WebElement locationURL;

    @FindBy(xpath = "//*[@*='Enter Date of Birth']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//*[@*='Enter Company Name']")
    public WebElement company;

    @FindBy(xpath = "//*[@*='Enter Job Title']")
    public WebElement job;

    @FindBy(id = "select2-default_language-container")
    public WebElement language;

    @FindBy(xpath = "//*[@class='btn btn-primary me-3']")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[text()='Basic Details updated successfully.']")
    public WebElement saveTest;

    @FindBy(xpath = "//*[@*='btn btn-outline-primary float-end']")
    public WebElement backButon;

    @FindBy(xpath = "//*[@*='vcardUrl107']")
    public WebElement previewURL;

    @FindBy(xpath = "//*[@*='profile-name pt-2 mb-0']")
    public WebElement nameTest;

    @FindBy(xpath = "(//span[@class='profile-designation pt-2 fw-light'])[2]")
    public WebElement jobTest ;

    @FindBy(xpath = "//*[@*='profile-company d-block']")
    public WebElement companyTest ;

    @FindBy(xpath = "//*[@*='svg-inline--fa fa-map-location-dot icon fa-2x']")
    public WebElement locateURLTest;

    @FindBy(xpath = "(//div[@class='card event-card p-3 h-100 shadow-none  border-0'])[1]")
    public WebElement mailTest;

    @FindBy(xpath = "(//*[@*='event-name text-center pt-3 mb-0 text-decoration-none'])[4]")
    public WebElement phoneTest;

    @FindBy(xpath = "//h6[text()='Yozgat']")
    public WebElement locateTest;

    @FindBy(xpath = "//*[text()='If you are interested']")
    public WebElement WHD3Test;

    //-------- AYLIN
    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-pen-to-square'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//*[@class='text-decoration-none fs-6'])[1]")
    public WebElement cardURL;


}
