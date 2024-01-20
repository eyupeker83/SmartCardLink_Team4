package Tests.US03_US13_US26;

import Pages.Users.AccountSettingsPage;
import Pages.Users.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US13_TC01_TC02_TC03 extends TestBaseRapor {

    LoginPage loginPage;
    AccountSettingsPage accountSettingsPage;

    @Test
    public void Test01(){

        extentTest=extentReports.
                createTest("Kullanici Login Testi"," Kullanıcı gecerli bilgilerle login olabilmelidir.");

        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci Smart Card Link sitesine gider.");

        //Sign In  butonuna tıklar.
        loginPage=new LoginPage();
        loginPage.signInButton.click();
        extentTest.info("Sign In  butonuna tıklar.");

        //Email kutusuna kayitli mail adresini girer.
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("afMail"));
        extentTest.info("Email kutusuna kayitli mail adresini girer.");

        //Password kutusuna kayıtlı şifreyi girer.
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("afPassword"));
        extentTest.info("Password kutusuna kayıtlı sifreyi girer.");

        //Login butonuna tıklar.
        loginPage.loginButton.click();
        extentTest.info("Login butonuna tıklar.");
    }


    @Test(dependsOnMethods = "Test01")
    public void Test02(){

        extentTest=extentReports.
                createTest("Profil Bilgileri Goruntuleme Testi","Kullanıcı hesap bilgilerini goruntuleyebilmelidir.");

        //Kullanici profil adinin yer aldigi dropdown menuye tıklar.
        accountSettingsPage=new AccountSettingsPage();
        accountSettingsPage.profilDropDownMenu.click();
        extentTest.info("Kullanici profil adinin yer aldigi dropdown menuye tıklar.");

        //Açılan listeden Account Settings seçeneğini tıklar.
        accountSettingsPage.accountSettingsSekmesi.click();
        extentTest.info("Açılan listeden Account Settings seçeneğini tıklar.");

        // Avatar, fullname,email ve contact number  baslıklarinin goruldugunu dogrular.
        Assert.assertTrue(accountSettingsPage.avatarBaslik.isDisplayed());
        extentTest.pass("Avatar basligininin goruntulendigini test eder.");
        Assert.assertTrue(accountSettingsPage.fullNameBaslik.isDisplayed());
        extentTest.pass("Full Name basligininin goruntulendigini test eder.");
        Assert.assertTrue(accountSettingsPage.eMailBaslik.isDisplayed());
        extentTest.pass("Email basligininin goruntulendigini test eder.");
        Assert.assertTrue(accountSettingsPage.contactNoBaslik.isDisplayed());
        extentTest.pass("Contact No basligininin goruntulendigini test eder.");

        //Fotograf duzenleme butonunun aktif oldugunu dogrular.
        Assert.assertTrue(accountSettingsPage.avatarEditButton.isEnabled());
        extentTest.pass("Fotograf duzenleme butonunun aktif oldugunu test eder.");

        //Fullname, email ve phone number yazı kutularinin aktif oldugunu dogrular.
        Assert.assertTrue(accountSettingsPage.firstNameBox.isEnabled());
        extentTest.pass("First name yazı kutusunun aktif oldugunu test eder.");
        Assert.assertTrue(accountSettingsPage.lastNameBox.isEnabled());
        extentTest.pass("Last name yazı kutusunun aktif oldugunu test eder.");
        Assert.assertTrue(accountSettingsPage.eMailBox.isEnabled());
        extentTest.pass("Email yazı kutusunun aktif oldugunu test eder.");
        Assert.assertTrue(accountSettingsPage.phoneNumberBox.isEnabled());
        extentTest.pass("Phone number yazı kutusunun aktif oldugunu test eder.");
    }


    @Test(dependsOnMethods = "Test01")
    public void Test03() {
        extentTest=extentReports.
                createTest("Profil Bilgileri Guncelleme Testi","Kullanıcı hesap bilgilerini degistirip kaydedebilmelidir.");

        //Kullanici profil adinin yer aldigi dropdown menuye tıklar.
        accountSettingsPage=new AccountSettingsPage();
        accountSettingsPage.profilDropDownMenu.click();
        extentTest.info("Kullanici profil adinin yer aldigi dropdown menuye tıklar.");
        ReusableMethods.bekle(1);

        //Açılan listeden Account Settings seçeneğini tıklar.
        accountSettingsPage.accountSettingsSekmesi.click();
        extentTest.info("Açılan listeden Account Settings seçeneğini tıklar.");
        ReusableMethods.bekle(1);

        // Phone number kısmında degisiklik yapmak icin ulke alan kodu dropdown menusune tıklar

        accountSettingsPage.phoneCountryDropDown.click();
        extentTest.info("Phone number kısmında degisiklik yapmak icin ulke alan kodu dropdown menusune tıklar.");
        ReusableMethods.bekle(1);

        // Menuyu asagı kaydırır ve  Italya'yı secer.
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", accountSettingsPage.italyPhoneCode);
        ReusableMethods.bekle(3);
        jse.executeScript("arguments[0].click();", accountSettingsPage.italyPhoneCode);
        extentTest.info("Menuyu asagı kaydırır ve  Italya'yı secer.");


        // Phone number kısmına yeni bir telefon numarasi bilgisi girer.
        accountSettingsPage.phoneNumberBox.sendKeys("1111111");
        extentTest.info("Phone number kısmına yeni bir telefon numarasi bilgisi girer.");

        //Yapılan degisikliği kaydetmek için Save butonunun tıklanabilir oldugunu dogrular
        Assert.assertTrue(accountSettingsPage.saveButton.isEnabled());
        extentTest.pass("Yapılan degisikliği kaydetmek için Save butonunun tıklanabilir oldugunu test eder.");

        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir.");
    }
}
