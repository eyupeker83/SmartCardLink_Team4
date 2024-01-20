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

public class US004_TwitterTest extends TestBaseRapor {
    @Test
    public void us004_Twitter(){
        extentTest = extentReports.createTest("TermsOfConditions Testi","Sayfanın footer bölümünde TermsOfConditions linkine tıklanablmeli ve doğru linke yönlendirilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        String homePageWhd=Driver.getDriver().getWindowHandle();
        FooterPage footerPage=new FooterPage();

        Actions actions=new Actions(Driver.getDriver());
        actions.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın footer bölümüne gider");
        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().window(homePageWhd);
        extentTest.info("Twitter iconuna tiklar");
        footerPage.twitterIcon.click();
        String twitterWhd = "";
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(homePageWhd)){
                twitterWhd = each;
            }
        }
        extentTest.info("Yan sekmede acilan sayfaya gider");
        Driver.getDriver().switchTo().window(twitterWhd);
        String expectedUrl="https://www.twitter.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url twitter degil");
        extentTest.pass("Açılan sayfanın Twitter oldugunu test eder");
        Driver.getDriver().close();
    }
}
