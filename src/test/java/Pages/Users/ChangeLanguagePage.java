package Pages.Users;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ChangeLanguagePage {

    public ChangeLanguagePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "dropdownMenuButton1") //sag üst kullanıcı bilgileri butonu
    public WebElement usersButton;

    @FindBy(id = "changeLanguage") //dil degisikligi butonu
    public WebElement changeLanguageButton;

    @FindBy(xpath = "//span[@role='combobox']") // language dropdown menu butonu
    public WebElement languageDropdown;

    @FindBy(xpath = "//*[@role='option']")
    public List<WebElement> languageList;

    @FindBy(id = "languageChangeBtn") //Save butonu
    public WebElement saveButton;

    @FindBy(xpath = "(//*[text()='Discard'])[2]") //Discard butonu
    public WebElement discard;

    @FindBy(xpath = "//div[@class='toast-title']") //Dil degisikligi dogrulama elementi
    public WebElement successAlert;

    @FindBy(xpath = "//*[@class='toast-close-button']") //dil degisikligi alert kapatma butonu
    public WebElement alertCloseButton;

    public void TC_02(){
        usersButton.click();
        changeLanguageButton.click();
        languageDropdown.click();
    }


}
