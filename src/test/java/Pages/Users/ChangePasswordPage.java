package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class ChangePasswordPage {

    public ChangePasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id='dropdownMenuButton1']") //sağ üst kullanıcı bilgileri butonu
    public WebElement usersButton;

    @FindBy(id = "changePassword") // Change Password butonu
    public WebElement changePasswordButton;

    @FindBy(xpath = "(//*[@class='form-control'])[2]") //Current Password kutusu
    public WebElement currentPasswordBox;

    @FindBy(xpath = "(//*[@class='form-control'])[3]") //New Password kutusu
    public WebElement newPasswordBox;

    @FindBy(xpath = "(//*[@class='form-control'])[4]") //Confirm Password kutusu
    public WebElement confirmPassword;

    @FindBy(id = "passwordChangeBtn") //Save butonu
    public WebElement saveButton;

    @FindBy(xpath = "(//*[@class='btn btn-secondary my-0 ms-5 me-0'])[2]") //Discard butonu
    public WebElement discardButton;

    @FindBy(xpath = "//div[@class='toast-title']") //sifre degisikligi dogrulama elementi
    public WebElement successAlert;

}
