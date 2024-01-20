
package Tests.US011_015_024_028.Us011;


import Pages.Users.DashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import Pages.Users.VirtualBackGroundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us011_TC01 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    VirtualBackGroundsPage virtualBackGroundsPage;

    @Test
    public void vCardBackGroundSelection() {

        extentTest = extentReports.createTest("vCardBackGroundSelection Testi", "VirtualBackGround sayfasindan arka plan seçimi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına kayıtlı kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına kayıtlı kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");

        // virtual-backgrounds linkine tıklanır.

        dashboardPage = new DashboardPage();
        dashboardPage.virtualBackgrounds.click();
        extentTest.info("Dashboard sayfasında virtual back ground linkine tıklanır.");

        //virtual-backgrounds sayfasında seçimi yapılan kart arka planına tıklanır

        virtualBackGroundsPage = new VirtualBackGroundsPage();
        virtualBackGroundsPage.backGroundsImg01.click();
        extentTest.info("Virtual back ground ekranından seçimi yapılan karta tıklanır.");
        ReusableMethods.bekle(1);
        //Kart arka plan seçiminin yapılabildiği dogrulanır.

        String expectedUrl = ConfigReader.getProperty("addVirtualBackgroundPageLink");
        String actualURL = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualURL);
        extentTest.pass("Arka plan seçiminin yapılabildiği yönlendirilen sayfa url ile doğrulanır.");

        //Browser kapatılır.

        Driver.closeDriver();
    }
}
