package Tests.US01_US02_US19_US30;

import Pages.Admin.AdminCountriesPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US30 extends TestBaseRapor{
    Driver driver;
    AdminCountriesPage adminCountriesPage;
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) driver;

    @Test(priority = 1)
    public void testCountries() throws InterruptedException {
        extentTest=extentReports.createTest("Kullanici Countries sekmesine gider","Countries sayisi goruntulenebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        extentTest.info("Kullanici anasayfaya gider");
        Thread.sleep(1000);
        homePage.signInButton.click();

        loginPage.emailBox.sendKeys(ConfigReader.getProperty("admin"));
        loginPage.passwordBox.sendKeys(ConfigReader.getProperty("sifre"));
        loginPage.loginButton.click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();
        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]")).click();
        //adminCountriesPage.countries.click();
        extentTest.info("Countires sekmesine tiklanir");


//        Listede goruntulenen girdi sayisi goruntulenir
        actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(2000);
        extentTest.info("Countires bolumundeki goruntulenen Ulke sayisi goruntulenir");

        //System.out.println(adminCountriesPage.kayitliUlkeSayisi.getText());

//        Goruntuleme dogrulenir
        WebElement countriesCount=Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[6]/div[2]/div[1]"));
        Assert.assertTrue(countriesCount.isDisplayed());
        extentTest.info("Countires bolumundeki goruntulenen Ulke sayisi goruntulenmesi dogrulanir");
//        Tarayici kapnir
        Driver.closeDriver();
        extentTest.info("tarayici kapanir");

    }
    @Test (priority = 2)
    public void testCountriesNew() throws InterruptedException {
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest=extentReports.createTest("Admin Yeni Countries olsuturur","Yeni Countries kaydi dogrulanabilmeli");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();

        extentTest.info("Kullanici dashboard sekmesine gider");
//
        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();

        extentTest.info("Countires sekmesine gider");
//        Yeni ulke ekle kismina tiklanir

        Driver.getDriver().findElement(By.xpath("//*[@id=\"newCountryBtn\"]")).click();
        extentTest.info("Yeni ulke sekmesine gider");
//        Ilgili yerler doldurulur ve kaydedilir
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"countryName\"]")).sendKeys("blabla");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"short_code\"]")).sendKeys("XX");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"phone_code\"]")).sendKeys("7779");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        extentTest.info("Yeni ulke bilgileri girilir ve kayit yapilir");
//        goruntuleme dogrulenir

        Thread.sleep(1000);

        WebElement search=Driver.getDriver().findElement(By.xpath("//div[4]/div[1]/div[1]/form/div/input"));
        search.click();
        search.sendKeys("bla");

        Thread.sleep(1500);
        String expCont="blabla";
        String actCont=Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        Assert.assertTrue(actCont.contains(expCont));
        extentTest.info("Yeni ulke kaydi dogrulanir");
//        Tarayici kapanir

        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[4]/div/a[2]")).click();
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]/button")).click();
        Driver.closeDriver();
        extentTest.info("tarayici kapanir");

    }
    @Test (priority = 3)
    public void testStates() throws InterruptedException {
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest=extentReports.createTest("Admin States sekmesine gider","States sayisi goruntulenebilmeli");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();
        extentTest.info("Kullanici dashboard sekmesine gider");
//
        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();
        Thread.sleep(1000);
        extentTest.info("kullanici Countries sekmesine gider");
//        States bolumune girilir
        WebElement statesTab=Driver.getDriver().findElement(By.xpath("//header[1]/nav[1]/div[1]/div[1]/ul[1]/li[13]/a[1]"));
        statesTab.click();

        extentTest.info("kullanici States sekmesine gider");
//        Listede goruntulenen girdi sayisi goruntulenir

        Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[5]/table/tbody/tr[1]/td[2]")).click();
        Thread.sleep(1000);
        //actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(2000);
        extentTest.info("States bolumundeki goruntulenen States sayisi goruntulenir");

//        Goruntuleme dogrulenir
        WebElement statesCount=Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[6]/div[2]/div[1]/strong[3]"));
        Assert.assertTrue(statesCount.isDisplayed());
        extentTest.info("States goruntuleme sayisi dogrulanir");
//        Tarayici kapnir
        Driver.getDriver();
        extentTest.info("tarayici kapanir");

    }
    @Test (priority = 4)
    public void testStatesNew() throws InterruptedException {
        extentTest=extentReports.createTest("Admin yeni States ekler","Yeni States goruntulenebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        extentTest.info("Kullanici anasayfaya gider");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();
        extentTest.info("kullanici Countries sekmesine gider");
        Thread.sleep(1000);
//        States bolumune girilir
        WebElement statesTab=Driver.getDriver().findElement(By.xpath("//header[1]/nav[1]/div[1]/div[1]/ul[1]/li[13]/a[1]"));
        statesTab.click();
        extentTest.info("kullanici States sekmesine gider");
//        Yeni States ekle kismina tiklanir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"newStateBtn\"]")).click();

        extentTest.info("kullanici New State sekmesine tiklar");
//        Ilgili yerler doldurulur ve kaydedilir

        WebElement statesName=Driver.getDriver().findElement(By.xpath("//*[@id=\"name\"]"));
        statesName.click();
        statesName.clear();
        statesName.sendKeys("abaleubele");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"select2-countryState-container\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"addStateModal\"]/span/span/span[1]/input")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"addStateModal\"]/span/span/span[1]/input")).sendKeys("Albania");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"addStateModal\"]/span/span/span[1]/input")).sendKeys(Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

        extentTest.info("New state formundaki alanlar doldurulur");
//        degisiklik  dogrulanir

        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).click();
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("abale");

        String expStates="abaleub";
        String actStates=Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        System.out.println(actStates);

        Assert.assertTrue(actStates.contains(expStates));
        extentTest.info("New State kayit dogrulamasi yapilir");

        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[3]/div/a[2]")).click();
        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]/button")).click();
