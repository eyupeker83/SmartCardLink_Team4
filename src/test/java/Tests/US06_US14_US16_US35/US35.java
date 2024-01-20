package Tests.US06_US14_US16_US35;

import Pages.Admin.AdminFrontCMS_Testimonials;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;

import static utilities.ConfigReader.getProperty;

public class US35 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminFrontCMS_Testimonials testimonials = new AdminFrontCMS_Testimonials();

    @Test(priority = 1)
    public void TC01(){
        extentTest = extentReports.createTest("US35_TC01", "Admin 'Testimonials' sayfasini goruntuleyebilmeli");

        Driver.getDriver().get(getProperty("URL"));
        extentTest.info("Admin anasayfaya gider");

        homePage.signInButton.click();
        extentTest.info("Sign In butonuna basar");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        loginPage.loginButton.click();
        extentTest.info("Admin gecerli bilgileri girerek sayfaya giris yapar");

        ReusableMethods.bekle(2);

        testimonials.frontCMSButton.click();
        ReusableMethods.bekle(2);
        testimonials.testimonialsButton.click();
        extentTest.info("'Front CMS' sayfasi uzerinden 'Testimonials' sayfasina giris yapar");

        Assert.assertTrue(testimonials.addTestimonial.isDisplayed());
        extentTest.pass("'Testimonials' sayfasinin goruntulendigini dogrular");

    }

    @Test(priority = 2)
    public void TC02() throws InterruptedException, AWTException {
        extentTest = extentReports.createTest("US35_TC02", "Admin, yeni gorus ekleyebilmeli");

        testimonials.addTestimonial.click();
        extentTest.info("Admin yeni gorus eklemek icin 'Add Testimonials' butonuna basar");

        ReusableMethods.bekle(2);
        Assert.assertTrue(testimonials.newTestimonialText.isDisplayed());
        extentTest.pass("Yeni gorus ekleme sayfasinin acildigini dogrular");

        testimonials.addNameBox.sendKeys(ConfigReader.getProperty("testimonialName"));
        extentTest.info("'Name' kutusunu doldurur");
        testimonials.addDescriptionBox.sendKeys(ConfigReader.getProperty("description"));
        extentTest.info("'Description' kutusunu doldurur");
        testimonials.getImage();
        extentTest.info("Yeni fotograf ekler");

        testimonials.addSaveBox.click();
        extentTest.info("'Save' butonuna basar");

        Assert.assertTrue(testimonials.successAlert.isDisplayed());
        extentTest.pass("Yeni gorus eklendigini dogrular");


    }

    @Test(priority = 3)
    public void TC03(){
        extentTest = extentReports.createTest("US35_TC03", "Admin, gorus ve sorulari goruntuleyebilmeli");

        ReusableMethods.bekle(5);
        testimonials.viewButton.click();
        extentTest.info("Admin, gorusleri goruntuleyebilmek icin 'View' butonuna basar");

        ReusableMethods.bekle(2);

        Assert.assertTrue(testimonials.viewTitle.isDisplayed());
        extentTest.pass("Gorus ve soru sayfasinin acildigini dogrular");
        Assert.assertTrue(testimonials.viewName.isDisplayed());
        extentTest.pass("View name elementinin goruntulendigini dogrular");
        Assert.assertTrue(testimonials.viewDescription.isDisplayed());
        extentTest.pass("Description elementinin goruntulendigini dogrular");
        Assert.assertTrue(testimonials.viewImage.isDisplayed());
        extentTest.pass("Image elementinin goruntulendigini dogrular");


        extentTest.info("Goruntuleme isleminin basarili oldugunu dogrular");
        testimonials.closeButton.click();
        extentTest.info("View sayfasini kapatir");
    }

    @Test(priority = 4)
    public void TC04(){
        extentTest = extentReports.createTest("US35_TC04", "Admin, gorus ve sorulari duzenleyebilmeli");

        ReusableMethods.bekle(3);
        testimonials.editButton.click();
        extentTest.info("Admin gorusleri duzenleyebilmek icin 'Edit' butonuna basar");
        ReusableMethods.bekle(2);

        Assert.assertTrue(testimonials.editText.isDisplayed());
        extentTest.pass("Edit sayfasinin goruntulendigini dogrular");

        testimonials.nameBox.clear();
        testimonials.nameBox.sendKeys("editName");

        testimonials.descriptionBox.clear();
        testimonials.descriptionBox.sendKeys("editDescription");
        extentTest.info("Eski degerleri temizleyip yeni degerleri girer");

        testimonials.saveButton.click();
        extentTest.info("'Save' butonuna basarak degisikleri kaydeder");

        Assert.assertTrue(testimonials.successText.isDisplayed());
        extentTest.pass("Degisikliklerin gerceklestigini dogrular");
    }

    @Test(priority = 5)
    public void TC05(){
        extentTest = extentReports.createTest("US35_TC05", "Admin, gorus ve sorulari silebilmeli");

        ReusableMethods.bekle(2);
        testimonials.deleteButton.click();
        extentTest.info("Admin gorusleri silebilmek icin 'Delete' butonuna basar");

        ReusableMethods.bekle(2);
        Assert.assertTrue(testimonials.deleteText.isDisplayed());
        extentTest.pass("'Delete' sayfasinin goruntulendigini dogrular");

        testimonials.deleteConfirm.click();
        extentTest.info("Gorusleri silmek istedigini onaylar");

        Assert.assertTrue(testimonials.deleteAlert.isDisplayed());
        extentTest.pass("Silme isleminin gerceklestigini dogrular");
        ReusableMethods.bekle(1);

        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");
    }


}
