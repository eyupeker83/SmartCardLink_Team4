package Tests.US011_015_024_028.Us015;

import Pages.Users.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class Us015_TC02 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    PlansPage plansPage;
    PaymentPage paymentPage;
    ManageSubscriptionPage manageSubscriptionPage;
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void planChange(){

        extentTest = extentReports.createTest("planChange Testi", "Kayıtlı kullanıcıların plan yükseltme işlemini gerçekleştirmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına kayıtlı kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına kayıtlı kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");

        //Açılan sayfadan smartcardlink linkine tıklanarak anasayfaya geçiş yapılır.

        String handle01 = Driver.getDriver().getWindowHandle();

        dashboardPage = new DashboardPage();
        dashboardPage.smartCardHomeLink.click();
        extentTest.info("Anasayfa geçiş linkine tıklanır.");

        String handle02 = "";
        Set<String> handleSet = Driver.getDriver().getWindowHandles();

        for (String each:handleSet) {

            if (!each.equals(handle01)){

                handle02 = each;
            }
        }

        //menüden pricing linkine tıklanır.

        Driver.getDriver().switchTo().window(handle02);

        homePage.pricingMenuButton.click();
        extentTest.info("Menüden pricing linkine tıklanır.");
        ReusableMethods.bekle(3);

        //silver plan için switch plan butonuna tıklayınız.

        jse.executeScript("arguments[0].scrollIntoView();",homePage.switchPlanButtonSilver);

        homePage.switchPlanButtonSilver.click();
        extentTest.info("Silver plan için switch plan butonuna tıklanır.");
        ReusableMethods.bekle(1);

        //select payment gateway alanına tıklanır.

        plansPage = new PlansPage();

        jse.executeScript("arguments[0].scrollIntoView();",plansPage.selectPaymentGateway);
        ReusableMethods.bekle(1);

        //açılan listeden stripe tıklanarak seçim yapılır.

        Select select = new Select(plansPage.selectPaymentGateway);
        select.selectByVisibleText("Stripe");
        extentTest.info("Ödeme tipi seçilir.");
        //pay/switch plan butonuna basılır.

        plansPage.Pay_SwitchPlan.click();
        extentTest.info("Pay/SwitchPlan butonuna tıklanır.");
        ReusableMethods.bekle(1);
        //Kart bilgileri alanında kart no alanına kart no bilgisi giriş yapılır

        paymentPage = new PaymentPage();
        paymentPage.kartNumber.sendKeys(ConfigReader.getProperty("kartNo"));
        extentTest.info("Kart no bilgisi girilir.");

        //AA/YY alanına kart ay/yıl bilgi girişi yapılır
        ReusableMethods.bekle(1);
        paymentPage.aa_yy.sendKeys(ConfigReader.getProperty("AA_YY"));
        ReusableMethods.bekle(1);
        extentTest.info("AA/YY bilgisi girilir.");

        //CVC alanına kart cvc bilgi girişi yapılır.

        paymentPage.cvc.sendKeys(ConfigReader.getProperty("cvc"));
        extentTest.info("CVC Alanına giriş yapılır.");

        //Kart sahibinin adı alanına ad girişi yapılır.

        paymentPage.cardNameSurname.sendKeys(ConfigReader.getProperty("kartNameSurname"));
        extentTest.info("Kart sahibinin adı soyadı girilir.");

        //öde butonuna tıklayınız.

        paymentPage.payButton.click();

        //Stripe ödeme seçenegi ile kullanıcı ödeme yapabildiği doğrulanır.

        paymentPage.backToSubscriptions.click();
        manageSubscriptionPage = new ManageSubscriptionPage();

        String expectedText=ConfigReader.getProperty("silverText");
        String actualText = manageSubscriptionPage.silverText.getText();

        Assert.assertTrue(expectedText.equals(actualText));
        extentTest.pass("Silver plan yükseltme işlemi doğrulanır.");
        //Browser kapatılır.

        Driver.getDriver().quit();
    }
}
