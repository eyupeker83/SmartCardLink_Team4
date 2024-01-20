package Tests.US09_US20_US27_US33_ugur;

import Pages.Admin.AdminAffiliationTransactionsPage;
import Pages.Users.LoginPage;
import Pages.Users.SignOutPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US27 extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("ortaklık işlemleri bölümü testi",
                "Admin, ortaklık işlemleri bölümü bilgilerini görebilmeli");

        // Admin, ortaklık işlemleri bölümü bilgilerini
        // <kullanıcı,tutar,onay durumu, tarih, aksiyon> görebilmeli.

        LoginPage loginPage = new LoginPage();
        AdminAffiliationTransactionsPage adminAffiliationTransactionsPage = new AdminAffiliationTransactionsPage();
        SoftAssert softAssert = new SoftAssert();
        SignOutPage signOutPage = new SignOutPage();

        // https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna admin10@smartcardlink.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurAdminMail"));
        //password kutusuna 123123123 şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurAdminPassword"));
        //Login butonuna tıklayın
        loginPage.loginButton.click();
        //Ortaklık işlemleri bölümünü tıklayın
        adminAffiliationTransactionsPage.affiliationTransactionsLinki.click();
        //Kullanıcıların görüldüğünü doğrulayın
        softAssert.assertTrue(adminAffiliationTransactionsPage.name.isDisplayed());
        extentTest.pass("Kullanıcıların görüldüğü doğrulanır");
        //Miktar' ın görüldüğünü doğrulayın
        softAssert.assertTrue(adminAffiliationTransactionsPage.amountApprovastatus.isDisplayed());
        extentTest.pass("Miktar'ın görüldüğü doğrulanır");
        //Onay durumunun görüldüğünü doğrulayın
        softAssert.assertTrue(adminAffiliationTransactionsPage.amountApprovastatus.isDisplayed());
        extentTest.pass("Onay durumu görüldüğü doğrulanır");
        //Tarih'in görüldüğünü doğrulayın
        softAssert.assertTrue(adminAffiliationTransactionsPage.date.isDisplayed());
        extentTest.pass("Tarih görüldüğü doğrulanır");
        //Aksiyon durumunun görüntülendiğini doğrulayın
        softAssert.assertTrue(adminAffiliationTransactionsPage.action.isDisplayed());
        extentTest.pass("Aksiyon simgesi görüldüğü doğrulanır");
        //çıkış yapın
        signOutPage.usersButton.click();
        signOutPage.signOutButton2.click();
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
