package Tests.US011_015_024_028.Us024;

import Pages.Admin.AdminUsersPage;
import Pages.Users.DashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us024_TC01 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    AdminUsersPage adminUsersPage;

    @Test
    public void adminUserNameDisplay(){

        extentTest = extentReports.createTest("adminUserNameDisplay Testi", "Admin kullanıcıların kullanıcı isimlerini görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına kayıtlı kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına kayıtlı kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");

        //Users linkine tıklanır.

        dashboardPage = new DashboardPage();
        adminUsersPage = new AdminUsersPage();
        adminUsersPage.users.click();
        extentTest.info("Users linkine click yapılır.");

        //Admin kullanıcıların kullanıcı isimlerini görüntülediği dogrulanır.

        Assert.assertTrue(adminUsersPage.userfirst.isDisplayed());
        extentTest.pass("Admin kullanıcıların users'ları görüntüleyebildiği dogrulanır.");
        //Browser kapatılır.
        Driver.closeDriver();
    }
}
