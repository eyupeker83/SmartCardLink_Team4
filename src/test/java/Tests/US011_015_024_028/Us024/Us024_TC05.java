package Tests.US011_015_024_028.Us024;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminSubscribedUserPlansPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us024_TC05 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    AdminSubscribedUserPlansPage adminSubscribedUserPlansPage;

    @Test
    public void subscriptedDateChange() {

        extentTest = extentReports.createTest("planDetailDisplay Testi", "Admin kullanıcıların plan detaylarını görüntüleyebilmesi.");

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
        //açılan sayfada action sütunundan edit ikonuna tıklayınız.

        adminSubscribedUserPlansPage = new AdminSubscribedUserPlansPage();
        adminSubscribedUserPlansPage.tableEditIcon.click();
        extentTest.info("Üyelik bitiş tarihi değişikliği için edit icona tıklanır.");
        String expectedEndDate = adminSubscribedUserPlansPage.tableEndDate.getText();
        //Edit Subscription Plan pop-up dan tarih girilerek save butuna tıklanır.
        ReusableMethods.bekle(1);
        adminSubscribedUserPlansPage.id.click();
        ReusableMethods.bekle(2);
        adminSubscribedUserPlansPage.date.click();
        ReusableMethods.bekle(2);

        //Admin kullanıcıların üyelik bitiş tarihini değiştirebildiği dogrulanır.

        adminSubscribedUserPlansPage.saveButton.click();
        ReusableMethods.bekle(5);
        String actualEndDate = adminSubscribedUserPlansPage.tableEndDate.getText();

        System.out.println(expectedEndDate);
        System.out.println(actualEndDate);
        Assert.assertFalse(expectedEndDate.equals(actualEndDate));
        extentTest.pass("Admin kullanıcıların üyelik bitiş tarihini değiştirebildiği dogrulanır.");
        //Browser kapatılır.
        Driver.closeDriver();
    }
}
