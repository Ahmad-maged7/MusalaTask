package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JobDetailsPage extends PageBase{
    public JobDetailsPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait= new WebDriverWait(driver,20);
    @FindBy(xpath = "//div[@class='entry-content']//div[1]//div[1]//div[2]")
    public WebElement generalDescription;
    @FindBy(xpath = "//div[@class='entry-content']//div[1]//div[2]//div[2]")
    public WebElement requirements;
    @FindBy(xpath = "//div[@class='entry-content']//div[2]//div[1]//div[2]")
    public WebElement responsibilities;
    @FindBy(xpath = "//div[@class='content']//div[2]//div[2]//div[2]")
    public WebElement whatWeOffer;
    @FindBy(xpath = "//input[@value='Apply']")
    public WebElement applyBtn;
    @FindBy(id = "join_us_form")
    public WebElement applyForm;
    @FindBy(name = "your-name")
    WebElement nameField;
    @FindBy(name = "your-email")
    WebElement emailField;
    @FindBy(name = "mobile-number")
    WebElement mobileNumberField;
    @FindBy(id = "uploadtextfield")
    WebElement cvField;
    @FindBy(xpath = "//input[@value='Send']")
    public WebElement sendBtn;
    @FindBy(xpath = "//*[@id=\"wpcf7-f880-o1\"]/form/div[4]/p/span")
    public WebElement spinner;
    @FindBy(xpath = "//div[@class='wpcf7-response-output']")
    public WebElement errorPopup;
    @FindBy(className = "close-form")
    public WebElement closeErrorPopup;
    String name = "Ahmad Maged";
    String invalidEmail= "test@test";
    String number= "01234567890";


    public void clickApply()
    {
        wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
        applyBtn.click();
    }
    public void fillAllFieldsAndWithInvalidEmail()
    {
        wait.until(ExpectedConditions.visibilityOf(applyForm));
        nameField.sendKeys(name);
        emailField.sendKeys(invalidEmail);
        mobileNumberField.sendKeys(number);
        cvField.sendKeys(System.getProperty("user.dir") + "/src/test/java/Data/AhmadMaged_Skill_Form_qa.pdf");
        sendBtn.click();
    }

}