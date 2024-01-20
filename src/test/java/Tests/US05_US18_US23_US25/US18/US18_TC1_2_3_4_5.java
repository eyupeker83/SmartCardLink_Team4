package Tests.US05_US18_US23_US25.US18;

import Pages.Admin.AdminDashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US18_TC1_2_3_4_5 extends TestBaseRapor {

    static HomePage homePage = new HomePage();
    static LoginPage loginPage = new LoginPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
    @Test
    public void testCase01(){

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart card anasayfaya gider");
        homePage.signInButton.click();
        extentTest.info("Admin login'e click yapar");
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Admin email girisi yapar");
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Admin password girisi yapar");
        loginPage.loginButton.click();
        extentTest.info("Admin giris yapar");
        Assert.assertTrue(adminDashboardPage.usersButton.isDisplayed());
        extentTest.pass("Admin girisi yapildigini test eder");


    }
    @Test(dependsOnMethods = "testCase01")
    public void testCase02(){

        //Aktif kullanıcı ve aktif olmayan kullanıcıların sayısını raporlayan kartların görüntülendiğini doğrular
        extentTest = extentReports.createTest("Active_Inactice Users Testi","Admin users kartlari goruntuleyebilmeli");
        Assert.assertTrue(adminDashboardPage.activeusers.isDisplayed());
        extentTest.pass("Admin active users kartini goruntuler");
        Assert.assertTrue(adminDashboardPage.deActiveUsers.isDisplayed());
        extentTest.pass("Admin inactive users kartini goruntuler");

    }
    @Test(dependsOnMethods = "testCase01")
    public void testCase03(){
        extentTest = extentReports.createTest("Active Vcards Testi","Admin vcardlari goruntuleyebilir");
        //Admin dashboard body kısmında bulunan aktif Vcard sayısını raporlayan kartların görüntülendiğini doğrular
        Assert.assertTrue(adminDashboardPage.activeVcard.isDisplayed());
        extentTest.pass("Admin active vcardlari goruntuler");
        //Admin dashboard  aktif olmayan Vcard sayısını raporlayan kartların görüntülendiğini doğrular
        Assert.assertTrue(adminDashboardPage.deActiveVcards.isDisplayed());
        extentTest.pass("Admin inactive vcardlarin goruntulendigini test eder");


    }
    @Test(dependsOnMethods = "testCase01")
    public void testCase04(){
        extentTest = extentReports.createTest("Tablo ve Grafik Testi Testi","Admin tablo ve grafikleri goruntuleyebilmelidir");
        //Plans by Users başlıklı tablonun görüntülendiğini doğrular
        Assert.assertTrue(adminDashboardPage.plansbyUsers.isDisplayed());
        extentTest.pass("Admin kullanici plan oran tablosunun goruntulendigini test eder");
        //Income başlıklı grafiğin görüntülendiğini doğrular
        Assert.assertTrue(adminDashboardPage.gelirGrafigi.isDisplayed());
        extentTest.pass("Admin Income grafiğinin goruntulendigini test eder");


    }
    @Test(dependsOnMethods = "testCase01")
    public void testCase05(){
        extentTest = extentReports.createTest("Kullanici Kayit Testi","Admin kullanici kayitlarini goruntuleyebilmelidir");
        ReusableMethods.bekle(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        extentTest.info("Sayfanin sonuna iner");
        ReusableMethods.bekle(2);
        for (WebElement each:adminDashboardPage.nameData
             ) {
            ReusableMethods.bekle(1);
            Assert.assertTrue(each.isDisplayed());
            ReusableMethods.bekle(2);

        }
        extentTest.pass("Admin kayitli isim bilgilerinin gorundugunu test eder");
        Driver.closeDriver();
    }

}


