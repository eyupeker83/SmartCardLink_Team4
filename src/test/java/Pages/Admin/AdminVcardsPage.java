package Pages.Admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminVcardsPage {

    public AdminVcardsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a[@class='nav-link d-flex align-items-center py-3'])[4]")
    public WebElement vCardsTab;

    @FindBy(xpath = "//div[@class='d-flex flex-column table-striped']")
    public WebElement userVCardsTable;

    @FindBy(xpath = "//div[@class='text-muted ms-sm-3 pagination-record']")
    public WebElement numberOfVCardsResult;

    @FindBy(xpath = "(//td//a)[4]")
    public WebElement firstCardStatsButton;

    @FindBy(xpath = "//div[@id='weeklyUserBarChartContainer']")
    public WebElement vCardAnalyticTable;

    @FindBy(xpath = "(//a[@class='text-decoration-none fs-6'])[2]")
    public WebElement lastVCardPreviewUrlElement;

    @FindBy(xpath = "(//a[@class='text-decoration-none fs-6'])[1]")
    public WebElement lastCreatedVCardName;

}
