package Tests.US05_US18_US23_US25.US05;

import Pages.Users.LoginPage;
import Pages.Users.NewAccountPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.time.Duration;

public class US05_TC03 extends TestBaseRapor{

    @Test
    public void createAnAccountTesti(){
        extentTest = extentReports.createTest("Create an Account Testi","Kullanici yeni kayit yapabilmelidir");

        LoginPage loginPage = new LoginPage();
        NewAccountPage newAccountPage = new NewAccountPage();

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart card anasayfaya gider");
        loginPage.signInButton.click();
        extentTest.info("Kullanici login'e click yapar");

        Faker faker = new Faker();

        newAccountPage.createAnAccountButonu.click();
        extentTest.info("Kullanici create an account butonuna clik yapar");
        //    Kullanıcı first name kutusuna ismini yazar
        newAccountPage.firstnameButonu.sendKeys(faker.name().firstName());
        extentTest.info("FirstName butonuna isim girilir");
        //    Kullanıcı last name kutusuna soyismini yazar
        newAccountPage.lastnameButonu.sendKeys(faker.name().lastName());
        extentTest.info("LastName butonuna soyisim girilir");
        //    Kullanıcı Email kutusuna email adresini girer
        newAccountPage.emailButonu.sendKeys(faker.internet().emailAddress());
        extentTest.info("Email butonuna mail adresi girilir");
        //    Kullanıcı password kutusuna şifresini oluşturur
        newAccountPage.passwordButonu.sendKeys(ConfigReader.getProperty("creatAnAccountPassword"));
        extentTest.info("Password butonuna sifre girilir");
        //    Kullanıcı confirm password kutusuna oluşturduğu şifreyi doğrular
        newAccountPage.passwordOnayButonu.sendKeys(ConfigReader.getProperty("creatAnAccountPassword"));
        extentTest.info("Password onay butonuna sifre tekrar girilir");
        //    Term&Conditions checkboxına tıklar
        newAccountPage.checkboxButonu.click();
        extentTest.info("Term&Conditions checkbox'ina click yapilir");
        //    Submit butonuna basarak yeni hesap oluşturur
        newAccountPage.submitButonu.click();
        extentTest.info("Submit butonuna click yapilir");
        //    Kullanıcı yeni hesap oluşturduğunu doğrular
        Assert.assertTrue(newAccountPage.successText.isDisplayed());
        extentTest.pass("Kullanici yeni hesap olusturdugunu test eder");
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");







    }
}
