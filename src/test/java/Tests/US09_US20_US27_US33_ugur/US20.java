package Tests.US09_US20_US27_US33_ugur;

import Pages.Admin.AdminUsersPage;
import Pages.Users.LoginPage;
import Pages.Users.SignOutPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US20 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest = extentReports.createTest("abonelik planı görüntüleme testi",
                "Admin, kullanıcılar bölümünde kullanıcıların abonelik planını görüntüleyebilir");

        // Admin, kullanıcılar bölümünde kullanıcıların
        // abonelik planını görüntüleyebilir

        LoginPage loginPage = new LoginPage();
        AdminUsersPage adminUsersPage = new AdminUsersPage();
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
        //users bölümüne tıklanır
        adminUsersPage.users.click();
        //sayfanın görüntülendiğini test edin
        softAssert.assertTrue(adminUsersPage.page1.isDisplayed());
        extentTest.pass("sayfanın görüntülendiği test edildi");
        //çıkış yapın
        signOutPage.usersButton.click();
        ReusableMethods.bekle(1);
        signOutPage.signOutButton2.click();
        ReusableMethods.bekle(1);
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test
    public void test02(){

        extentTest = extentReports.createTest("hesaba girebilme testi",
                "Admin kullanıcılar bölümünde kullanıcı hesabına giriş yapıp admin hesabına dönüş yapabilmeli");

        // Admin kullanıcılar bölümünde kullanıcı hesabına
        // giriş yapıp admin hesabına dönüş yapabilmeli

        LoginPage loginPage = new LoginPage();
        AdminUsersPage adminUsersPage = new AdminUsersPage();
        SoftAssert softAssert = new SoftAssert();
        SignOutPage signOutPage = new SignOutPage();

        // https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna admin10@smartcardlink.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurAdminMail"));
        //password kutusuna 123123123 şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurAdminPassword"));
        //Login butonuna tıklayın
        loginPage.loginButton.click();
        //users bölümüne tıklanır
        adminUsersPage.users.click();
        //ilk kullanıcının edit simgesine tıklayın
        adminUsersPage.userfirstEdit.click();
        //kullanıcı sayfasına giriş yapıldıgını test edin
        softAssert.assertTrue(adminUsersPage.editFirstName.isDisplayed());
        extentTest.pass("kullanıcı sayfasına giriş yapıldıgı test edildi");
        //Back butonuna basın
        adminUsersPage.backButonu.click();
        //admin hesabına geri dönüldüğünü test edin
        ReusableMethods.bekle(1);
        softAssert.assertTrue(adminUsersPage.page1.isDisplayed());
        extentTest.pass("admin hesabına geri dönüldüğü test edildi");
        //çıkış yapın
        signOutPage.usersButton.click();
        ReusableMethods.bekle(1);
        signOutPage.signOutButton2.click();
        ReusableMethods.bekle(1);
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
