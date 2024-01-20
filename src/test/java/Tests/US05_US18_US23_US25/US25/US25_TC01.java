package Tests.US05_US18_US23_US25.US25;

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

public class US25_TC01 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminPlansPage adminPlansPage = new AdminPlansPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    @Test
    public void adminUsersPlanDisplay() {

        extentTest = extentReports.createTest("Admin Users Plan Display Testi", "Admin kullanicilarıin planlari goruntuleyebilmesi.");
        // https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        //Sign in butonuna tıklayınız.
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");
        //Email textbox'ına kayıtlı kullanıcı email adresini giriniz.
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ina email adresi girilir.");
        ReusableMethods.bekle(1);
        //Password textbox'ına kayıtlı kullanıcı password'ünü giriniz.
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ina password girilir.");
        ReusableMethods.bekle(1);
        //Login butonuna basılır.
        loginPage.loginButton.click();
        extentTest.info("Login butonuna click yapilir.");
        //Plans linkine tıklayınız.
        adminDashboardPage.plansLink.click();
        extentTest.info("Plans linke click yapilir.");
        ReusableMethods.bekle(1);
        //Admin kullanıcılarının planları görüntüleyebildiği doğrulanır.
        Assert.assertTrue(adminPlansPage.userFirst.isDisplayed());
        extentTest.pass("Admin kullanicilarin planlari goruntuleyebildigini test eder");
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");

    }
}
