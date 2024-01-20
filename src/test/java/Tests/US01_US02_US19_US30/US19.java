package Tests.US01_US02_US19_US30;
import Pages.Admin.AdminUsersPage;
import Pages.Users.HomePage;
import Pages.Users.LoginPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class US19 extends TestBaseRapor{

    Driver driver;
    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    AdminUsersPage adminUsersPage=new AdminUsersPage();
    Actions actions=new Actions(Driver.getDriver());
    Robot robot=new Robot();
    Faker faker=new Faker();

    public US19() throws AWTException {

    }

    @Test(priority = 1)
    public void testKullaniciAktifllik(){
    extentTest=extentReports.createTest("Admin Kullanici sayfasinda gider","Kullanici aktiflik durumu goruntulenebilmeli");
//  Tarayici ile ilgili site acilir
    Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
    extentTest.info("Kullanici Anasayfaya gider");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
    Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();
    extentTest.info("Kullanici Dashboard sekmesine gider");
    loginPage.emailBox.sendKeys(ConfigReader.getProperty("admin"));
    loginPage.passwordBox.sendKeys(ConfigReader.getProperty("sifre"));
    loginPage.loginButton.click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");
//        Kullanicilar bolumune girilir
    adminUsersPage.users.click();
        extentTest.info("Users sekmesine gidilir");
//        Bolumundeki Kullanici sayi yazisi goruntulenir
//        System.out.println(adminUsersPage.accountCount.getText());
        extentTest.info("Kayitli kullanici sayisi goruntulenir");
//        Herhangi bir Kullanici aktif durumu goruntulenir

    Assert.assertTrue(adminUsersPage.isActive.isEnabled());
        extentTest.info("Kayitli kullanici sayisi goruntulenir");
//        Bir kullanicinin bilgilerini goruntulenir
    adminUsersPage.userfirst.click();
        extentTest.info("Herhangi bir kullanici bilgisi goruntulenir");
//        Bilgilerin goruntulendigi dogrulenir

        Assert.assertTrue(adminUsersPage.userDetailsTitle.isDisplayed());
        extentTest.info("Kullanicinin bilgilerinin goruntulendigi dogrulanir");
//        Tarayici Kapanir
     Driver.closeDriver();
        extentTest.info("Tarayici kapanir");
    }
    @Test (priority = 2)
    public void testKullaniciBilgisi() throws InterruptedException {
        extentTest=extentReports.createTest("Admin Kullanici sayfasinda gider","Kullanici bilgileri degistirilebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici Anasayfaya gider");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();
        extentTest.info("Kullanici Dashboard sekmesine gider");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin kullanici bilgileri ile giris yapilir");

        //Users sekmesine gider
        Driver.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/ul/li[3]/a")).click();
        extentTest.pass("Users sekmesine gider");
//      Gecici hesap olusturmak icin New User sekmesine tiklar
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/a")).click();
//      Gecici hesap bilgileri girilir ve kaydedilir
        extentTest.pass("Gecici hesap olusturmak icin New User sekmesine gider");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userFirstName\"]")).sendKeys("tiri");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userLastName\"]")).sendKeys("viri");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(faker.internet().emailAddress());

        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Qw123456");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cPassword\"]")).sendKeys("Qw123456");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userCreateForm\"]/div/div[9]/input")).click();
        extentTest.pass("Gecici hesap bilgileri girilir ve kaydedilir");
//      ecici hesap arama kisminda aratilir
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("tiri");
        extentTest.info("Gecici hesap arama kisminda aratilir");

//        Duzenlemek kismina tiklanir
        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div/a[2]")).click();
        extentTest.info("Admin duzenleme kismina tiklair");
//        Kullanici  bilgisi degistirilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userFirstName\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userFirstName\"]")).sendKeys("ali");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"userLastName\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userLastName\"]")).sendKeys("nazik");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(faker.internet().emailAddress());

        Driver.getDriver().findElement(By.xpath("//*[@id=\"phoneNumber\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys("2124445566");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"userEditForm\"]/div/div[5]/div/span/span[1]/span")).click();
