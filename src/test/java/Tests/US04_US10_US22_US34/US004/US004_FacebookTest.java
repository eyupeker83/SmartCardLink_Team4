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

public class US004_FacebookTest extends TestBaseRapor {
    String homePageWhd=Driver.getDriver().getWindowHandle();
    @Test (priority = 1)
    public void us004_Facebook() {
        extentTest = extentReports.createTest("Facebook Testi","Sayfanın footer bölümünde facebook iconuna tıklanablmeli ve doğru linke yönlendirilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        String homePageWhd=Driver.getDriver().getWindowHandle();
        FooterPage footerPage=new FooterPage();

        Actions actions=new Actions(Driver.getDriver());
        actions.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın footer bölümüne gider");

        ReusableMethods.bekle(2);
        footerPage.faceBookIcon.click();
        extentTest.info("Facebook iconuna tıklar");
        String facebookWhd = "";
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(homePageWhd)){
                facebookWhd = each;
            }
        }
        Driver.getDriver().switchTo().window(facebookWhd);
        extentTest.info("Yan sekmede açılan sayfanın window handle ına gecer");
        String expectedUrl="https://www.facebook.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        extentTest.info("Acılan sayfanın facebook url si oldugunu dogrular");
        Assert.assertEquals(actualUrl,expectedUrl,"Url Facebook degil");
        Driver.getDriver().close();
        extentTest.pass("Açılan sayfanın facebook oldugunu test eder.");


    }





}
