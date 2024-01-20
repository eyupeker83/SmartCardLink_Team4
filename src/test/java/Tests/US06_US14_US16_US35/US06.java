package Tests.US06_US14_US16_US35;

import Pages.Users.DashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US06 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void TC01(){
        extentTest = extentReports.createTest("US06_TC01", "Kullanici Sign In butonuna tikladiginda login sayfasina ulasabilmeli");

        Driver.getDriver().get(ConfigReader.getProperty("URL"));
        extentTest.info("Kullanici anasayfaya gider");

        homePage.signInButton.click();
        extentTest.info("Sign In butonuna tiklar");

        Assert.assertTrue(loginPage.loginButton.isDisplayed());
        extentTest.pass("Login sayfasinin goruntulendigini dogrular");

    }

    @Test(dependsOnMethods = "TC01")
    public void TC02(){
        extentTest = extentReports.createTest("US06_TC02", "Kullanici gecersiz e-mail ve sifre ile giris yapamamali");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("gecersizEmail"));
        extentTest.info("Kullanci 'Email' kutusuna gecersiz e-mail adresi girer");

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("gecersizPassword"));
        extentTest.info("Kullanici 'Password' kutusuna gecersiz password degeri girer");

        loginPage.loginButton.click();
        extentTest.info("'Login' butonuna tiklar");

        ReusableMethods.waitForVisibility(loginPage.failedLoginText,3);
        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.pass("'Basarisiz giris' yapildigini dogrular");

    }

    @Test(dependsOnMethods = "TC01")
    public void TC03(){
        extentTest = extentReports.createTest("US06_TC03", "Kullanici gecersiz e-mail ve gecerli sifre ile giris yapamamali");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("gecersizEmail"));
        extentTest.info("Kullanci 'Email' kutusuna gecersiz e-mail adresi girer");

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        extentTest.info("Kullanici 'Password' kutusuna gecerli bir password degeri girer");

        loginPage.loginButton.click();
        extentTest.info("'Login' butonuna tiklar");

        ReusableMethods.waitForVisibility(loginPage.failedLoginText,3);
        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.pass("'Basarisiz giris' yapildigini dogrular");

    }

    @Test(dependsOnMethods = "TC01")
    public void TC04(){
        extentTest = extentReports.createTest("US06_TC04", "Kullanici gecerli e-mail ve gecersiz sifre ile giris yapamamali");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        extentTest.info("Kullanci 'Email' kutusuna gecerli bir e-mail adresi girer");

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("gecersizPassword"));
        extentTest.info("Kullanici 'Password' kutusuna gecersiz password degeri girer");

        loginPage.loginButton.click();
        extentTest.info("'Login' butonuna tiklar");

        ReusableMethods.waitForVisibility(loginPage.failedLoginText,3);
        Assert.assertTrue(loginPage.failedLoginText.isDisplayed());
        extentTest.pass("'Basarisiz giris' yapildigini dogrular");

    }

    @Test(dependsOnMethods = "TC01")
    public void TC05(){
        DashboardPage dashboardPage = new DashboardPage();
        extentTest = extentReports.createTest("US06_TC05", "Kullanici gecerli e-mail ve sifre ile giris yapabilmeli");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        extentTest.info("Kullanci 'Email' kutusuna gecerli bir e-mail adresi girer");

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        extentTest.info("Kullanici 'Password' kutusuna gecerli bir password degeri girer");

        loginPage.loginButton.click();
        extentTest.info("'Login' butonuna tiklar");

        Assert.assertTrue(dashboardPage.profileImage.isDisplayed());
        extentTest.pass("'Basarili giris' yapildigini dogrular");

        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");

    }



}
