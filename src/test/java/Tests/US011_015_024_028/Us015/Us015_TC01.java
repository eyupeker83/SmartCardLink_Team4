package Tests.US011_015_024_028.Us015;

import Pages.Users.DashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class Us015_TC01 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void planDisplay() {

        extentTest = extentReports.createTest("planDisplay Testi", "Anasayfa pricing alanında planların görüntülenmesi");

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

        //Açılan sayfadan smartcardlink linkine tıklanarak anasayfaya geçiş yapılır.

        String handle01 = Driver.getDriver().getWindowHandle();

        dashboardPage = new DashboardPage();
        dashboardPage.smartCardHomeLink.click();
        extentTest.info("Anasayfa geçiş linkine tıklanır.");

        String handle02 = "";
        Set<String> handleSet = Driver.getDriver().getWindowHandles();

        for (String each : handleSet) {

            if (!each.equals(handle01)) {

                handle02 = each;
            }
        }

        //menüden pricing linkine tıklanır.

        Driver.getDriver().switchTo().window(handle02);
        homePage.pricingMenuButton.click();
        extentTest.info("Menüden pricing linkine tıklanır.");
        ReusableMethods.bekle(2);

        //Abonelik planlarının görüntülendiği doğrulanır.

        Assert.assertTrue(homePage.planSlider.isDisplayed());
        extentTest.pass("Abonelik planlarının görüntülendiği doğrulanır.");

        //Browser kapatılır.

        Driver.getDriver().quit();

    }
}
