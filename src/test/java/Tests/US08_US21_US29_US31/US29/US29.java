package Tests.US08_US21_US29_US31.US29;

import Pages.Admin.AdminCurrenciesPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.Assert.*;

public class US29 extends TestBaseRapor {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminCurrenciesPage adminCurrenciesPage = new AdminCurrenciesPage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Currencies Testi", "Kullanici admin olarak para birimlerini goruntuleyebilmeli");

        // https://qa.smartcardlink.com adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart Card Link anasayfaya gider");

        // sign in butonuna tıklanır.
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna basar");

        // email kutusuna, verilen admin email'i girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email kutusuna admin email'ini girer");

        // password kutusuna, verilen admin password'u girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna admin sifresini girer");

        // Login butonuna tıklanır
        loginPage.loginButton.click();
        extentTest.info("Login butonuna tiklar");

        // Currencies sekmesine tıklanır.
        adminCurrenciesPage.currenciesTab.click();
        extentTest.info("Currencies kategorisine tiklar");

        // para birimleri sayısının görünürlüğü test edilir
        assertTrue(adminCurrenciesPage.numberofCurrenciesResult.isDisplayed());
        extentTest.pass("Para birimleri sayisinin gorunurlugunu test eder");

        Driver.closeDriver();

    }
}