//        Driver.getDriver().findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("stan");

        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).click();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ENTER).click();



        Driver.getDriver().findElement(By.xpath("//*[@id=\"profileImageIcon\"]")).click();

       // String path=System.getProperty(("user.dir")+"\\Pages\\Admin\\ikon.jpg");


        StringSelection ss=new StringSelection("150-4.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);

        robot.delay(1000);
        //C:\Users\dcsek\Desktop\icon_68.png
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(1000);

//      String ImagePath=System.getProperty("user.home")+"src/test/java/Pages/Admin/icon_2_32.jpg";
//      WebElement profileImage=Driver.getDriver().findElement(By.id("profileImageIcon"));
//      profileImage.sendKeys(ImagePath);


        Driver.getDriver().findElement(By.xpath("//*[@id=\"userEditForm\"]/div/div[7]/input")).click();
        extentTest.info("formdaki ilgili yerler doldurulur ve kaydedilir");
//     Kullanici  bilgi degisimi dogrulanir
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).clear();
        Driver.getDriver().findElement(By.xpath("//div/div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("ali na");
        Thread.sleep(1000);
        extentTest.info("Hesap adi arama sekmesinde aratilir");
        String expIcerik="ali n";
        String actIcerik=Driver.getDriver().findElement(By.xpath("//div/div/div/div[5]/table/tbody/tr[1]/td[1]/div/div/a")).getText();
        Assert.assertTrue(actIcerik.contains(expIcerik));
        extentTest.info("Hesap adininin listede oldugu teyit edilir");

        Driver.getDriver().findElement(By.xpath("//div/div/div/div[5]/table/tbody/tr[1]/td[6]/div/a[3]")).click();
        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]")).click();

//        Tarayici Kapanir

        Driver.closeDriver();
        extentTest.info("Tarayici kapanir");

    }
    @Test (priority = 3)
    public void testKullaniciSifre() throws InterruptedException {
        extentTest=extentReports.createTest("Admin Kullanici sayfasinda gider","Kullanici sifresi degistirilebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici Anasayfaya gider");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();
        extentTest.info("Kullanici Dashboard sekmesine gider");


        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.info("Admin olmak icin bilgileri girer");
//        Herhangi bir Kullanici secilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/ul/li[3]/a")).click();
        extentTest.info("Admin Users sekmesine tiklar");
//        Sifre degistir ikonuna tiklanir
        Driver.getDriver().findElement(By.xpath("//tbody/tr[1]/td[6]/div/a[1]")).click();
        extentTest.info("Admin ilk kullanicinin change password sekmesine  tiklar");


//        Yeni sifre girilir
        Thread.sleep(1000);

//      adminUsersPage.newPasswordFirst.sendKeys("Qw112233");
        WebElement sifre=Driver.getDriver().findElement(By.xpath("(//*[@id=\"new_password\"])[2]"));
        sifre.sendKeys("Qa112233");
//      adminUsersPage.newPasswordConfirm.sendKeys("Qw112233");
        WebElement sifretkrr=Driver.getDriver().findElement(By.xpath("(//*[@id=\"confirm_password\"])[2]"));
        sifretkrr.sendKeys("Qa112233");
//      adminUsersPage.newPasswordSave.click();
        WebElement savebtn=Driver.getDriver().findElement(By.xpath("//*//button[@id='UserPasswordChangeBtn']"));
        savebtn.click();

        Thread.sleep(1000);
        extentTest.info("Admin kullanicinin yeni sifre bigilerini girer");

//        Sifre degimi onaylanir
    WebElement savealert=Driver.getDriver().findElement(By.xpath("//*[text()='Success']"));

    Assert.assertTrue(savealert.isDisplayed());
        extentTest.info("Sifre degisimi onaylanir");
//        Tarayici Kapanir
        Driver.closeDriver();
        extentTest.info("Tarayici kapanir");
    }
    @Test (priority = 4)
    public void testHesapOlusturSil() throws InterruptedException {
        extentTest=extentReports.createTest("Admin Kullanici sayfasinda gider","Yeni hesap olusturulabilmeli ve silinebilmeli");
//        Tarayici ile ilgili site acilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici Anasayfaya gider");
//        Dashboard a tiklanir,Admin bilgileri ile hesaba giris yapilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"navbarNav\"]/d/a")).click();
        extentTest.info("Kullanici Dashboard sekmesine gider");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(ConfigReader.getProperty("admin"));
        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(ConfigReader.getProperty("sifre"));
        Driver.getDriver().findElement(By.xpath("/html/body/div/div[2]/div[3]/form/div[4]/button")).click();
        extentTest.pass("Admin olmak icin bilgileri girer");
        //       Users sekmesine gidilir
        Driver.getDriver().findElement(By.xpath("//*[@id=\"sidebar\"]/div[2]/ul/li[3]/a")).click();
        extentTest.info("Users sekmesine tiklanilir");
//        Add User sekmesine tiklanilir
        //Driver.getDriver().findElement(By.xpath("//div/div[1]/div/div[2]/div/div[4]/div[1]/a")).click();
        Thread.sleep(1000);
//        adminUsersPage.addUserbutonu.click();
        Driver.getDriver().findElement(By.xpath("//*[text()='Add User']")).click();
        extentTest.info("Add User sekmesine tiklanilir");
//        Ilgili yerler doldurulur ve kaydedilir

        Driver.getDriver().findElement(By.xpath("//*[@id=\"userFirstName\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userFirstName\"]")).sendKeys("dladla");

        //adminUsersPage.newFirstName.sendKeys("blabla");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userLastName\"]")).clear();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userLastName\"]")).sendKeys("flanca");
//        adminUsersPage.newLastName.sendKeys("flanca");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.xpath("//*[@id=\"phoneNumber\"]")).sendKeys("2124443322");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Qa112233");
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cPassword\"]")).sendKeys("Qa112233");

        Driver.getDriver().findElement(By.xpath("//*[@id=\"cPassword\"]")).click();



