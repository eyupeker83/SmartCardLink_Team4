package Tests.US03_US13_US26;

import Pages.Users.HomePage;
import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US03_TC01_TC02_TC03_TC04_TC05_TC06  extends TestBaseRapor {

    HomePage homePage;

    @Test
    public void Test01(){

        extentTest=extentReports.
                createTest("Anasayfa Baslık Goruntuleme Testi"," Anasayfada Smart Cart Link, Features ve About Smart Card bolum baslıkları gorulebilmelidir");


        //Ziyaretci Smart Card Link anasayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");

        //Smart Card Link  basligininin goruntulendigini dogrular.
        homePage=new HomePage();
        Assert.assertTrue(homePage.smartCardLinkBaslik.isDisplayed());
        extentTest.pass("Smart Card Link  basligininin goruntulendigini  test eder.");

        //Sayfayı asagıya kaydırır
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.featuresBaslik);
        extentTest.info("Sayfayı asagıya kaydirir");


        //Features  başligininin goruntulendigini dogrular.
        Assert.assertTrue(homePage.featuresBaslik.isDisplayed());
        extentTest.pass("Features  basligininin goruntulendigini test eder.");

        //Sayfayı asagıya kaydırır
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.aboutSmartCardBaslik);
        extentTest.info("Sayfayı asagıya kaydirir");

        //About Smart Card  başligininin goruntulendigini dogrular.

        Assert.assertTrue(homePage.aboutSmartCardBaslik.isDisplayed());
        extentTest.pass("About Smart Card  basligininin goruntulendigini test eder.");

        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");

    }

    @Test
    public void Test02(){

        extentTest=extentReports.
                createTest("Get Started Buton Testi","Get Started butonu tıklandıgında yeni hesap olusturma sayfasına yonlendirilmelidir");

        //Ziyaretci Smart Card Link anasayfasına gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");


        //Yeni hesap olusturmak icin Get Started butonuna tiklar.
        homePage=new HomePage();
        homePage.getSartedButon.click();
        extentTest.info("Yeni hesap olusturmak icin Get Started butonuna tiklar.");

        //Create an account sayfasinin açıldıgını dogrular.
        Assert.assertTrue(homePage.createAnAccountBaslik.isDisplayed());
        extentTest.pass("Create an account sayfasinin acıldıgını test eder.");

        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");
    }

    @Test
    public void Test03() {

        extentTest=extentReports.
                createTest("Anasayfa Plan Goruntuleme ve Secme Testi","Anasayfada Choose A Plan bolumunde tum plan secenekler goruntulenmeli ve  plan secimi yapılabilmelidir.");


        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");

        //Sayfayı asagıya kaydırır

        homePage=new HomePage();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.chooseAPlanBaslik);
        extentTest.info("Sayfayı asagıya kaydirir");


        //Choose a plan  basligininin goruntulendigini dogrular.
        Assert.assertTrue(homePage.chooseAPlanBaslik.isDisplayed());
        extentTest.pass("Choose a plan  basligininin goruntulendigini test eder.");


        //Secenekler arasinda gecis yapmak icin slide butonlarinin tıklanabildigini dogrular.

        Assert.assertTrue(homePage.slideNextButton.isEnabled());
        extentTest.pass("Secenekler arasinda gecis yapmak icin slidenext butonunun tıklanabildigini test eder.");

        Assert.assertTrue(homePage.slidePrevButton.isEnabled());
        extentTest.pass("Secenekler arasinda gecis yapmak icin slideprev butonunun tıklanabildigini test eder.");


        //Tum plan seceneklerinin gorundugunu dogrular.

        for (int i = 0; i <=homePage.planlarList.size()+1 ; i++) {
            Assert.assertTrue(homePage.seciliPlan.isDisplayed());
            jse.executeScript("arguments[0].click();", homePage.slideNextButton);
            ReusableMethods.bekle(1);
        }
        extentTest.pass("Tum plan seceneklerinin gorundugunu test eder.");

        // İstenilen planda Choose Plan butonunun tıklanabildigini dogrular.
        Assert.assertTrue(homePage.choosePlanButton.isEnabled());
        extentTest.pass("Istenilen planda Choose Plan butonunun tıklanabildigini test eder.");


        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");

    }

    @Test
    public void Test04(){

        extentTest=extentReports.
                createTest("Anasayfa Stories  Goruntuleme Testi","Anasayfada Stories from Our Customers bolumundeki tum stroyler goruntulebilmelidir.");


        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");

        //Sayfayı asagıya kaydırır
        homePage=new HomePage();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.bekle(1);
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.storySlideButton);
        extentTest.info("Sayfayı asagıya kaydirir");

        //Stories From Our Customers basligininin goruntulendigini dogrular.
        Assert.assertTrue(homePage.storiesBaslik.isDisplayed());
        extentTest.pass("Stories From Our Customers basligininin goruntulendigini test eder.");

        //Storyler arasinda gecis yapmak icin slide butonunun tıklanabildigini dogrular.
        Assert.assertTrue(homePage.storySlideButton.isEnabled());
        extentTest.pass("Storyler arasinda gecis yapmak icin slide butonunun tıklanabildigini test eder.");

        //Slide butonuna tıklar
        jse.executeScript("arguments[0].click();", homePage.storySlideButton);
        extentTest.info("Slide butonuna tıklar");

        //Tum storylerin gorundugunu dogrular.
        Actions actions=new Actions(Driver.getDriver());
        for (int i = 0; i <=homePage.storyList.size()+1 ; i++) {
            Assert.assertTrue(homePage.seciliPlan.isDisplayed());
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
        }
        extentTest.pass("Tum storylerin gorundugunu test eder.");

        //Sayfayi kapatir.
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");
    }


    @Test
    public void Test05(){

        extentTest=extentReports.
                createTest("Anasayfa Contact Message  Testi","Anasayfada Contact Us  bolumundeki tum bilgiler goruntulebilmeli ve mesaj yollanabilmelidir.");

        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");

        //Sayfayı asagıya kaydırır
        homePage=new HomePage();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.sendMessageButton);
        extentTest.info("Sayfayı asagıya kaydirir");

        //Contact Us  basligininin goruntulendigini dogrular.
        Assert.assertTrue(homePage.contactUsBaslik.isDisplayed());
        extentTest.pass("Contact Us  basligininin goruntulendigini test eder.");

        //Email ve telefon iletişim linklerinin aktif oldugunu dogrular.
        Assert.assertTrue(homePage.infoMailLink.isEnabled());
        extentTest.pass("Email iletişim linkinin aktif oldugunu test eder.");
        Assert.assertTrue(homePage.telContactLink.isEnabled());
        extentTest.pass("Telefon iletişim linkinin aktif oldugunu test eder.");

        //Adress bilgisinin gorundugunu dogrular.
        Assert.assertTrue(homePage.adress.isDisplayed());
        extentTest.pass("Adress bilgisinin gorundugunu test eder.");

        //Mesaj gondermek icin gerekli bilgileri doldurur.
        Faker faker=new Faker();
        homePage.contactNameBox.sendKeys(faker.name().firstName());
        homePage.contactEmailBox.sendKeys(faker.internet().emailAddress());
        homePage.contactSubjectBox.sendKeys("Subject");
        homePage.contactMessageBox.sendKeys("Message");
        extentTest.info("Mesaj gondermek icin gerekli bilgileri doldurur");

        ReusableMethods.bekle(2);

        //Send message butonuna tıklanabildigini dogrular.
        jse.executeScript("arguments[0].click();", homePage.sendMessageButton);
        Assert.assertTrue(homePage.sendMessageButton.isEnabled());
        extentTest.pass("Send message butonuna tıklanabildigini test eder.");


        //Sayfayi Kapatir
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");
    }

    @Test
    public void Test06(){

        extentTest=extentReports.
                createTest("Anasayfa Subscribe  Testi","Anasayfada Subscribe olmak icin mail adersi girilip subscribe butonuna tıklanabilmelidir. ");

        //Ziyaretci Smart Card Link sitesine gider.
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Ziyaretci SmartCardLink anasayfasina gider");

        //Sayfayı asagıya kaydırır
        homePage=new HomePage();
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", homePage.subscribeEmailBox);
        extentTest.info("Sayfayı asagıya kaydirir");

        //Subscribe  basligininin goruntulendigini dogrular.
        Assert.assertTrue(homePage.subscribeBaslik.isDisplayed());
        extentTest.pass("Subscribe  basligininin goruntulendigini test eder.");

        //Abone olmak için mail adresi bilgisi girer.
        jse.executeScript("arguments[0].click();", homePage.subscribeEmailBox);
        Faker faker=new Faker();
        homePage.subscribeEmailBox.sendKeys(faker.internet().emailAddress());
        extentTest.info("Abone olmak için mail adresi bilgisi girer.");
        ReusableMethods.bekle(1);

        //Subscribe butonunun tıklanabilir oldugunu dogrular.
        Assert.assertTrue(homePage.subscribeButton.isEnabled());
        extentTest.pass("Subscribe butonunun tıklanabilir oldugunu test eder.");
        jse.executeScript("arguments[0].click();", homePage.subscribeButton);

        //Subscribe işleminin başari ile gerceklestigini dogrular.
        ReusableMethods.bekle(1);
        Assert.assertTrue(homePage.subscribeSuccessText.isEnabled());
        extentTest.pass("Subscribe işleminin başari ile gerceklestigini test eder.");

        //Sayfayi Kapatir
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatir.");
    }

}
