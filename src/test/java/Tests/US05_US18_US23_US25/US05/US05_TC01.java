package Tests.US05_US18_US23_US25.US05;

import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US05_TC01 extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Login Testi","Kullanici anasayfadan login'e click yapabilmeli");
        LoginPage loginPage = new LoginPage();
        //Kullanıcı "https://qa.smartcardlink.com/" sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici smart card anasayfaya gider");
        //Sayfanin header kısmında bulunan 'Sign In' butonuna tıklar
        loginPage.signInButton.click();
        extentTest.info("Kullanici login'e click yapar");
        //Çikan login sayfasinin goruntulendigini dogrular
        Assert.assertTrue(loginPage.loginButton.isEnabled());
        extentTest.pass("Login butonuna click yapildigini test eder");
        //Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");





    }
}
