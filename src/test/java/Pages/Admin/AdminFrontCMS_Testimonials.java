package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class AdminFrontCMS_Testimonials {

        public AdminFrontCMS_Testimonials(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/front-cms']")
        public WebElement frontCMSButton;

        @FindBy(xpath = "//a[@href='https://qa.smartcardlink.com/sadmin/frontTestimonials']")
        public WebElement testimonialsButton;

        //header bolumu
        @FindBy(xpath = "//input[@type='search']") //arama kutusu
        public WebElement searchBox;

        @FindBy(id = "addTestimonialBtn") //yeni gorus ekleme butonu
        public WebElement addTestimonial;

        //Add Testimonials sayfa bolumu

        @FindBy(xpath = "//*[text()='New Testimonial']") //yeni gorus sayfa basligi
        public WebElement newTestimonialText;

        @FindBy(id = "name")
        public WebElement addNameBox;

        @FindBy(id = "description")
        public WebElement addDescriptionBox;

        @FindBy(xpath = "(//*[@class='svg-inline--fa fa-pen'])[1]")
        public WebElement changeImage;

        @FindBy(id = "testimonialSave")
        public WebElement addSaveBox;

        @FindBy(xpath = "//*[@class='toast toast-success']")
        public WebElement successAlert;

        //tablo bolumu
        @FindBy(xpath = "//tbody//tr") //olusturulan kayitlarin satirlarini kaydeden liste
        public List<WebElement> testimonialsTableRows;

        @FindBy(xpath = "//*[@class='svg-inline--fa fa-eye']") //gorusleri goruntuleme butonu
        public List<WebElement> testimanialsViews;

        @FindBy(xpath = "//*[@title='Edit']") //gorusleri duzenleme butonu
        public List<WebElement> testimonialsEdit;

        @FindBy(xpath = "//*[@title='Delete']") //gorusleri silme butonu
        public WebElement testimonialsDelete;

        //Action sutunu butonlari acilan sayfalar

        //--- View butonu

        @FindBy(xpath = "(//*[@class='svg-inline--fa fa-eye'])[1]")
        public WebElement viewButton;

        @FindBy(xpath = "//h2[@class='modal-title']") //Testimonials Details yazi elementi
        public WebElement viewTitle;

        @FindBy(id = "showName") //gorus detaylarinda isim elementi
        public WebElement viewName;

        @FindBy(id = "showDesc") //gorus yazisi elementi
        public WebElement viewDescription;

        @FindBy(id = "showTestimonialIcon") // fotograf elementi
        public WebElement viewImage;

        @FindBy(xpath = "(//*[@class='btn-close'])[3]") //View sayfasini kapatma butonu
        public WebElement closeButton;

        //--- Edit butonu

        @FindBy(xpath = "(//*[@class='svg-inline--fa fa-pen-to-square'])[1]")
        public WebElement editButton;

        @FindBy(xpath = "//*[text()='Edit Testimonial']") //edit sayfa basligi
        public WebElement editText;

        @FindBy(id = "editName") //isim kutusu
        public WebElement nameBox;

        @FindBy(id = "editDescription") //gorus kutusu
        public WebElement descriptionBox;

        @FindBy(xpath = "(//*[@class='picker-edit rounded-circle text-gray-500 fs-small'])[1]") //fotograf ekleme butonu
        public WebElement imageButton;

        @FindBy(id = "testimonialUpdate") //Edit testimonial save butonu
        public WebElement saveButton;

        @FindBy(xpath = "//div[@class='toast toast-success']") //Successful alert yazisi
        public WebElement successText;

        @FindBy(xpath = "(//*[text()='Discard'])[2]") ////Edit testimonial save butonu
        public WebElement discardButton;

        //--- Delete butonu

        @FindBy(xpath = "(//*[@class='svg-inline--fa fa-trash'])[1]")
        public WebElement deleteButton;

        @FindBy(xpath = "//div[@class='swal-title']")
        public WebElement deleteText;
        @FindBy(xpath = "//*[text()='Yes, Delete!']") //Delete sayfasinin icerisindeki delete butonu
        public WebElement deleteConfirm;

        @FindBy(xpath = "//*[text()='No, Cancel']") //Delete sayfasinin icerisindeki delete butonu
        public WebElement cancelButton;

        @FindBy(xpath = "//*[@class='swal-icon--success__ring']") // Silme islemi dogrulama alert
        public WebElement deleteAlert;

        //---------------------------------------------------------

        //Results
        @FindBy(xpath = "//*[@class='col-12 text-muted pagination-record ms-sm-3']") //gorus sayisi yazi elementi
        public WebElement resultText;

        public void getImage() throws InterruptedException, AWTException {

                imageButton.click();
                Thread.sleep(2000);
                //Create object for Robot class
                Robot robot=new Robot();
                //Store the path of the file to be uploaded using StringSelection Class Object
                StringSelection filepath=new StringSelection("150-4.jpg");
                //Copy above path to Clipboard
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);
                //Press Control&V to paste the above path
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                Thread.sleep(1000);
                //Release Control & V buttons
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                //Press Enter
                robot.keyPress(KeyEvent.VK_ENTER);
                //Release Enter
                robot.keyRelease(KeyEvent.VK_ENTER);
                //wait for the file to get uploaded
                robot.delay(2000);
                // Thread.sleep(10000);
                System.out.println("File Uploaded Successfully");
        }




}
