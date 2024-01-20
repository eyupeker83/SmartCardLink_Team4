package Tests.US05_US18_US23_US25.US05;

import Pages.Users.LoginPage;
import Pages.Users.NewAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US05_TC02 extends TestBaseRapor {


    @Test
    public void test01(){
        extentTest = extentReports.createTest("Create an Account Testi","Kullanici create an account butonuna click yapabilmeli");
        LoginPage loginPage = new LoginPage();
        NewAccountPage newAccountPage = new NewAccountPage();

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici smart card anasayfaya gider");
        loginPage.signInButton.click();
        extentTest.info("Kullanici login'e click yapar");
        newAccountPage.createAnAccountButonu.click();
        extentTest.info("Kullanici create an account butonuna click yapar");
        Assert.assertTrue(newAccountPage.createAccountyazisi.isDisplayed());
        extentTest.pass("Create an account butonuna click yapildigini test eder");
        Driver.getDriver();
        extentTest.info("Sayfayi kapatir");

    }

}
