package Tests.US011_015_024_028.Us024;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminPlansPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us024_TC02 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    AdminPlansPage adminPlansPage;
    AdminDashboardPage adminDashboardPage;

    @Test
    public void adminUsersPlanDisplay(){

        extentTest = extentReports.createTest("adminUsersPlanDisplay Testi", "Admin kullanıcıların planları görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına admin kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına admin kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");
        //Plans linkine tıklayınız.

        adminDashboardPage = new AdminDashboardPage();
        adminDashboardPage.plansLink.click();
        extentTest.info("Plans linke click yapılır.");
        ReusableMethods.bekle(1);

        //Admin kullanıcılarının planları görüntüleyebildiği doğrulanır.

        adminPlansPage = new AdminPlansPage();
        Assert.assertTrue(adminPlansPage.userFirst.isDisplayed());
        extentTest.pass("Admin kullanıcıların planları görüntüleyebildiği dogrulanır.");
        //Browser kapatılır.
        Driver.closeDriver();
    }
}
