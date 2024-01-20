package Tests.US07_US12_US17_US32.US07;

import Pages.Users.DashboardPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.testng.Assert.*;

public class US07 {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    Actions actions = new Actions(Driver.getDriver());

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

        // ******* RAPOR EKSIK *******

        assertTrue(dashboardPage.smartCardHomeLink.isDisplayed());
        assertTrue(dashboardPage.profileImage.isDisplayed());
        assertTrue(dashboardPage.usersButton.isDisplayed());
        assertTrue(dashboardPage.dashboard.isDisplayed());
        assertTrue(dashboardPage.vCards.isDisplayed());
        assertTrue(dashboardPage.enquiries.isDisplayed());
        assertTrue(dashboardPage.appointments.isDisplayed());
        assertTrue(dashboardPage.virtualBackgrounds.isDisplayed());
        assertTrue(dashboardPage.affiliations.isDisplayed()); // affiliations settings e gidiyor
        // assertTrue(dashboardPage.settings.isDisplayed());
        for (WebElement each : dashboardPage.cards
        ) {
            assertTrue(each.isDisplayed());
        }
        assertTrue(dashboardPage.vCardAnalyticTable.isDisplayed());

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.bekle(1);
        assertTrue(dashboardPage.todayAppointmentsTable.isDisplayed());

        Driver.closeDriver();

        // asd@gmail.com
        // asdasdasd123*
    }
}
