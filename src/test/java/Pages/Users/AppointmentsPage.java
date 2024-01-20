package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AppointmentsPage {

    public AppointmentsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@class='nav-link d-flex align-items-center py-3'])[4]")
    public WebElement appointmentsButton;

    @FindBy(xpath = "//*[@class='nav-link p-0 active']")
    public WebElement headerText;

    @FindBy(xpath = "//*[@type='search']") //arama butonu
    public WebElement searchButton;

    @FindBy(xpath = "//tbody//tr//td[2]") // oluşturulan randevu listesi name data
    public List<WebElement> appointmentsData;

    @FindBy(xpath = "//*[@class='btn px-1 text-danger fs-3 appointment-delete-btn']")
    public WebElement deleteButton;

    @FindBy(xpath = "(//*[@class='swal-button-container'])[1]")
    public WebElement deleteConfirm;

    @FindBy(xpath = "//*[@class='swal-button__loader']")
    public WebElement deleteOkButton;

    @FindBy(xpath = "//*[@class='swal-title']")
    public WebElement deletedTitle;

    @FindBy(xpath = "//*[@class='col-12 text-muted pagination-record ms-sm-3']") // randevu sayıları sonuç yazı elementi
    public WebElement resultsText;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-trash']")
    public WebElement deleteApp;

    public Integer resultNum(){
        String result = "";
        String[] arr = resultsText.getText().split(" ");
        result = arr[1];
        Integer resultNumber = Integer.parseInt(result);

        return resultNumber;
    }

    //----------- Appointments Olusturma Bolumu VCards URL uzerinden ------------

    @FindBy(xpath = "//*[text()=' Get in Touch']") //header iletisim butonu
    public WebElement getInTouch;

    @FindBy(xpath = "(//*[text()='Make Appointment'])[1]") //Randevu sayfasi basligi
    public WebElement makeAppText;

    @FindBy(id = "pickUpDate") //tarih butonu
    public  WebElement dateBoard;

    @FindBy(xpath = "//*[@class='flatpickr-day']") //tarih sayfasi uzerinden gun listesi
    public List<WebElement> dayContainer;

    @FindBy(xpath = "//*[@id='time-slot']") //saat butonu
    public WebElement hourBoard;

    @FindBy(xpath = "//*[@class='btn btn-primary appointmentAdd appoint-btn  fs-14']")
    public  WebElement makeAppointmentButton;

    @FindBy(xpath = "(//h5[@class='modal-title'])[2]") //acilan randevu bilgi sayfasi basligi
    public WebElement makeAppNewPage;

    @FindBy(id = "paypalIntUserName") //isim kutusu elementi
    public WebElement nameTextBox;

    @FindBy(id = "paypalIntUserEmail") //e-mail kutusu elementi
    public WebElement emailTextBox;

    @FindBy(id = "serviceSave")
    public WebElement saveButton;

    @FindBy(xpath = "toast toast-success")
    public WebElement alertText;

    @FindBy(xpath = "//*[@aria-label='November 10, 2023']")
    public WebElement date;

    //------------- Appointments Olusturma Bolumu VCards Action Edit uzerinden

    @FindBy(xpath = "(//*[@class='nav-link p-4 '])[7]")
    public WebElement editAppButton;

    //@FindBy(xpath = "//*[@class='form-check-input']")
    //public List<WebElement> checkbox;

    @FindBy(xpath = "//*[@class='form-check-input']")
    public List<WebElement> checkbox;

    @FindBy(xpath = "//*[@class='btn btn-primary me-3']")
    public WebElement editAppSaveButton;

    @FindBy(xpath = "//*[@class='alert alert-success']")
    public WebElement editAppAlert;

}

