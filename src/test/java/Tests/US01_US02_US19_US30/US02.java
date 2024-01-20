package Tests.US01_US02_US19_US30;

import Pages.Users.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US02 extends TestBaseRapor {
    HomePage homePage=new HomePage();
    @Test
    public void testHome() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Ana Sayfaya gider","Anasayfa goruntulenebilmeli");
//        1-Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici Anasayfaya gider");
        Thread.sleep(2000);
//        2-Sekmenin acildigi dogrulanir
        WebElement homepage=Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/li[1]/a"));
        //homePage.homeMenuButton.click();
        homepage.click();


        Assert.assertTrue(homepage.isDisplayed());
        extentTest.pass("Anasayfa ya ulasildigi dogrulanir");
//        3-Tarayici kapanir
        Driver.closeDriver();
        extentTest.info("Sayfayi Kapatir");
    }
    @Test
    public void testFeatures() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Featuresa gider","Features goruntulenebilmeli");
//        Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        Thread.sleep(2000);
//        Features sekmesi tiklanir
        WebElement features=Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/li[2]/a"));
        //homePage.featuresMenuButton.click();
        features.click();
        extentTest.info("kullanici Features sekmesine gider");


//        Features sekmesi acildigi dogrulanir ve Tarayici kapanir

        //String actIcerik=homePage.featuresBaslik.getText();
        Assert.assertTrue(features.isDisplayed());

        extentTest.pass("Features sekmesi acildigi dogrulanir");
        Driver.closeDriver();
        extentTest.info("Sayfa kapanir");
    }
    @Test
    public void testAbout() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici About sekmesine gider","About goruntulenebilmeli");
        //        Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        Thread.sleep(2000);
//        About sekmesi tiklanir
        homePage.aboutMenuButton.click();
        extentTest.info("kullanici About sekmesine gider");

//        About sekmesi acildigi dogrulanir ve Tarayici kapanir
        String expIcerik="About";
        String actIcerik=homePage.aboutSmartCardBaslik.getText();

        Assert.assertTrue(actIcerik.contains(expIcerik));
        extentTest.pass("About sekmesinin acildigi dogrulanir");

        Driver.closeDriver();
        extentTest.info("Sayfa Kapanir");
    }
    @Test
    public void testPricing() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Pricinge gider","Pricing goruntulenebilmeli");
//        Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        Thread.sleep(2000);
//        Pricing sekmesi tiklanir
        //homePage.pricingMenuButton.click();
        WebElement pricing=Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/li[4]/a"));
        pricing.click();
        extentTest.info("kullanici Pricing sekmesine gider");

//        Pricing sekmesi acildigi dogrulanir ve Tarayici kapanir
        WebElement pricingArea=Driver.getDriver().findElement(By.xpath("//*[@id=\"frontPricingTab\"]/div/h2"));
        String expIcerik="plan";
        String actIcerik=pricingArea.getText();

        Assert.assertTrue(actIcerik.contains(expIcerik));
        extentTest.pass("Pricing sekmesinin acildigi dogrulanir");
        Driver.closeDriver();
        extentTest.info("sayfa kapanir");

    }
    @Test
    public void testContact() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Contact gider","Contact goruntulenebilmeli");
//        Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
//        Contact sekmesi tiklanir
        Thread.sleep(2000);
        WebElement contact=Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/li[5]/a"));
        //homePage.contactMenuButton.click();
        contact.click();
        extentTest.info("kullanici Contact sekmesine gider");

//        Contact sekmesi acildigi dogrulanir ve Tarayici kapanir
        String expIcerik="Contact";
        String actIcerik=Driver.getDriver().findElement(By.xpath("//*[@id=\"frontContactUsTab\"]/h2")).getText();
        Assert.assertTrue(actIcerik.contains(expIcerik));
        extentTest.pass("Contact sekmesinin acildigi dogrulanir");
        Driver.closeDriver();
        extentTest.info("sayfa kapanir");

    }
    @Test
    public void testSignIn() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Dashboard sekmesine gider","Sign in goruntulenebilmeli");
//        Tarayici acilir ve ilgili adrese gider
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        Thread.sleep(2000);
//        Sign In sekmesi tiklanir
        //homePage.signInButton.click();
        WebElement signin=Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a"));
        signin.click();
        extentTest.info("kullanici Sign In sekmesine gider");

//        Sign In sekmesi acildigi dogrulanir ve Tarayici kapanir
        String expIcerik="Sign In";
        String actIcerik=Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/h1")).getText();
        Assert.assertTrue(actIcerik.contains(expIcerik));
        extentTest.pass("Sign In sekmesinin acildigi dogrulanir");

        Driver.closeDriver();
        extentTest.info("sayfa kapanir");
    }
}
