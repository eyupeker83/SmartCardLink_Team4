package Tests.US08_US21_US29_US31.US08;

import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import Pages.Users.VcardsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.*;


public class US08 extends TestBaseRapor {
    // ******************** TAMAMLANDI *******************************
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    VcardsPage vcardsPage = new VcardsPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
    String vCardName;
    String filePath;

    @Test(priority = -1)
    public void testCase01() {
        extentTest = extentReports.createTest("vCard Testi", "Kullanici login olabilmeli");

        // https://qa.smartcardlink.com adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Smart Card Link anasayfaya gider");

        //Sign in butonuna tiklanir
        homePage.signInButton.click();
        extentTest.info("Sign in butonuna basar");

        // Email kutusuna kullanicinin kayitli email'i girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("bugraNurdanKayitliKullaniciEmail"));
        extentTest.info("Email kutusuna kayitli email'ini girer");

        // Password kutusuna kullanicinin kayitli sifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("bugraNurdanKayitliKullaniciSifre"));
        extentTest.info("Password kutusuna kayitli sifresini girer");

        // login butonuna tiklanir
        loginPage.loginButton.click();
        extentTest.info("Login butonuna tiklar");

    }

    @Test(priority = 1)
    public void testCase02() {
        // VCards kategorisine tiklanir
        vcardsPage.vCardsTab.click();
        extentTest.info("vCards kategorisine tiklar");

        // New VCard butonuna tiklanir
        vcardsPage.newVCardsButton.click();
        extentTest.info("New VCard butonuna tiklar");

        // Url text box kutusuna karttan erisilmesi istenen url girilir
        vcardsPage.urlTextBox.sendKeys("johndoedeneme");
        extentTest.info("karttan erisilmesi istenen url'i girer");

        // VCard Name kutusuna yeni VCard ismi girilir
        vCardName = "My New vCard!";
        vcardsPage.vCardNameTextBox.sendKeys(vCardName);
        extentTest.info("Yeni vCard ismi girer");

        // Occupation kısmına meslek girilir
        vcardsPage.occupationTextBox.sendKeys("Software Development Enginner in Test");
        extentTest.info("Occupation kismina meslegini girer");

        // Description kısmına tanımlama girilir
        vcardsPage.descriptionTextBox.sendKeys("Description try-out");
        extentTest.info("Description kismina tanimlama girer");

        // Save butonuna tıklanır
        //vcardsPage.vCardSaveButton.click();
        //This solution will do a force click on the required element
        js.executeScript("arguments[0].click();", vcardsPage.vCardSaveButton);
        extentTest.info("Save butonuna tiklar");

        // edit vCard sayfası göründüğü test edilir
        assertTrue(vcardsPage.editvCardText.isDisplayed());
        extentTest.pass("edit vCards sayfasinin gorundugunu test eder");

        // back butonuna tiklanir
        vcardsPage.vCardBackButton.click();
        extentTest.info("Back butonuna tiklar");
    }

    @Test(priority = 2)
    public void testCase03() {
        // Açılan sayfadaki Back butonuna tıklanır
        vcardsPage.vCardBackButton.click();
        extentTest.info("Back butonuna tiklar");

        // kullanıcının vCard oluşturduğu test edilir
        String expectedVCardName = vCardName;
        String actualVCardName = vcardsPage.lastCreatedVCardName.getText();
        assertEquals(actualVCardName, expectedVCardName);
        extentTest.pass("kullanici vCard olusturdugunu test eder");
    }

    @Test(priority = 3)
    public void testCase04() {
        // Kullanıcının oluşturduğu toplam vCard sayısının görüntülenebildiği test edilir
        assertTrue(vcardsPage.numberOfVCardsResult.isDisplayed());
        extentTest.info("Kullanicinin, olusturdugu vCard sayisini kontrol eder");
    }

    @Test(priority = 4)
    public void testCase05() {
        // QR Code'a tıklanır ve  başarıyla indirildiği test edilir
        ReusableMethods.bekle(1);
        vcardsPage.qrCodeButton.click();
        ReusableMethods.bekle(2);
        filePath = "C:\\Users\\bugra\\Downloads\\qr_code.png";
        assertTrue(Files.exists(Paths.get(filePath)));
        extentTest.pass("Qr Code butonuna tiklar ve indirildigini test eder");

        // Download VCard'a tıklanır ve başarıyla indirildiği test edilir
        vcardsPage.downloadVCardButton.click();
        ReusableMethods.bekle(2);
        filePath = "C:\\Users\\bugra\\Downloads\\unknown.vcf";
        assertTrue(Files.exists(Paths.get(filePath)));
        extentTest.info("Download vCard butonuna tiklar ve indirildigini test eder");

        // Enquiries'e tıklanır ve sayfanın açıldığı test edilir
        vcardsPage.enquiriesButton.click();
        String expectedUrlContent = "enquiry";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrlContent));
        extentTest.info("Enquiries'e tiklar ve sayfanin acildigini test eder");

        // Back'e tıklayıp önceki sayfaya geri dönülür
        vcardsPage.vCardBackButton.click();
        extentTest.info("Back butonuna tiklar");

        // Duplicate VCard'a tıklanır açılan ekranda Yes kutusuna tıklanır
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", vcardsPage.duplicateVCardButton);
        ReusableMethods.bekle(1);

        vcardsPage.duplicateAcceptanceButton.click();
        // 1 saniye beklenir
        ReusableMethods.bekle(1);
        extentTest.info("Duplicate VCard'a tiklar ve acilan ekranda Yes kutusuna tiklar");

        // Kartın yeni kopyası görüntülendiği test edilir
        assertTrue(vcardsPage.previousCreatedVCardName.isDisplayed());
        ReusableMethods.bekle(1);
        extentTest.pass("Kartin yeni kopyasinin goruntulendigini test eder");

        // Edit'e tıklanır ve edit sayfasının açıldığı test edilir
        vcardsPage.previousCreatedEditVCardButton.click();
        expectedUrlContent = "edit";
        actualUrl = Driver.getDriver().getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrlContent));
        extentTest.pass("Edit'e tiklar ve edit sayfasinin acildigini test eder");

        // Back'e tıklayıp önceki sayfaya geri dönülür
        vcardsPage.vCardBackButton.click();
        extentTest.info("Back'e tiklar");

        // Delete'e tıklanır, açılan pencerede Yes,Delete! kutusuna tıklanır
        ReusableMethods.bekle(1);
        js.executeScript("arguments[0].click();", vcardsPage.previousCreatedDeleteVCardButton);
        ReusableMethods.bekle(1);
        vcardsPage.yesDeleteButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Delete'e tiklar ve acilan pencerede Yes,Delete! kutusuna tiklar");

        js.executeScript("arguments[0].click();", vcardsPage.lastCreatedDeleteVCardButton);
        ReusableMethods.bekle(1);
        vcardsPage.yesDeleteButton.click();
        ReusableMethods.bekle(1);
        extentTest.info("Delete'e tiklar ve acilan pencerede Yes,Delete! kutusuna tiklar");

        // VCard'ın başarıyla silindiği test edilir
        assertTrue(vcardsPage.noDataTBodyChart.isDisplayed());
        extentTest.pass("vCard'in silindigini test eder");

        Driver.closeDriver();
    }
}