package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

    public HomePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    //*****ziyaretci anasayfa header menuleri icin;


    @FindBy(xpath = "//img[@alt='company-logo']")
    public WebElement companyLogo;
    @FindBy(xpath = "//*[text()='Home']")
    public WebElement homeMenuButton;
    @FindBy(xpath = "//*[text()='Features']")
    public WebElement featuresMenuButton;
    @FindBy(xpath = "//*[text()='About']")
    public WebElement aboutMenuButton;
    @FindBy(xpath = "//*[text()='Pricing']")
    public WebElement pricingMenuButton;
    @FindBy(xpath = "//*[text()='Contact']")
    public WebElement contactMenuButton;
    @FindBy(xpath = "//*[@class='btn btn-white fs-18 ms-3 d-lg-block d-none']")
    public WebElement signInButton;


    //*****ziyaretci anasayfa body fonksiyonlari icin;


    //ana sayfa Smart Card link bolumu

    @FindBy(xpath = "//*[@class='text-dark mb-1']")
    public WebElement smartCardLinkBaslik;

    @FindBy(xpath = "//*[@class='btn btn-orange ']")
    public WebElement getSartedButon;

    @FindBy(xpath = "//h1[@class='text-center mb-7']")
    public WebElement createAnAccountBaslik;


    //ana sayfa body  basliklari

    @FindBy(xpath = "(//h2[@class='text-dark text-center mb-60'])[1]")
    public WebElement featuresBaslik;

    @FindBy(xpath = "//h2[@id='frontAboutTabUsTab']")
    public WebElement aboutSmartCardBaslik;

    @FindBy(xpath = "(//h2[@class='text-dark text-center mb-60'])[2]")
    public WebElement chooseAPlanBaslik;




    //choose a plan for you  kismi plan secenekleri icin;

    @FindBy(xpath = "//div[@class='pricing-plan-card card slick-slide']")
    public List<WebElement> planlarList;

    @FindBy(xpath = " //div[@class='pricing-plan-card card slick-slide slick-current slick-active slick-center']")
    public WebElement seciliPlan;

    @FindBy(xpath = "//h3[@class='mb-1 mt-3 fw-6']")
    public WebElement planBaslik;







    @FindBy(xpath = "//h3[text()='Standard']")
    public WebElement standardPlanBaslik;

    @FindBy(xpath = "//h3[text()='Silver']")
    public WebElement silverPlanBaslik;

    @FindBy(xpath = "//h3[text()='Gold']")
    public WebElement goldPlanBaslik;

    @FindBy(xpath = "//h3[text()='Unlimited']")
    public WebElement unlimitedPlanBaslik;
    @FindBy(xpath = "//h3[text()='VIP']")
    public WebElement VIPPlanBaslik;
    @FindBy(xpath = "//*[@class='slick-next slick-arrow']")
    public WebElement slideNextButton;

    @FindBy(xpath = "//*[@class='slick-prev slick-arrow']")
    public WebElement slidePrevButton;

    @FindBy(xpath = "//*[@class='btn btn-primary rounded-pill mx-auto  ']")
    public WebElement choosePlanButton;
    @FindBy(xpath = "(//*[@class='slick-list draggable'])[1]")
    public WebElement planSlider;//Anasayfa planların görüntülenmesi için slider tümüyle locate edildi.

    // ana sayfa contact us  kismi fonksiyonlari icin;

    @FindBy(xpath = "//*[@class='heading text-success text-center margin-b-80px mb-5']")
    public WebElement contactUsBaslik;

    @FindBy(xpath = "(//*[@class='text-decoration-none text-secondary contact-info__contact-label'])[1]")
    public WebElement infoMailLink;

    @FindBy(xpath = "(//*[@class='text-decoration-none text-secondary contact-info__contact-label'])[2]")
    public WebElement telContactLink;

    @FindBy(xpath = "//*[@class='text-secondary contact-info__contact-label mb-0']")
    public WebElement adress;

    @FindBy(id = "name")
    public WebElement contactNameBox;

    @FindBy(id = "email")
    public WebElement contactEmailBox;

    @FindBy(id = "subject")
    public WebElement contactSubjectBox;

    @FindBy(id = "message")
    public WebElement contactMessageBox;

    @FindBy(id = "submit")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//div[@class='toast-title']")
    public WebElement successMessage;


    //ana sayfa subscribe kısmı

    @FindBy(xpath = "//*[@class='text-dark text-center mb-3']")
    public WebElement subscribeBaslik;

    @FindBy(xpath = "//input[@class='form-control bg-white']")
    public WebElement subscribeEmailBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement subscribeButton;
    @FindBy(xpath = "//div[@class='toast toast-success']")
    public WebElement subscribeSuccessText;




     //Stories from our customers  kismi icin;


    @FindBy(xpath = "//h2[@class='text-white text-center mb-60']")
    public WebElement storiesBaslik;

    @FindBy(xpath = "//div[@class='testimonial-card testimonial-1 bg-white position-relative slick-slide']")
    public List<WebElement> storyList;

    @FindBy(xpath = "//div[@class='testimonial-card testimonial-1 bg-white position-relative slick-slide slick-current slick-active slick-center']")
    public WebElement gorunenStrory;

    @FindBy(xpath = "//button[@id='slick-slide-control10']")
    public WebElement storySlideButton;



    @FindBy(xpath = "(//a[@data-id='2'])[2]")
    public WebElement switchPlanButtonSilver;//Silver plan seçimi için index locate alındı.

}
