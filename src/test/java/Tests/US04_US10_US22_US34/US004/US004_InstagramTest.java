package Tests.US04_US10_US22_US34.US004;

import Pages.Users.FooterPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.Set;

public class US004_InstagramTest extends TestBaseRapor {
    @Test
    public void us004_Instagram(){
        extentTest = extentReports.createTest("Instagram Testi","Sayfanın footer bölümünde instagram iconuna tıklanablmeli ve doğru linke yönlendirilmeli");        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        String homePageWhd=Driver.getDriver().getWindowHandle();
        FooterPage footerPage=new FooterPage();

        Actions actions=new Actions(Driver.getDriver());
        actions.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın footer bölümüne gider");

        ReusableMethods.bekle(2);
        extentTest.info("Instagram iconuna tiklar");
        footerPage.instagramIcon.click();
        String instagramWhd = "";
        Set<String> whdSetiInstagram = Driver.getDriver().getWindowHandles();
        for (String each : whdSetiInstagram
        ) {
            if (!each.equals(homePageWhd)){
                instagramWhd = each;
            }
        }
        Driver.getDriver().switchTo().window(instagramWhd);
        extentTest.info("yan sekmede acilan sayfaya gider");
        String expectedUrl="https://www.instagram.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url instagram degil");
        extentTest.pass("Açılan sayfanın instagram oldugunu test eder");
        Driver.getDriver().close();
    }
}
