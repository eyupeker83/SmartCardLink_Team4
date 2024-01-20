package Tests.US06_US14_US16_US35;

import Pages.Users.AppointmentsPage;
import Pages.Users.LoginPage;
import Pages.Users.VcardsPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class US16 extends TestBaseRapor {

    AppointmentsPage appointmentsPage = new AppointmentsPage();
    LoginPage loginPage = new LoginPage();
    VcardsPage vcardsPage = new VcardsPage();
    static String whd1;

    @BeforeClass
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        loginPage.signInButton.click();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("appointmentEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("appointmentPassword"));
        loginPage.loginButton.click();
    }

    @Test
    public void TC01(){
        extentTest = extentReports.createTest("US16_TC01", "Kullanici VCards sayfasinda URL uzerinden randevu olusturabilmeli");

        extentTest.info("Kullanici anasayfaya gider");
        extentTest.info("Sign In butonuna basar");
        extentTest.info("Login sayfasina gecerli kullanici degerleriyle giris yapar");

        vcardsPage.vCardsTab.click();
        extentTest.info("Kullanici VCards sayfasina gider");
        whd1 = Driver.getDriver().getWindowHandle();

        ReusableMethods.bekle(1);
        vcardsPage.cardURL.click();
        extentTest.info("'Preview URL' sutunu altinda bulanan URL linkine tiklar");

        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        String whd2 = "";
        for (String each: whdSeti
        ) {
            if (!each.equals(whd1)){
                whd2 = each;
            }
        }
        Driver.getDriver().switchTo().window(whd2);

        appointmentsPage.getInTouch.click();
        extentTest.info("Randevu olusturmak icin 'Get in Touch' butonuna basar");

        Assert.assertTrue(appointmentsPage.makeAppText.isDisplayed());
        extentTest.pass("Randevu olusturabilecegi sayfanin gorunur oldugunu dogrular");

        appointmentsPage.dateBoard.click();

        for (WebElement each: appointmentsPage.dayContainer
        ) {
            if (each.isEnabled()){
                each.click();
                break;
            }
        }

        extentTest.info("Randevu olusturacagi tarihi secer");

        Assert.assertTrue(appointmentsPage.hourBoard.isDisplayed());
        extentTest.pass("Randevu saatlerinin goruntulendigini dogrular");

        appointmentsPage.hourBoard.click();
        extentTest.info("Randevu saatini secer");

        appointmentsPage.makeAppointmentButton.click();
        extentTest.info("'Make Appointment' butonuna basar");
        ReusableMethods.bekle(2);

        Assert.assertTrue(appointmentsPage.makeAppNewPage.isDisplayed());
        extentTest.pass("Randevu kayit sayfasinin acildigini dogrular");

        appointmentsPage.nameTextBox.sendKeys(ConfigReader.getProperty("appointmentName"));
        appointmentsPage.emailTextBox.sendKeys(ConfigReader.getProperty("appointmentEmail"));
        extentTest.info("Randevu kayit sayfasina gecerli bilgileri girer");

        appointmentsPage.saveButton.click();
        extentTest.info("'Save' butonuna basar ve randevu kaydini olusturur");

        ReusableMethods.waitForVisibility(appointmentsPage.alertText,3);
        Assert.assertTrue(appointmentsPage.alertText.isDisplayed());
        extentTest.pass("Randevu olusturuldugunu dogrular");
        ReusableMethods.bekle(1);

    }

    @Test
    public void TC02(){
        extentTest = extentReports.createTest("US16_TC02", "Kullanici Edit VCard sayfasindan randevu olusturabilmeli");
        Driver.getDriver().switchTo().window(whd1);
        extentTest.info("Kullanici VCards sayfasina geri doner");
        ReusableMethods.bekle(1);

        vcardsPage.editButton.click();
        extentTest.info("Randevu olusturmak istedigi kaydin 'Edit' butonuna tiklar");
        ReusableMethods.bekle(1);

        appointmentsPage.editAppButton.click();
        extentTest.info("Appointments sayfasini goruntuler");

        for (WebElement each: appointmentsPage.checkbox
             ) {
            each.click();
        }
        ReusableMethods.bekle(1);
        extentTest.info("Randevu gunlerini olusturur");

        appointmentsPage.editAppSaveButton.click();
        extentTest.info("Olusturdugu randevulari kaydeder");

        ReusableMethods.bekle(1);
        Assert.assertTrue(appointmentsPage.editAppAlert.isDisplayed());
        extentTest.pass("Randevularin olusturuldugunu dogrular");
    }

    @Test
    public void TC03() {
        extentTest = extentReports.createTest("US06_TC03", "Kullanici randevularim sayfasına erisebilmeli");

        appointmentsPage.appointmentsButton.click();
        extentTest.info("Kullanici randevularim sayfasina gider");
        ReusableMethods.bekle(2);

        Assert.assertTrue(appointmentsPage.headerText.isDisplayed());
        extentTest.pass("Randevularim sayfasina erisebildigini dogrular");

    }

    @Test
    public void TC04(){
        extentTest = extentReports.createTest("US06_TC04", "Kullanici olusturulan randevulari goruntuleyebilmeli");

        boolean flag = true;

            if (appointmentsPage.resultNum() < 1){
                flag = false;
            }
        extentTest.info("Kullanici randevu tablosundaki kayitlari kontrol eder");

        Assert.assertTrue(flag);
        extentTest.pass("Olusturulan randevularin listelendigini dogrular");

    }

    @AfterClass
    public static void teardown(){
        Driver.getDriver().quit();
        extentTest.info("Acilan tum pencereleri kapatir");
    }
}
