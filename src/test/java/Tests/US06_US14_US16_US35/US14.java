package Tests.US06_US14_US16_US35;

import Pages.Users.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static utilities.ConfigReader.getProperty;

public class US14 extends TestBaseRapor {
    static HomePage homePage = new HomePage();
    static LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    ChangePasswordPage changePasswordPage = new ChangePasswordPage();
    ChangeLanguagePage changeLanguagePage = new ChangeLanguagePage();
    SignOutPage signOutPage = new SignOutPage();


    @BeforeClass
    public static void setup(){
        Driver.getDriver().get(getProperty("URL"));
        homePage.signInButton.click();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        loginPage.loginButton.click();
    }

    @Test
    public void TC01(){
        extentTest = extentReports.createTest("US14_TC01", "Kullanici istenen sayfaya giris yaptiktan sonra sifresini degistirebilmeli");
        extentTest.info("Kullanici anasayfaya gider");

        Assert.assertTrue(dashboardPage.dashboardText.isDisplayed());
        extentTest.pass("Login sayfasina gecerli bilgileri girerek 'Dashboard' sayfasinin goruntulendigini dogrular");

        changePasswordPage.usersButton.click();
        extentTest.info("Users dropdown menuyu goruntuler");
        changePasswordPage.changePasswordButton.click();
        extentTest.info("Sifre degisikligi icin 'Change Password' butonuna tiklar");

        changePasswordPage.currentPasswordBox.sendKeys(ConfigReader.getProperty("gecerliPassword"));
        changePasswordPage.newPasswordBox.sendKeys(ConfigReader.getProperty("newPassword"));
        changePasswordPage.confirmPassword.sendKeys(ConfigReader.getProperty("newPassword"));
        changePasswordPage.saveButton.click();
        extentTest.info("Sifre degisikligi icin iligli alanlari doldurur");
        ReusableMethods.bekle(1);

        ReusableMethods.waitForVisibility(changePasswordPage.successAlert,3);
        Assert.assertTrue(changePasswordPage.successAlert.getText().contains("Success"));
        extentTest.pass("Sifre degisikliginin basarili oldugunu dogrular");
    }

    @Test
    public void TC02(){
        extentTest = extentReports.createTest("US14_TC02","Kullanici sayfanin dil tercihini degistirebilmeli");
        ReusableMethods.bekle(2);

        changeLanguagePage.alertCloseButton.click();
        changeLanguagePage.usersButton.click();
        extentTest.info("Kullanici 'Users dropdown' menuyu goruntuler");
        changeLanguagePage.changeLanguageButton.click();
        extentTest.info("Dil degisikligi icin 'Change Language' butonuna tiklar");
        ReusableMethods.bekle(1);

        changeLanguagePage.languageDropdown.click();
        extentTest.info("Dil tercihlerinin oldugu menuye gider");

        boolean flag = true;
        for (int i = 0; i < changeLanguagePage.languageList.size() ; i++) {
            changeLanguagePage.languageList.get(i).click();
            changeLanguagePage.saveButton.click();
            ReusableMethods.waitForVisibility(changeLanguagePage.successAlert,3);
            if (!changeLanguagePage.successAlert.getText().contains("Success")){
                flag = false;
                break;
            }
            ReusableMethods.bekle(2);
            changeLanguagePage.TC_02();
        }
        Assert.assertTrue(flag);
        extentTest.pass("Sayfanin dil seceneginin degistirildigini dogrular");

    }

    @Test
    public void TC03(){
        extentTest = extentReports.createTest("US14_TC03", "Kullanici cikis butonuna tikladiginda oturum kapanmali");

        Driver.getDriver().navigate().refresh();
        signOutPage.usersButton.click();
        extentTest.info("Kullanici 'Users dropdown' menuyu goruntuler");

        ReusableMethods.bekle(2);
        signOutPage.signOutButton.click();
        extentTest.info("Sign Out butonuna tiklar");

        ReusableMethods.bekle(2);
        Assert.assertTrue(signOutPage.loginButton.isDisplayed());
        extentTest.pass("Kullanici sayfasindan cikis yapildigini dogrular");
    }

    @AfterClass
    public static void teardown(){
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");
    }


}
