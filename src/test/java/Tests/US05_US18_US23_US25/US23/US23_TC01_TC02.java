package Tests.US05_US18_US23_US25.US23;

import Pages.Admin.AdminCashPaymentPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US23_TC01_TC02 extends TestBaseRapor {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminCashPaymentPage adminCashPaymentPage = new AdminCashPaymentPage();
    @Test
    public void test01(){
        extentTest = extentReports.createTest("Cash Payment Testi","Admin manuel odemeleri goruntuleyebilmelidir");

        //Kullanıcı "https://qa.smartcardlink.com/" sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart card anasayfaya gider");
        //Kullanıcı Sign In butonuna basarak admin ana sayfayı görüntüler
        homePage.signInButton.click();
        extentTest.info("Admin login'e click yapar");
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Admin email girisi yapar");
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Admin password girisi yapar");
        loginPage.loginButton.click();
        extentTest.info("Admin giris yapar");
        //Cash payments sayfasına gider
        adminCashPaymentPage.cashPaymentsButonu.click();
        extentTest.info("Cash Payment butonuna click yapar");
        //Sayfada görülen webtable üzerinden ödemelerin görüntülendiğini doğrular
        Assert.assertTrue(adminCashPaymentPage.cashPaymentWebTable.size()>0);
        extentTest.pass("Admin cash paymentleri goruntuledigini test eder");
    }
    @Test(dependsOnMethods = "test01")
    public void test02(){
        extentTest = extentReports.createTest("Cash Payment Goruntuleme Testi","Admin manuel odemelerinin oldugunu goruntuleyebilmelidir");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Sayfa sonuna inmek için JavaScript kullan
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        extentTest.info("Sayfanin footer kismina iner");
        ReusableMethods.bekle(2);
        String cashPaymentResultText;
        String[] cashPaymentResults;
        String cashPaymentSayisiStr;
        int cashPaymentSayisiInt;
        //Admin manuel ödeme sayısını yazdırır
        cashPaymentResultText = adminCashPaymentPage.result.getText();
        cashPaymentResults = cashPaymentResultText.split(" ");
        if(cashPaymentResults[4].equals("of")){
            cashPaymentSayisiStr = cashPaymentResults[5];
            System.out.println(cashPaymentSayisiStr);
        }
        extentTest.info("Manuel odeme sayisini goruntuler");


        //Manuel ödeme sayısının görüntülenebildiğini doğrular
        Assert.assertTrue(adminCashPaymentPage.result.isDisplayed());
        extentTest.pass("Manuel odeme sayisinin goruntulendigini test eder");
        Driver.closeDriver();
    }

}
