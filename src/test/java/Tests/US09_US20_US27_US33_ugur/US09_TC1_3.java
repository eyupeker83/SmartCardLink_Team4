package Tests.US09_US20_US27_US33_ugur;

import Pages.Admin.AdminUsersPage;
import Pages.Users.AccountSettingsPage;
import Pages.Users.LoginPage;
import Pages.Users.SignOutPage;
import Pages.Users.VcardsPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.Set;

public class US09_TC1_3 extends TestBaseRapor {

    @Test

    public void test01(){

        extentTest = extentReports.createTest("VcardDetail kayıt testi",
                "kullanıcı vcard'ı ilgili tüm bilgileri düzenleyebilmeli");

        //kullanıcı vcard'ı ilgili tüm bilgileri düzenleyebilmeli

        LoginPage loginPage = new LoginPage();
        AdminUsersPage adminUsersPage = new AdminUsersPage();
        SoftAssert softAssert = new SoftAssert();
        SignOutPage signOutPage = new SignOutPage();
        VcardsPage vcardsPage = new VcardsPage();
        Faker faker = new Faker();
        AccountSettingsPage accountSettingsPage = new AccountSettingsPage();

        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna unz472301@gmail.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurKullaniciMail"));
        //password kutusuna unz472301. şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurKullaniciPassword"));
        //Login butonuna tıklanır
        loginPage.loginButton.click();
        //VCards linkine tıklanır
        vcardsPage.vCardsTab.click();
        //ilk satırda isme tıklanır
        vcardsPage.lastCreatedVCardName.click();
        extentTest.info("kişisel bilgiler giriler");
        //Email kutusuna unz472301@gmail.com yazılır
        vcardsPage.email.sendKeys(ConfigReader.getProperty("ugurVcardMail"));
        //Phone kutusunda 532 yazılır
        vcardsPage.phone.sendKeys(ConfigReader.getProperty("ugurNo"));
        //Alternate Email kutusuna uzn472301@gmail.com yazılır
        vcardsPage.alternativeEmail.sendKeys(ConfigReader.getProperty("ugurVcardMail2"));
        //Alternate Phone kutusunda 542 yazılır
        vcardsPage.altenativePhone.sendKeys(ConfigReader.getProperty("ugurNo2"));
        //Location kutusuna Yozgat yazılır
        vcardsPage.location.sendKeys(ConfigReader.getProperty("ugurLocation"));
        //LocationURL kutusuna http://www.yozgatli.com yazılır
        vcardsPage.locationURL.sendKeys(ConfigReader.getProperty("ugurLocationURL"));
        //Date Of Birth kutusuna 01/01/1950 yazılır
        vcardsPage.dateOfBirth.sendKeys(ConfigReader.getProperty("ugurDate"));
        //Company kutusuna TRT yazılır
        vcardsPage.company.sendKeys("TRT");
        //Job Title kutusuna Turkucu yazılır
        vcardsPage.job.sendKeys("Turkucu");
        ReusableMethods.bekle(2);
        //save butonuna basılır
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();",vcardsPage.saveButonu);
        ReusableMethods.bekle(1);
        vcardsPage.saveButonu.click();
        ReusableMethods.bekle(3);
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(vcardsPage.saveTest));
        //"Basic Details updated successfully." yazısının görünür olduğu doğrulanır
        softAssert.assertTrue(vcardsPage.saveTest.isDisplayed());
        extentTest.pass("Basic Details updated successfully. doğrulanır");
        ReusableMethods.bekle(2);
        //Back butonuna basılır
        vcardsPage.backButon.click();
        ReusableMethods.bekle(1);
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.quitDriver();

    }

    @Test (dependsOnMethods = "test01")
    public  void test03(){

        extentTest = extentReports.createTest("Vcard sayfası fonksiyonları testi",
                "kullanıcının vcard kart sayfasındaki fonksiyonları aktif olmalı");
        //kullanıcının vcard kart sayfasındaki fonksiyonları aktif olmalı

        LoginPage loginPage = new LoginPage();
        AdminUsersPage adminUsersPage = new AdminUsersPage();
        SoftAssert softAssert = new SoftAssert();
        SignOutPage signOutPage = new SignOutPage();
        VcardsPage vcardsPage = new VcardsPage();

        //https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna unz472301@gmail.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurKullaniciMail"));
        //password kutusuna unz472301. şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurKullaniciPassword"));
        //Login butonuna tıklanır
        loginPage.loginButton.click();
        //VCards linkine tıklanır
        vcardsPage.vCardsTab.click();

        String WHD1 = Driver.getDriver().getWindowHandle();

        //İlk satırda PREVIEW URL linki tıklanır
        vcardsPage.previewURL.click();

        ReusableMethods.bekle(2);
        Set<String> WHDList = Driver.getDriver().getWindowHandles();
        String WHD2="";
        for (String each:WHDList
        ) {
            if (!each.equals(WHD1)){
                WHD2 = each;
            }
        }
        Driver.getDriver().switchTo().window(WHD2);

        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(vcardsPage.locateURLTest));

        //LocationURL simgesine tıklayınız
        vcardsPage.locateURLTest.click();

        String WHD3 ="";
        WHDList = Driver.getDriver().getWindowHandles();
        for (String each:WHDList
        ) {
            if (!each.equals(WHD1) && !each.equals(WHD2)){
                WHD3 = each;
            }
        }
        Driver.getDriver().switchTo().window(WHD3);
        ReusableMethods.bekle(2);

        //LocationURL simgesinin ilgili siteye gittigini doğrulayın
        softAssert.assertTrue(vcardsPage.WHD3Test.isDisplayed());
        extentTest.pass("LocationURL simgesi ile  ilgili siteye gittigi doğrulanır");
        Driver.getDriver().switchTo().window(WHD2);

        //üstüste kayıt probleminin önüne geçmek için burda kayıtlar silinir

        // Vcard details sayfasına gelin
        Driver.getDriver().switchTo().window(WHD1);
        //ilk satırda isme tıklayın
        vcardsPage.lastCreatedVCardName.click();
        extentTest.info("üstüste kayıt probleminin önüne geçmek için burda kayıtlar silinir");
        // bilgileri silin
        vcardsPage.email.clear();
        vcardsPage.phone.clear();
        vcardsPage.alternativeEmail.clear();
        vcardsPage.altenativePhone.clear();
        vcardsPage.location.clear();
        vcardsPage.locationURL.clear();
        vcardsPage.dateOfBirth.clear();
        vcardsPage.company.clear();
        vcardsPage.job.clear();
        ReusableMethods.bekle(2);
        //save butonuna basılır
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();",vcardsPage.saveButonu);
        ReusableMethods.bekle(1);
        vcardsPage.saveButonu.click();
        ReusableMethods.bekle(3);
        // Sayfayı kapatın
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
