package Tests.US08_US21_US29_US31.US21;

import Pages.Admin.AdminVcardsPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

import static org.testng.Assert.*;

public class US21 extends TestBaseRapor {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminVcardsPage adminVcardsPage = new AdminVcardsPage();
    Actions actions = new Actions(Driver.getDriver());
    String actualUrl;

    @Test
    public void test01() {
        extentTest = extentReports.createTest("vCards Testi", "Kullanici admin olarak vCards sayfalarina ulasabilmeli");
        // https://qa.smartcardlink.com adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart Card Link anasayfaya gider");

        // sign in kutusuna tıklanır.
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

        // VCards sekmesine tıklanır
        adminVcardsPage.vCardsTab.click();
        extentTest.info("vCards kategorisine tiklar");

        // VCards sayfasına gidildiği test edilir
        String expectedUrlContent = "vcards";
        actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrlContent));
        extentTest.pass("vCards sayfasina gidildigini test eder");

        // ******************************************************

        //en ustteki kartin url'ine tiklanir ve gidildigi test edilir
        String ilkSayfaWhd = Driver.getDriver().getWindowHandle();
        String cardName = adminVcardsPage.lastCreatedVCardName.getText();
        extentTest.info("en ustteki kartın url'ine tiklar");

        adminVcardsPage.lastVCardPreviewUrlElement.click();

        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        String ikinciSayfaWhd = "";
        for (String each : whdSeti
        ) {
            if (!each.equals(ilkSayfaWhd)) {
                ikinciSayfaWhd = each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaWhd);

        String currentPageTitle = Driver.getDriver().getTitle();
        assertTrue(currentPageTitle.contains(cardName));
        extentTest.pass("url'e gidildigini test eder");

        //onceki sayfaya geri donulur
        Driver.getDriver().switchTo().window(ilkSayfaWhd);
        extentTest.info("Onceki sayfaya geri döner");
        // ******************************************************

        // kartlar tablosunun görünürlüğü test edilir
        assertTrue(adminVcardsPage.userVCardsTable.isDisplayed());
        extentTest.pass("kartlar tablosunun gorunurlugunu test eder");

        // toplam vCards sayısının görüntülendiği test edilir
        actions.scrollToElement(adminVcardsPage.numberOfVCardsResult);
        assertTrue(adminVcardsPage.numberOfVCardsResult.isDisplayed());
        ReusableMethods.bekle(2);
        extentTest.pass("toplam vCards sayisinin goruntulendigini test eder");

        // en üstteki kartın istatistik butonuna basılır
        adminVcardsPage.firstCardStatsButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("en ustteki kartin istatistik butonuna tiklar");

        //Vcard Analytic sayfasinin acildigi test edilir
        expectedUrlContent = "analytics";
        actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrlContent));
        extentTest.pass("vCard Analytic sayfasinin acildigini test eder");

        Driver.closeDriver();

    }
}