package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VirtualBackGroundsPage {

    public VirtualBackGroundsPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@class='downlod-ecards-1 ecard-image'])[2]")
    public WebElement backGroundsImg01;// Virtual Backgrounds sayfasında 1. sırada listelenen arka plan
}
