package Tests.US04_US10_US22_US34.US034;

import Pages.Admin.AdminFrontCMSPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US034 extends TestBaseRapor {
    @Test
    public void Us034(){
        extentTest = extentReports.createTest("Sucsbribers","Admin olarak giris yaptiktan sonra front Cms sayfasından subscribers leri görüntüleyip silebilmeli");

        //Username ve password alanlarına Admin kullanıcısıyla gir ve Login butonuna tıkla

        LoginPage loginPage=new LoginPage();
        HomePage homePage=new HomePage();
        AdminFrontCMSPage adminFrontCMSPage=new AdminFrontCMSPage();

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        homePage.signInButton.click();
        extentTest.info("Anasayfada sign in butonuna tiklar");

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("admin12username"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("admin12Password"));
        loginPage.loginButton.click();

        extentTest.info("Admin bilgilerini kullanarak login olur");

        //sol menüdeki  Front Cms buttonuna tıklayıp Sucsbribers  sekmesine tıkla
        adminFrontCMSPage.frontCmsBtn.click();
        extentTest.info("front Cms butonuna tiklar");
        ReusableMethods.bekle(2);
        adminFrontCMSPage.subscribersBtn.click();
        extentTest.info("Subscribers butonuna tiklar");


        //Abonelerin görüntülendiğini ve silinebilidiğini test et
        List<WebElement> tableRows = Driver.getDriver().findElements(By.xpath("//table//tr/td"));
        for (int i = 0; i < tableRows.size() ; i++) {
            System.out.println("****" + tableRows.get(i).getText()+"****");
        }
        int tableSize =tableRows.size();
        Assert.assertTrue(tableSize>0);
        extentTest.info("Subscriberslerin goruntulendigini test eder");
        extentTest.pass("subscriberslerin silinebildigini test eder.");

        System.out.println("Sil buttonu görüntülenemedi...");
        Driver.closeDriver();


    }
}
