package Tests.US05_US18_US23_US25.US25;

import Pages.Admin.AdminDashboardPage;
import Pages.Admin.AdminPlansPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.Duration;
import java.util.List;

public class US25_TC02_TC03 extends TestBaseRapor {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    AdminPlansPage adminPlansPage = new AdminPlansPage();
    AdminDashboardPage adminDashboardPage = new AdminDashboardPage();


    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void newPlan() {
        extentTest = extentReports.createTest("New Plan Testi", "Admin yeni uyelik plani olusturabilmelidir");
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        AdminPlansPage adminPlansPage = new AdminPlansPage();
        AdminDashboardPage adminDashboardPage = new AdminDashboardPage();
        // https://qa.smartcardlink.com/ adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        //Sign in butonuna tıklayınız.
        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");
        //Email textbox'ına kayıtlı kullanıcı email adresini giriniz.
        loginPage = new LoginPage();
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("adminEmail1"));
        extentTest.info("Email textbox'ina email adresi girilir.");
        ReusableMethods.bekle(1);
        //Password textbox'ına kayıtlı kullanıcı password'ünü giriniz.
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"));
        extentTest.info("Password textbox'ina password girilir.");
        ReusableMethods.bekle(1);
        //Login butonuna basılır.
        loginPage.loginButton.click();
        extentTest.info("Login buttonuna click yapilir.");
        //Plans linkine tıklayınız.
        adminDashboardPage = new AdminDashboardPage();
        adminDashboardPage.plansLink.click();
        extentTest.info("Plans linke click yapılır.");
        ReusableMethods.bekle(1);
        //Admin yeni plan oluşturmak için New Plan butonuna basar
        adminPlansPage.newPlanButtonu.click();
        extentTest.info("New Plan linke click yapilir");
        //Admin açılan New Plan sayfasında geçerli bilgileri girerek yeni üyelik planı oluşturur
        adminPlansPage.nameTextBox.sendKeys(ConfigReader.getProperty("addVirtualBackGroundFirstName"));
        extentTest.info("nameTextBox'a giriş yapilir");
        ReusableMethods.bekle(2);
        adminPlansPage.frequencyDropDown.click();
        List<WebElement> optionsFrequency = adminPlansPage.frequencyOptions;
        optionsFrequency.get(1).click();
        extentTest.info("FrequencyDropDown'dan seçim yapilir");
        ReusableMethods.bekle(2);
        adminPlansPage.CurrencyDropDown.click();
        List<WebElement> optionCurrency = adminPlansPage.currencyOptions;
        optionCurrency.get(2).click();
        extentTest.info("CurrencyDropDown'dan seçim yapilir");
        adminPlansPage.priceTextBox.sendKeys(ConfigReader.getProperty("price"));
        extentTest.info("priceTextBox'a giriş yapilir");
        adminPlansPage.no_of_vcardsTextBox.sendKeys(ConfigReader.getProperty("no_of_vcards"));
        extentTest.info("no_of_vcardsTextBox'a giriş yapilir");
        adminPlansPage.trial_daysTextBox.sendKeys(ConfigReader.getProperty("trial_days"));
        extentTest.info("trial_daysTextBox'a giriş yapilir");
        ReusableMethods.bekle(2);
        jse.executeScript("arguments[0].scrollIntoView();",adminPlansPage.multiTemplates);
        ReusableMethods.bekle(5);
        // adminPlansPage.multiTemplates.click();
        extentTest.info("multiTemplates seçimi yapilir");
        jse.executeScript("arguments[0].scrollIntoView();",adminPlansPage.featureAll);
        ReusableMethods.bekle(4);
        adminPlansPage.featureAll.click();
        extentTest.info("özellik seçimi yapilir");
        adminPlansPage.saveButton.click();
        extentTest.info("save butona tıklanır.");
        //Admin yeni üyelik planı eklediğini doğrular
        WebDriverWait webDriverWait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        Assert.assertTrue(webElement.isDisplayed());
        extentTest.pass("Admin yeni üyelik planı eklediğini doğrular");
        ReusableMethods.bekle(3);
        String expectedName = ConfigReader.getProperty("addVirtualBackGroundFirstName");
        String actualName = adminPlansPage.tableFirsName.getText();
        Assert.assertEquals(expectedName,actualName);
    }
    @Test(dependsOnMethods = "newPlan")
    public void planSilme(){
        extentTest = extentReports.createTest("Uyelik Plani Silme Testi","Admin plan silme islemini yapabilmelidir");
        adminPlansPage.deleteButton.click();
        extentTest.info("Delete linke click yapılır.");
        ReusableMethods.bekle(1);
        adminPlansPage.yesDelete.click();
        extentTest.info("Yes/Delete butona tıklanır.");
        ReusableMethods.bekle(1);
        String expectedName = ConfigReader.getProperty("addVirtualBackGroundFirstName");
        String actualName = adminPlansPage.tableFirsName.getText();
        Assert.assertFalse(actualName.equals(expectedName));
        Driver.closeDriver();
    }



}
