package Tests.US011_015_024_028.Us011;

import Pages.Users.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Us011_TC02 extends TestBaseRapor {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    VirtualBackGroundsPage virtualBackGroundsPage;
    AddVirtualBackgroundPage addVirtualBackgroundPage;
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void vCardSave() throws InterruptedException, AWTException {

        extentTest = extentReports.createTest("vCardBackGroundSelection Testi", "VirtualBackGround sayfasindan arka plan seçimi.");

        // https://qa.smartcardlink.com/ adresine gidilir.

        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tıklayınız.

        homePage = new HomePage();
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna tıklanır.");

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

        // virtual-backgrounds linkine tıklanır.

        dashboardPage = new DashboardPage();
        dashboardPage.virtualBackgrounds.click();
        extentTest.info("Dashboard sayfasında virtual back ground linkine tıklanır.");

        //virtual-backgrounds sayfasında seçimi yapılan kart arka planına tıklanır

        virtualBackGroundsPage = new VirtualBackGroundsPage();
        virtualBackGroundsPage.backGroundsImg01.click();
        extentTest.info("Virtual back ground ekranından seçimi yapılan karta tıklanır.");

        //vcard name alanına tıklanır

        addVirtualBackgroundPage = new AddVirtualBackgroundPage();
        addVirtualBackgroundPage.VcardName.click();
        extentTest.info("vcard name alanına tıklanır");
        ReusableMethods.bekle(2);

        //Listelenen vcard'lar arasından tıklanarak vcard seçimi yapılır

        addVirtualBackgroundPage.adaVcardName.click();
        extentTest.info("Listelenen vcard'lar arasından tıklanarak vcard seçimi yapılır");

        //Add--Ecard alanına fotograf yüklemesi yapılır.

        addVirtualBackgroundPage.AddEcardClick.click();
        extentTest.info("Add--Ecard alanına fotograf yüklemesi yapılır.");

        Thread.sleep(2000);
        //Create object for Robot class
        Robot robot=new Robot();

        //Store the path of the file to be uploaded using StringSelection Class Object
        StringSelection filepath=new StringSelection("150-4.jpg");

        //Copy above path to Clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath,null);

        //Press Control&V to paste the above path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);

        //Release Control & V buttons
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        //Release Enter
        robot.keyRelease(KeyEvent.VK_ENTER);

        //wait for the file to get uploaded
        robot.delay(2000);
        // Thread.sleep(10000);
        System.out.println("File Uploaded Successfully");

        //First Name alanına name girişi yapılır.

        addVirtualBackgroundPage.firstName.sendKeys(ConfigReader.getProperty("addVirtualBackGroundFirstName"));
        extentTest.info("First Name alanına name girişi yapılır.");

        //Last Name alanına giriş yapılır.

        addVirtualBackgroundPage.lastName.sendKeys(ConfigReader.getProperty("addVirtualBackGroundLastName"));
        extentTest.info("Last Name alanına giriş yapılır.");

        //Email alanına email girişi yapılır.

        addVirtualBackgroundPage.Email.sendKeys(ConfigReader.getProperty("addVirtualBackGroundEmail"));
        extentTest.info("Email alanına email girişi yapılır.");

        //Enter Occupation alanına giriş yapılır.

        addVirtualBackgroundPage.occupation.sendKeys(ConfigReader.getProperty("addVirtualBackGroundOccupation"));
        extentTest.info("Enter Occupation alanına giriş yapılır.");

        //Location alanına giriş yapılır.

        addVirtualBackgroundPage.location.sendKeys(ConfigReader.getProperty("addVirtualBackGroundLocation"));
        extentTest.info("Location alanına giriş yapılır.");

        //Phone alanına giriş yapılır.

        addVirtualBackgroundPage.phone.sendKeys(ConfigReader.getProperty("addVirtualBackGroundPhone"));
        extentTest.info("Phone alanına giriş yapılır.");

        //Web Site alanına giriş yapılır.

        addVirtualBackgroundPage.webSite.sendKeys(ConfigReader.getProperty("addVirtualBackGroundWebSite"));
        extentTest.info("Web Site alanına giriş yapılır.");

        //Save butonuna tıklanır.
        jse.executeScript("arguments[0].scrollIntoView();",addVirtualBackgroundPage.saveButton);
        ReusableMethods.bekle(10);
        addVirtualBackgroundPage.saveButton.click();
        extentTest.info("Save butonuna tıklanır.");
        ReusableMethods.bekle(2);
        //Kullanıcı kayıt işleminin başarılı oldugu doğrulanır.

        String dosyaYolu = "C:\\Users\\bilse\\Downloads\\virtual-backgrounds.zip";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        extentTest.pass("Kullanıcı kayıt işleminin başarılı oldugu doğrulanır.");
        //Browser kapatılır.

        Driver.closeDriver();
    }
}
