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

public class US004_FaqTest extends TestBaseRapor {
    @Test
    public void US004_Faq() {
        extentTest = extentReports.createTest("FAQ sayfası testi","Linke tıklandığında açılan sayfanın FAQ sayfası oldugu test edilir.");
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        String homePageWhd = Driver.getDriver().getWindowHandle();
        FooterPage footerPage = new FooterPage();

        Actions actions = new Actions(Driver.getDriver());
        actions.click();
        ReusableMethods.bekle(2);
        actions.sendKeys(Keys.END).perform();
        extentTest.info("Sayfanın footer bölümüne gider");

        ReusableMethods.bekle(2);
        Driver.getDriver().switchTo().window(homePageWhd);
        actions.sendKeys(Keys.END).perform();
        footerPage.faq.click();
        extentTest.info("FAQ sayfası linkline tıklar.");
        String faqWhd = "";
        Set<String> whdSeti = Driver.getDriver().getWindowHandles();
        for (String each : whdSeti
        ) {
            if (!each.equals(homePageWhd)) {
                faqWhd = each;
            }
        }
        Driver.getDriver().switchTo().window(faqWhd);
        extentTest.info("Açılan sekmeye geçer");
        String expectedUrl = "https://qa.smartcardlink.com/faq";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Url FAQ degil");
        extentTest.pass("Açılan sayfanın FAQ sayfası oldugunu test eder");
        Driver.getDriver().close();
    }
}
