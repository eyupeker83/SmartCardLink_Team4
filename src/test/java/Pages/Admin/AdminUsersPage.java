package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminUsersPage {
    public AdminUsersPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Users']")
    public WebElement users; //users sekmesi

    @FindBy(xpath = "//div/nav/ul/li[2]/span")
    public WebElement page1; //sayfa 1

    @FindBy(xpath = "//div/nav/ul/li[3]/button")
    public WebElement page2; //sayfa 2
    //Dinamik sayfa
    public String sayfa_Any(int userEdit_Any_sira){
        String sayfa_Any="//div/nav/ul/li["+userEdit_Any_sira+"]/button";

        return sayfa_Any;
    }
    @FindBy(xpath = "//div/nav/ul/li[15]/button")
    public WebElement pageNext; //sonraki sayfa

    @FindBy(xpath = "//div/nav/ul/li[1]/button")
    public WebElement pagePrevious; //onceki sayfa

    @FindBy(xpath = "//*[@type='search']")
    public WebElement searchbutonu; //search sekmesi

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div/div/div/div/div[4]/div[1]/a")
    public WebElement addUserbutonu; // kullanici ekle

    @FindBy(xpath = "//*[@id=\"userFirstName\"]")
    public WebElement newFirstName; //yeni kullanici ismi

    @FindBy(xpath = "//*[@id=\"userLastName\"]")
    public WebElement newLastName; // yeni kullanici soyismi

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement newEmail; // yeni kullanici emaili

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    public WebElement newPhone; // yeni kullanici telefonu

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement newPassword; // yeni kullanici sifre

    @FindBy(xpath = "//*[@id=\"cPassword\"]")
    public WebElement newPasswordVerify; // yeni kullanici sifre dogrulama

    @FindBy(xpath = "//*[@id=\"select2-plan-container\"]")
    public WebElement newPlan; // yeni kullanici plani

    @FindBy(xpath = "//div/div[8]/div/div/div/div/span")
    public WebElement newAvatar; // yeni kullanici avatari

    @FindBy(xpath = "//*[@id=\"userCreateForm\"]/div/div[9]/input")
    public WebElement newUserSave; // yeni kullanici kayit

    @FindBy(xpath = "//div[1]/div/div[3]/div[2]/div/div[1]/div/div[1]")
    public WebElement newUserSaveApproved; // yeni kullanici kayit onay

    @FindBy(xpath ="//*[text()='Full Name']")
    public WebElement arrangeName_Full_Name; //kullanicilari ismie gore sirala

    @FindBy (xpath = "//tbody/tr[1]/td[1]/div/a/div/img")
    public WebElement  userfirst; // listenin basindaki ilk kullanici
    //Dinamik kullanici secimi icin
    public String userDynamic_Any(int kullanici_sira){
        String userDynamic_Any="//tbody/tr["+kullanici_sira+"]/td[1]/div/a/div/img";

    return userDynamic_Any;
    }
    @FindBy (xpath = "/html/body/div[1]/div/div[3]/div[2]/div[1]/div/h1")
    public WebElement  userDetailsTitle; // listenin basindaki ilk kullanici

    @FindBy(xpath = "//tbody/tr[1]/td[6]/div/a[2]")
    public WebElement userfirstEdit; // ilk kullanicin bilgilerini duzenler
    //Dinamik userEdit
    public String userEditDynamic_Any(int userEdit_Any_sira){
        String userEditDynamic_Any="//tbody/tr["+userEdit_Any_sira+"]/td[6]/div/a[2]";

        return userEditDynamic_Any;
    }

    @FindBy(xpath = "//tbody/tr[1]/td[2]/span")
    public WebElement currentPlan; // gecerli plan
    //Dinamik currentPlan
    public String currentPlanDynamic_Any(int plan_sira){
            String cPlanDynamic_Any="//tbody[1]/tr["+plan_sira+"]/td[2]/span[1]";

    return cPlanDynamic_Any;
  }

    @FindBy(xpath = "//tbody[1]/tr[1]/td[3]/label[1]")
    public WebElement emailVerify; //email dogrulama checkbox
    //Dinamik email
    public String emailVerifyDynamic_Any(int email_sira){
        String emailVerifyDynamic_Any="//tbody[1]/tr["+email_sira+"]/td[3]/label[1]";

        return emailVerifyDynamic_Any;
    }

    @FindBy(xpath = "//tbody/tr[1]/td[4]/div")
    public WebElement impersonateDugme; //impersonate sekmesi
    //Dinamik impersonate
    public String impersonateDynamic_Any(int impersonate_sira){
        String impersonateDynamic_Any="//tbody/tr["+impersonate_sira+"]/td[4]/div";

        return impersonateDynamic_Any;
    }

    @FindBy(xpath = "//tbody/tr[1]/td[5]/label/span")
    public WebElement isActive; // is active checkbox
    //Dinamik isActive
    public String isActiveDynamic_Any(int isActive_sira){
        String isActiveDynamic_Any="//tbody/tr["+isActive_sira+"]/td[5]/label/";

        return isActiveDynamic_Any;
    }

    @FindBy(xpath = "//tbody[1]/tr[1]/td[6]/div[1]/a[3]/*[name()='svg'][1]")
    public WebElement deleteButton; //delete butonu
    //Dinamik Delete
    public String deleteDynamic_Any(int delete_sira){
        String deleteDynamic_Any="//tbody[1]/tr["+delete_sira+"]/td[6]/div[1]/a[3]/*[name()='svg'][1]";

        return deleteDynamic_Any;
    }
    @FindBy(xpath = "//tbody[1]/tr[1]/td[6]/div[1]/a[1]/*[name()='svg'][1]")
    public WebElement changePasswordbutton; // sifre degistir butonu
    //Dinamik changePassword
    public String changePasswordDynamic_Any(int isActive_sira){
        String changePasswordDynamic_Any="//tbody[1]/tr["+isActive_sira+"]/td[6]/div[1]/a[1]/*[name()='svg'][1]";

        return changePasswordDynamic_Any;
    }

    @FindBy(xpath = "(//*[@id=\"new_password\"])[2]")
    public WebElement newPasswordFirst; // sifre degistirme islemi sonrasi yeni sifre formu


    @FindBy(xpath = "(//*[@id=\"confirm_password\"])[2]")
    public WebElement newPasswordConfirm; // sifre degistirme islemi sonrasi yeni sifre onay formu

    @FindBy(xpath = "//*//button[@id='UserPasswordChangeBtn']")
    public WebElement newPasswordSave; // yeni sifre kayit

    @FindBy(xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]")
    public WebElement newPasswordSaveApproved; // yeni sifre kayit onayi

    @FindBy(xpath = "//form[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement editFirstName; //Edit bolumu isim bolumu

    @FindBy(xpath = "//form[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement editLastName; //Edit bolumu soy isim bolumu

    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement editEmail;  //Edit bolumu eposta

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    public WebElement editPhone; //Edit bolumu telefon

    @FindBy(xpath = "//*[@id=\"select2-plan-container\"]")
    public WebElement editPlan; //Edit bolumu plan

    @FindBy(xpath = "/html/body/span/span/span[1]/input")
    public WebElement editPlanTextArea; //Edit bolumu plan

    @FindBy(xpath = "//*[@title=\"Standard\"]")
    public WebElement editPlanStandard;  //standard plan

    @FindBy(xpath = "//*[@title=\"Silver\"]")
    public WebElement editPlanSilver; //silver plan

    @FindBy(xpath = "//*[@title=\"Gold\"]")
    public WebElement editPlanGold; //gold plan

    @FindBy(xpath = "//*[@title='Unlimited']")
    public WebElement editPlanUnlimited; //unlimited plan

    @FindBy(xpath = "//*[@title='VIP']")
    public WebElement editPlanVip; //vip plan

    @FindBy(xpath = "//*[@id='profileImageIcon']")
    public WebElement editImage; // yeni image

    @FindBy(xpath = "//*[@id=\"userEditForm\"]/div/div[7]/input")
    public WebElement editUserSave; //duzenleme sonrasi kayit butonu

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div[2]/div/div[1]/div/div[1]")
    public WebElement editSaveAlert; //duzenleme sonrasi kayit onayi

    @FindBy(xpath = "/html/body/div[4]/div/div[4]/div[1]")
    public WebElement delete_Yes_Delete; // kullanici silme butonu

    @FindBy(xpath = "//div[@class='swal-text']")
    public WebElement delete_approved; //kullanici silme islemi onay

    @FindBy(xpath = "//*/strong[3]")
    public WebElement accountCount; // sayfadaki kullanici sayisi

    @FindBy(xpath = "//*[@id=\"perPage\"]")
    public WebElement userCountShow; // sayfadaki kullanici sayisi gosterim degisimi

    @FindBy(xpath = "//*[@*='btn btn-outline-primary float-end']")
    public WebElement backButonu;


}
