package Tests.US011_015_024_028.Us028;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminWithdrawTransactionsPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us028_TC01 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    AdminDashboardPage adminDashboardPage;
    AdminWithdrawTransactionsPage adminWithdrawTransactionsPage;

    @Test
    public void transactionsUserDisplay() {

        extentTest = extentReports.createTest("transactionsUserDisplay Testi", "Admin kullanıcıların ödeme yapılan kullanıcıyı görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına Admin kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına Admin kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");
        //Withdraw Transactions linkine tıklayınız

        adminWithdrawTransactionsPage = new AdminWithdrawTransactionsPage();
        adminWithdrawTransactionsPage.withdrawTransactions.click();
        extentTest.info("Withdraw Transactions linkine tıklanır.");
        ReusableMethods.bekle(1);
        //Admin kullanıcılar para çekme işlemleri sayfasında ödeme yapılan kullanıcıyı görüntülendiği doğrulanır.

        Assert.assertTrue(adminWithdrawTransactionsPage.tableFirstUser.isDisplayed());
        extentTest.pass("Admin kullanıcılar para çekme işlemleri sayfasında ödeme yapılan kullanıcıyı görüntülendiği doğrulanır.");
        Driver.closeDriver();

    }

    @Test
    public void transactionsAmountDisplay() {


        extentTest = extentReports.createTest("transactionsAmountDisplay Testi", "Admin kullanıcıların ödeme tutarını görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına Admin kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına Admin kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");
        //Withdraw Transactions linkine tıklayınız

        adminWithdrawTransactionsPage = new AdminWithdrawTransactionsPage();
        adminWithdrawTransactionsPage.withdrawTransactions.click();
        extentTest.info("Withdraw Transactions linkine tıklanır.");
        ReusableMethods.bekle(1);
        //Admin kullanıcılar para çekme işlemleri sayfasında ödeme tutarını görüntülendiği doğrulanır.

        Assert.assertTrue(adminWithdrawTransactionsPage.tableFirstAmount.isDisplayed());
        extentTest.pass("Admin kullanıcılar para çekme işlemleri sayfasında ödeme tutarının görüntülendiği doğrulanır.");
        Driver.closeDriver();
    }

    @Test
    public void transactionsPaymentTypeDisplay() {


        extentTest = extentReports.createTest("transactionsPaymentTypeDisplay Testi", "Admin kullanıcıların ödeme tipini görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına Admin kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına Admin kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");
        //Withdraw Transactions linkine tıklayınız

        adminWithdrawTransactionsPage = new AdminWithdrawTransactionsPage();
        adminWithdrawTransactionsPage.withdrawTransactions.click();
        extentTest.info("Withdraw Transactions linkine tıklanır.");
        ReusableMethods.bekle(1);
        //Admin kullanıcılar para çekme işlemleri sayfasında ödeme tipinin görüntülendiği doğrulanır.

        Assert.assertTrue(adminWithdrawTransactionsPage.tableFirstPaymentType.isDisplayed());
        extentTest.pass("Admin kullanıcılar para çekme işlemleri sayfasında ödeme tipinin görüntülendiği doğrulanır.");
        Driver.closeDriver();
    }

    @Test
    public void transactionsDateDisplay() {


        extentTest = extentReports.createTest("transactionsDateDisplay Testi", "Admin kullanıcıların ödeme tarihini görüntüleyebilmesi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

        //Email textbox'ına Admin kullanıcı email adresini giriniz.

        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ına email adresi girilir.");
        ReusableMethods.bekle(1);

        //Password textbox'ına Admin kullanıcı password'ünü giriniz.

        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ına password girilir.");
        ReusableMethods.bekle(1);

        //Login butonuna basılır.

        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapılır.");
        //Withdraw Transactions linkine tıklayınız

        adminWithdrawTransactionsPage = new AdminWithdrawTransactionsPage();
        adminWithdrawTransactionsPage.withdrawTransactions.click();
        extentTest.info("Withdraw Transactions linkine tıklanır.");
        ReusableMethods.bekle(1);

        //Admin kullanıcılar para çekme işlemleri sayfasında ödeme tarihinin görüntülendiği doğrulanır.

        Assert.assertTrue(adminWithdrawTransactionsPage.tableFirstDate.isDisplayed());
        extentTest.pass("Admin kullanıcılar para çekme işlemleri sayfasında ödeme tarihinin görüntülendiği doğrulanır.");
        Driver.closeDriver();
    }
}