//        adminUsersPage.editPlan.click();
        Thread.sleep(1000);

        WebElement plan=Driver.getDriver().findElement(By.xpath("//*[@id=\"select2-plan-container\"]"));
        plan.click();
        WebElement plansec=Driver.getDriver().findElement(By.xpath("/html/body/span/span/span[1]/input"));
        plansec.sendKeys("stand");
        actions.sendKeys(Keys.ENTER).click();

        robot.delay(1000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"profileImageIcon\"]")).click();

        StringSelection ss=new StringSelection("150-4.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);


        robot.delay(1000);
        //C:\Users\dcsek\Desktop\icon_68.png
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.delay(2000);

        //String Imagefile=System.getProperty("user.dir")+"//src//test//java/Pages//Admin//ikon.jpg";
        //adminUsersPage.editImage.sendKeys(Imagefile);

        //adminUsersPage.newUserSave.click();
        Driver.getDriver().findElement(By.xpath("//*[@id=\"userCreateForm\"]/div/div[9]/input")).click();
        extentTest.pass("Yeni hesap icin ilgil yerler doldurulur ve kaydedilir");

        WebElement usersaveApprove=Driver.getDriver().findElement(By.xpath("//div[1]/div/div[3]/div[2]/div/div[1]/div/div[1]"));
//        Yeni hesap acildigi dogrulanir
        Assert.assertTrue(usersaveApprove.isDisplayed());
        extentTest.pass("Yeni hesap acildigi dogrulanir");

//        acilan hesap aratilir
        Thread.sleep(1000);
       // Driver.getDriver().findElement(By.xpath("//div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("dladla");
       // extentTest.pass("Yeni hesap arama sekmesinde aratilir");
        ReusableMethods.bekle(2);
        //Hesap silinir
        Driver.getDriver().findElement(By.xpath("//tbody/tr/td[6]/div/a[3]")).click();
//        adminUsersPage.deleteButton.click();
        Driver.getDriver().findElement(By.xpath("/html/body/div[4]/div/div[4]/div[1]/button")).click();
//        adminUsersPage.delete_Yes_Delete.click();
        extentTest.pass("Yeni hesap silinir");
//        Hesap silmesi dogrulanir
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("//div/div/div[4]/div[1]/div[1]/form/div/input")).clear();
        //Driver.getDriver().findElement(By.xpath("//div/div/div[4]/div[1]/div[1]/form/div/input")).sendKeys("dladla");

        Thread.sleep(3000);
        String expIcerik="dladla";
        String actIcerik=Driver.getDriver().findElement(By.xpath("(//*[@class='mb-1 text-decoration-none fs-6'])[1]")).getText();

        Assert.assertFalse(actIcerik.equals(expIcerik));
        extentTest.pass("Hesabin silindigi dogrulanir");
//        Tarayici Kapanir
        Driver.closeDriver();
        extentTest.pass("Tarayici kapanir");
    }
}
