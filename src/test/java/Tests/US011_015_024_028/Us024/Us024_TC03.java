package Tests.US011_015_024_028.Us024;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminSubscribedUserPlansPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us024_TC03 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    AdminSubscribedUserPlansPage adminSubscribedUserPlansPage;

    @Test
    public void subscriptedDateDisplay(){

        extentTest = extentReports.createTest("subscriptedDateDisplay Testi", "Admin kullanıcıların üyelik başlangıç ve bitiş tarihlerini görüntüleyebilmesi.");

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

        //subscribed user plans linkine tıklayınız

        adminDashboardPage = new AdminDashboardPage();
        adminDashboardPage.subscribedUserPlansLink.click();
        extentTest.info("Subscribed User Plans linkine click yapılır.");
        ReusableMethods.bekle(1);

        //Admin kullanıcıların üyelik başlangıç ve bitiş tarihini görüntülediği doğrulanır.

        adminSubscribedUserPlansPage = new AdminSubscribedUserPlansPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(adminSubscribedUserPlansPage.tableStartDate.isDisplayed(),"Stard Date görüntülenemiyor.");
        softAssert.assertTrue(adminSubscribedUserPlansPage.tableEndDate.isDisplayed(),"End Date görüntülenemiyor.");
        softAssert.assertAll();

        //Browser kapatılır.
        Driver.closeDriver();
    }
}
