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

public class US004_PrivacyPolicyTest extends TestBaseRapor {
    @Test
    public void US004_PrivacyPolicy(){
        extentTest = extentReports.createTest("PrivacyPolicy Testi","Sayfanın footer bölümünde PrivacyPolicy linkine tıklanablmeli ve doğru linke yönlendirilmeli");
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
        extentTest.info("PrivacyPolicy linkine tiklar");
        footerPage.privacyPolicy.click();
        String privacyPolicyWhd = "";
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(homePageWhd)){
                privacyPolicyWhd = each;
            }
        }
        extentTest.info("Yan sekmede acilan sayfaya gider");
        Driver.getDriver().switchTo().window(privacyPolicyWhd);
        String expectedUrl="https://qa.smartcardlink.com/privacy-policy";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl,"Url Privacy Policy degil");
        extentTest.pass("Açılan sayfanın Privacy Policy oldugunu test eder");
        Driver.getDriver().close();
    }
}

