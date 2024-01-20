package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignOutPage {

    public SignOutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='dropdownMenuButton1']") //sağ üst kullanıcı bilgileri butonu
    public WebElement usersButton;

    @FindBy(xpath = "//*[@class='dropdown-item text-gray-900 d-flex']") //Sign Out butonu
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@type='submit']") //Login butonu (cikis yapilabildigini dogrular)
    public WebElement loginButton;

    @FindBy(xpath = "//*[@*='svg-inline--fa fa-right-from-bracket']") //Sign Out butonu
    public WebElement signOutButton2;

}
