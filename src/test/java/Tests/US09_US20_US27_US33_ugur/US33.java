package Tests.US09_US20_US27_US33_ugur;

import Pages.Admin.AdminAffiliationTransactionsPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import Pages.Users.SignOutPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class US33 extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest = extentReports.createTest("Title testi",
                "Admin, Başlık ve Alt Metni görebilmeli");

        // Admin, Başlık ve Alt Metni görebilmeli

        LoginPage loginPage = new LoginPage();
        SoftAssert softAssert = new SoftAssert();
        AdminAffiliationTransactionsPage adminAffiliationTransactionsPage = new AdminAffiliationTransactionsPage();
        SignOutPage signOutPage = new SignOutPage();
        HomePage homePage = new HomePage();

        // https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna admin10@smartcardlink.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurAdminMail"));
        //password kutusuna 123123123 şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurAdminPassword"));
        //Login butonuna tıklayın
        loginPage.loginButton.click();

        String WHD1 = Driver.getDriver().getWindowHandle();
        //Sitenin logosuna tıklayın
        adminAffiliationTransactionsPage.title.click();

        ReusableMethods.bekle(2);
        Set<String> WHDList = Driver.getDriver().getWindowHandles();
        String WHD2="";
        for (String each:WHDList
             ) {
            if (!each.equals(WHD1)){
                WHD2 = each;
            }
        }
        Driver.getDriver().switchTo().window(WHD2);
        ReusableMethods.bekle(2);
        extentTest.info("Driver pencereler arasında WH değerleri ile dolaştırılır");
        //Başlık ve alt yazısının görünür oldugunu test edin
        softAssert.assertTrue(adminAffiliationTransactionsPage.baslik.isDisplayed());
        extentTest.pass("Başlığın görünür oldugu test edilir");
        softAssert.assertTrue(adminAffiliationTransactionsPage.baslikYazi.isDisplayed());
        extentTest.pass("Başlık alt yazısının görünür oldugu test edilir");
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.quitDriver();


    }

    @Test
    public void test02(){

        extentTest = extentReports.createTest("Features testi",
                "Admin ,Features butonunu görebilmeli ve metinlerini görüntüleyebilmeli");
        // Admin ,Features butonunu görebilmeli ve metinlerini görüntüleyebilmeli

        LoginPage loginPage = new LoginPage();
        AdminAffiliationTransactionsPage adminAffiliationTransactionsPage = new AdminAffiliationTransactionsPage();
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage();
        SignOutPage signOutPage = new SignOutPage();

        ReusableMethods.bekle(2);
        // https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna admin10@smartcardlink.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurAdminMail"));
        //password kutusuna 123123123 şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurAdminPassword"));
        //Login butonuna tıklayın
        loginPage.loginButton.click();

        String WHD1 = Driver.getDriver().getWindowHandle();
        //Sitenin logosuna tıklayın
        adminAffiliationTransactionsPage.title.click();

        ReusableMethods.bekle(2);
        Set<String> WHDList = Driver.getDriver().getWindowHandles();
        String WHD2="";
        for (String each:WHDList
        ) {
            if (!each.equals(WHD1)){
                WHD2 = each;
            }
        }
        Driver.getDriver().switchTo().window(WHD2);
        ReusableMethods.bekle(2);
        extentTest.info("Driver pencereler arasında WH değerleri ile dolaştırılır");
        //Features butonunun görünür oldugunu test edin
        softAssert.assertTrue(homePage.featuresMenuButton.isDisplayed());
        extentTest.pass("Features butonunun görünür oldugu test edilir");
        //Features butonuna tıklayınız
        adminAffiliationTransactionsPage.featuresLink.click();
        //Metinlerin görünür oldugunu test edin
        softAssert.assertTrue(homePage.featuresBaslik.isDisplayed());
        extentTest.pass("Metinlerin görünür oldugunu test edin");
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.quitDriver();


    }

    @Test
    public void test03(){

        extentTest = extentReports.createTest("About as testi",
                "Admin, About as butonu ve metinlerini görüntüleyebilmeli");
        // Admin, About as butonu ve metinlerini görüntüleyebilmeli

        LoginPage loginPage = new LoginPage();
        AdminAffiliationTransactionsPage adminAffiliationTransactionsPage = new AdminAffiliationTransactionsPage();
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage();
        SignOutPage signOutPage = new SignOutPage();

        ReusableMethods.bekle(2);
        // https://qa.smartcardlink.com/ adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("sayfaya ve hesaba giriş yapılır");
        //Sign In butonuna tıklanır
        loginPage.signInButton.click();
        //email kutusuna admin10@smartcardlink.com maili girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("ugurAdminMail"));
        //password kutusuna 123123123 şifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("ugurAdminPassword"));
        //Login butonuna tıklayın
        loginPage.loginButton.click();

        String WHD1 = Driver.getDriver().getWindowHandle();
        //Sitenin logosuna tıklayın
        adminAffiliationTransactionsPage.title.click();

        ReusableMethods.bekle(2);
        Set<String> WHDList = Driver.getDriver().getWindowHandles();
        String WHD2="";
        for (String each:WHDList
        ) {
            if (!each.equals(WHD1)){
                WHD2 = each;
            }
        }
        Driver.getDriver().switchTo().window(WHD2);
        ReusableMethods.bekle(2);
        extentTest.info("Driver pencereler arasında WH değerleri ile dolaştırılır");
        //About as butonunun görünür oldugunu test edin
        softAssert.assertTrue(homePage.aboutMenuButton.isDisplayed());
        extentTest.pass("About as butonunun görünür oldugu test edilir");
        //About as butonuna tıklayınız
        homePage.aboutMenuButton.click();
        //Metinlerin görünür oldugunu test edin
        softAssert.assertTrue(homePage.aboutSmartCardBaslik.isDisplayed());
        extentTest.pass("Metinlerin görünür oldugu test edilir");
        //sayfayı kapatın
        softAssert.assertAll();
        Driver.quitDriver();

    }
}
