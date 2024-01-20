package Tests.US03_US13_US26;

import Pages.Admin.AdminAffiliateUsersPage;
import Pages.Users.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US26_TC01_TC02_TC03 extends TestBaseRapor {

    LoginPage loginPage;
    AdminAffiliateUsersPage adminAffiliateUsersPage;

    @Test
    public void Test01(){
        extentTest=extentReports.
                createTest("Admin Login Testi","Admin gecerli bilgilerle login olabilmelidir.");

        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci Smart Card Link sitesine gider.");

        //Sign In  butonuna tıklar.
        loginPage=new LoginPage();
        loginPage.signInButton.click();
        extentTest.info("Sign In  butonuna tıklar.");

        //Email kutusuna gecerli admin mail  adresini girer.
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail3"));
        extentTest.info("Email kutusuna kayitli mail adresini girer.");
        //Password kutusuna geçerli  şifreyi girer.
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password kutusuna kayıtlı sifreyi girer.");

        //Login butonuna tıklar.
        loginPage.loginButton.click();
        extentTest.info("Login butonuna tıklar.");

    }
     @Test(dependsOnMethods = "Test01")
    public void Test02(){
         extentTest=extentReports.
                 createTest("Affiliate Users Bolumu Goruntuleme Testi","Admin Affiliate Users bolum baslıklarını goruntuleyebilmelidir.");

        //Soldaki menuden Affiliate Users seçenegine tıklar.
         adminAffiliateUsersPage=new AdminAffiliateUsersPage();
         adminAffiliateUsersPage.affiliateUsersMenuSekme.click();
         extentTest.info("Soldaki menuden Affiliate Users seçenegine tıklar.");

         // Affiliate Users bölümünde Affiliated By  baslıgının  goruntulendigini dogrular.
         Assert.assertTrue(adminAffiliateUsersPage.affiliatedBySutunBaslik.isDisplayed());
         extentTest.pass("Affiliate Users bölümünde Affiliated By baslıgının goruntulendigini test eder.");

         //Affiliate Users bölümünde User baslıgının  goruntulendigini dogrular.
         Assert.assertTrue(adminAffiliateUsersPage.userSutunBaslik.isDisplayed());
         extentTest.pass("Affiliate Users bölümünde User baslıgının  goruntulendigini test eder.");

         // Affiliation Number baslıgının   goruntulendigini dogrular.
         Assert.assertTrue(adminAffiliateUsersPage.affiliatedAmountSutunBaslik.isDisplayed());
         extentTest.pass("Affiliate Users bölümünde Affiliation Number baslıgının goruntulendigini test eder.");

         // Date  basligininn  goruntulendigini dogrular.
         Assert.assertTrue(adminAffiliateUsersPage.dateSutunBaslik.isDisplayed());
         extentTest.pass("Affiliate Users bölümünde Date baslıgının  goruntulendigini test eder.");
     }

    @Test(dependsOnMethods = "Test01")
    public void Test03(){
        //Soldaki menuden Affiliate Users seçenegine tıklar.
        adminAffiliateUsersPage=new AdminAffiliateUsersPage();
        adminAffiliateUsersPage.affiliateUsersMenuSekme.click();
        extentTest.info("Soldaki menuden Affiliate Users seçenegine tıklar.");
        ReusableMethods.bekle(2);

        //Sayfada tum kayıtlari gorebilmek icin  sonuc sayısı gosteren dropdown menuden 50 yi secer
        Select select=new Select( adminAffiliateUsersPage.sayfaShowResultDropDown);
        select.selectByVisibleText("50");
        extentTest.info("Sayfada tum kayıtlari gorebilmek icin  sonuc sayısı gosteren dropdown menuden 50 yi secer.");


        //Affiliated By  baslıgı altında kayıtlı bilgilerin gorunebilir  oldugunu dogrular.
        ReusableMethods.bekle(2);
        for (WebElement each:adminAffiliateUsersPage.affiliatedByDataList
             ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("Affiliated By  baslıgı altında kayıtlı bilgilerin gorunebilir  oldugunu test eder.");
        System.out.println(adminAffiliateUsersPage.affiliatedByDataList.size());


        // User  baslıgı altında bilgilerin gorunebilir  oldugunu dogrular.
        ReusableMethods.bekle(2);

        for (WebElement each:adminAffiliateUsersPage.userDataList
        ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("User baslıgı altında kayıtlı bilgilerin gorunebilir  oldugunu test eder.");


        // Affiliation number  baslıgı altında bilgilerin gorunebilir  oldugunu dogrular.
        ReusableMethods.bekle(2);

        for (WebElement each:adminAffiliateUsersPage.affiliationAmountDataList
        ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("Affiliation number baslıgı altında kayıtlı bilgilerin gorunebilir  oldugunu test eder.");

        //Date baslıgı altında bilgilerin gorunebilir oldugunu dogrular

        ReusableMethods.bekle(2);

        for (WebElement each:adminAffiliateUsersPage.dateDataList
        ) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.pass("Date baslıgı altında kayıtlı bilgilerin gorunebilir  oldugunu test eder.");

        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir.");

    }
}
