package Tests.US07_US12_US17_US32.US12;

import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import Pages.Users.SettingsPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import static org.testng.Assert.assertTrue;

public class US12 {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();
    Select select;

    @Test
    public void test01() {
        // https://qa.smartcardlink.com adresine gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));

        //Sign in butonuna tiklanir
        homePage.signInButton.click();

        // Email kutusuna kullanicinin kayitli email'i girilir
        loginPage.emailBox.sendKeys(ConfigReader.getProperty("bugraNurdanKayitliKullaniciEmail"));

        // Password kutusuna kullanicinin kayitli sifresi girilir
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("bugraNurdanKayitliKullaniciSifre"));

        // login butonuna tiklanir
        loginPage.loginButton.click();

        // setting kategorisine tiklanir
        settingsPage.settingTab.click();

        //stripe checkboxu aktiflestirilir
        settingsPage.stripeCheckBox.click();

        //stripe key kutusuna key girilir
        settingsPage.stripeKeyTextBox.sendKeys("123123123");

        //stripe secret kutusuna key girilir
        settingsPage.stripeSecretTextBox.sendKeys("123123123");

        // paypal checkbox a tiklanir
        settingsPage.paypalCheckBox.click();

        // paypal client id kutusuna id girilir
        settingsPage.paypalClientIdTextBox.sendKeys("123123123");

        // paypal secret kutusuna numara girilir
        settingsPage.paypalSecretTextBox.sendKeys("123123123");

        //paypal mode kutusuna numara girilir
        settingsPage.paypalModeTextBox.sendKeys("123123123");

        //***************** DEVAM ET ***********************

        // dropdown menusunden para birimini secilir
        select = new Select(settingsPage.currencyDropdownMenu);
        select.selectByIndex(3);

        // enable contact checkbox ina tiklanir
        settingsPage.enableContactCheckbox.click();

        //hide v card sticky bar checkbox ina tiklanir
        settingsPage.hidevCardStickyBarCheckbox.click();

        //whatsapp share checkbox ina tiklanir
        settingsPage.whatsappShareCheckbox.click();

        //time format'i 24 saate cevirilir
        settingsPage.timeFormat24Hour.click();

        //save butonuna tiklanir
        settingsPage.saveButton.click();

        // degisiklikleri kaydettigini test edilir
        assertTrue(settingsPage.saveConfirmationAlert.isDisplayed());

        Driver.closeDriver();

    }
}
