package Tests.US04_US10_US22_US34.US022;

import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US022 extends TestBaseRapor {
    @Test
        public void Us022(){
        extentTest = extentReports.createTest("Vcard Testi","Admin kullanicisiyla girdikten sonra Vcard Template lerin goruntulendigini dogrula");
        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
        //https://www.qa.smartcardlink.com/ sayfasına giderek sol üstte yer alan sign in butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        homePage.signInButton.click();
        extentTest.info("Anasayfada sign in butonuna tiklar");

        //Username ve password alanlarına Admin kullanıcısıyla gir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("admin12username"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin12Password"));
        loginPage.loginButton.click();

        extentTest.info("Admin bilgilerini girdikten sonra login butonuna tiklar.");

        //sol tarafta yer alan Vcard Templates butonuna tıklayarak ilgili sayfada oldugunu dogrula
        String actualTitle =Driver.getDriver().getTitle();
        String expectedTitle="Templates";


        Assert.assertTrue(actualTitle.contains(expectedTitle));
        extentTest.pass("Template sayfasinin gorundugunu test eder.");
        //template sayısını görüntüle

    Driver.closeDriver();
    }
}
