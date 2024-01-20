package Tests.US04_US10_US22_US34.US010;

import Pages.Users.DashboardPage;
import Pages.Users.EnquiriesPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


import java.security.Key;
import java.util.List;

public class US010 extends TestBaseRapor {

    @Test
    public void Us010(){
        extentTest = extentReports.createTest("Enquirires Testi","User login olduktan sonra enquiries e tıklayıp mesajları görüntüleyip silebilmeli");
        EnquiriesPage enquiriesPage =new EnquiriesPage();
        //önce https://qa.smartcardlink.com/eyupeker adresinden Inquiries i dolduralım.
        extentTest.info("mesaj göndermek icin mesaj formunun oldugu sayfaya gider.");

        Driver.getDriver().get(ConfigReader.getProperty("eyupSmartCard"));
        Faker faker= new Faker();
        extentTest.info("Faker class kullanarak formu doldurur");
        enquiriesPage.inquiriesName.sendKeys(faker.name().fullName());
        enquiriesPage.inquiriesEmail.sendKeys(faker.internet().emailAddress());
        enquiriesPage.inquiriesPhone.sendKeys("555555555");
        enquiriesPage.inquiriesMessage.sendKeys((faker.lorem().word()));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END);
        extentTest.info("Sayfanın sonuna gider");
        ReusableMethods.bekle(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();",enquiriesPage.sendMessage);
        extentTest.info("Send Message butonuna tiklar");




////////////////////////////////////////////////////////////////////////////////////

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        HomePage homePage=new HomePage();
        //Anasayfadaki sign in butonuna bas.
        homePage.signInButton.click();
        extentTest.info("Anasayfadaki sign in butonuna tiklar");
        //username ve password alanlarına geçerli kullanıcı adı ve şifre girerek Login butonuna bas.
        LoginPage loginPage =new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("eyupKayitliKullaniciEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("eyupKayitkiKullaniciSifre"));
        loginPage.loginButton.click();

        extentTest.info("Login sayfasindaki alanlari doldurarak login butonuna tiklar");

        //Sol taraftaki Enquiries butonuna bas ve açılan sayfadaki tablodaki göz işaretine bas
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.enquiriesLink.click();
        extentTest.info("Enquiries linkine tiklar");
        //gönderen bilgileri ve  mesajın görüntülendiğini doğrula

        enquiriesPage.vcardView.click();
        extentTest.info("Gonderilen mesajlarin icerigini goruntulemek icin goz iconuna tiklar");


        ReusableMethods.bekle(2);

        Assert.assertTrue(enquiriesPage.vcardTitle.isDisplayed());
        ReusableMethods.bekle(1);
        //açılan pencerede sağ üst kısımda yer alan X işaretine basarak pencereyi kapat
        enquiriesPage.vcardDetailsClose.click();

        //Çöp işaretine basarak gönderilen mesajı sil ve silindiğini doğrula.
        ReusableMethods.bekle(1);
        enquiriesPage.vcardDelete.click();
        enquiriesPage.deleteConfirm.click();
        enquiriesPage.deleted.click();
        extentTest.info("Gonderilen mesajlari silme islemini yapar");
        Assert.assertTrue(enquiriesPage.deleted.isDisplayed());
        extentTest.pass("mesajlarin silinebildigini test eder.");
        ReusableMethods.bekle(1);

        Driver.closeDriver();



    }
}
