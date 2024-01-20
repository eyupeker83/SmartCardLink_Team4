package Tests.US01_US02_US19_US30;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US01 extends TestBaseRapor {
    @Test
    public void test(){
        extentTest=extentReports.createTest("QasmartLink Testi","Kullanici QAsmartLink sayfasina ulasabilmeli");
//    Browser acilir

//    https://www.qasmartcardlink.com/  adresine gidilir
        Driver.getDriver().get(ConfigReader.getProperty("smartCardLink"));
        extentTest.info("Kullanici Websitesine gider");
//    sayfanin goruntulendigi dogrulanir
        System.out.println(Driver.getDriver().getTitle());
      extentTest.info("Sayfanin goruntulendigi dogrulanir");

//    Tarayici kapanir
        Driver.closeDriver();
        extentTest.info("Sayfayi Kapatir");

    }
}