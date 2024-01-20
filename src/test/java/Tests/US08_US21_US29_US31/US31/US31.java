package Tests.US08_US21_US29_US31.US31;

import Pages.Admin.AdminLanguagesPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import static org.testng.Assert.assertTrue;

public class US31 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminLanguagesPage adminLanguagesPage = new AdminLanguagesPage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Language Testi", "Kullanici admin olarak dil sayisini goruntuleyebilmeli");

        //https://qa.smartcardlink.com adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart Card Link anasayfaya gider");

        //sign in kutusuna tıklanır.
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna basar");

        //email kutusuna, verilen admin email'i girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email kutusuna admin email'ini girer");

        //password kutusuna, verilen admin password'u girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna admin sifresini girer");

        //Login butonuna tıklanır
        loginPage.loginButton.click();
        extentTest.info("Login butonuna tiklar");

        //Languages sekmesine tıklanır
        adminLanguagesPage.languagesTab.click();
        extentTest.info("Languages sekmesine tiklar");

        //sitede kullanılan dillerin sayısının görünürlüğü test edilir
        assertTrue(adminLanguagesPage.numberOfLanguagesResult.isDisplayed());
        extentTest.pass("sitede kullanilan dil sayisinin gorunurlugunu test eder");

        //Driver kapatılır
        Driver.closeDriver();
    }
}