//        Tarayici kapanir
        extentTest.info("tarayici kapanir");
    }
    @Test (priority = 5)
    public void testCities() throws InterruptedException {
        extentTest=extentReports.createTest("Admin Citiese gider","Cities goruntulenebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        extentTest.info("Kullanici anasayfaya gider");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();
        extentTest.info("kullanici Countries sekmesine gider");
        Thread.sleep(1000);
//        City bolumune girilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"nav-header\"]/div/div/ul/li[14]/a")).click();
        extentTest.info("Cities sekmesine tiklanir");
//        Listede goruntulenen girdi sayisi goruntulenir
        Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div/div/div[5]/table/tbody/tr[1]/td[2]")).click();
        Thread.sleep(1000);
        //actions.sendKeys(Keys.PAGE_DOWN).click().perform();
        Thread.sleep(1000);
        extentTest.info("Cities bolumundeki goruntulenen States sayisi goruntulenir");

//        Goruntuleme dogrulenir
        WebElement citiesCout=Driver.getDriver().findElement(By.xpath("//div/div/div/div[6]/div[2]/div[1]/strong[3]"));
//
        Assert.assertTrue(citiesCout.isDisplayed());
        extentTest.info("Cities goruntuleme sayisi dogrulanir ");
//        Tarayici kapnir
        Driver.closeDriver();
        extentTest.info("tarayici kapanir");

    }
    @Test (priority = 6)
    public void testCitiesNew() throws InterruptedException {
        extentTest=extentReports.createTest("Admin Yeni Cities ekler","Yeni Cities goruntulenebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        extentTest.info("Kullanici anasayfaya gider");
        Thread.sleep(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Countries bolumune girilir
        WebElement countries=Driver.getDriver().findElement(By.xpath("//span[text()='Countries']"));
        countries.click();
        extentTest.info("kullanici Countries sekmesine gider");
        Thread.sleep(1000);
//        City bolumune girilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"nav-header\"]/div/div/ul/li[14]/a")).click();
        extentTest.info("Cities sekmesine tiklanir");
//        Yeni City ekle kismina tiklanir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"newCityBtn\"]")).click();

        extentTest.info("kullanici New City sekmesine tiklar");
//        Ilgili yerler doldurulur ve kaydedilir

        Driver.getDriver().findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("gluglu");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"select2-StateCity-container\"]")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"addCityModal\"]/span/span/span[1]/input")).sendKeys("Abia");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"addCityModal\"]/span/span/span[1]/input")).sendKeys(Keys.ENTER);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"btnSave\"]")).click();

        extentTest.info("New state formundaki alanlar doldurulur");
//
//        goruntuleme dogrulenir
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).click();
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("glu");

        String expCity="glu";
        String actCity=Driver.getDriver().findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
        Thread.sleep(1500);

        Assert.assertTrue(actCity.contains(expCity));

        extentTest.info("New City kayit dogrulamasi yapilir");

        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[3]/div/a[2]")).click();
        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]/button")).click();
//        Tarayici kapanir
        Driver.closeDriver();
        extentTest.info("tarayici kapanir");
    }

}
