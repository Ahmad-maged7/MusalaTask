package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver,20);
    @FindBy(xpath = "//ul[@id='menu-main-nav-1']//a[@class='main-link'][normalize-space()='Company']")
    WebElement companyBtn;
    @FindBy(xpath = "//ul[@id='menu-main-nav-1']//a[@class='main-link'][normalize-space()='Careers']")
    WebElement careersBtn;

    @FindBy(xpath = "//button[@class='contact-label btn btn-1b']")
    public WebElement contactUsBtn;
    @FindBy(id = "fancybox-content")
    WebElement contactUsForm;
    @FindBy(name = "your-name")
    WebElement nameField;
    @FindBy(name = "your-email")
    public WebElement emailField;
    @FindBy(name = "mobile-number")
    WebElement mobileField;
    @FindBy(name = "your-subject")
    WebElement subjectField;
    @FindBy(name = "your-message")
    WebElement messageField;
    @FindBy(id = "recaptcha-anchor")
    WebElement recaptchaCheckbox;
    @FindBy(xpath = "//input[@value='Send']")
    public WebElement sendBtn;

    String name = "Ahmad Maged";
    String mob = "01234567890";
    String subject = "testing";
    String message = "This is a test form";


    public void goToCompany()
    {
        wait.until(ExpectedConditions.elementToBeClickable(companyBtn));
        companyBtn.click();
    }
    public void goToCareers()
    {
        wait.until(ExpectedConditions.elementToBeClickable(careersBtn));
        careersBtn.click();
    }
    public void clickContactUs()
    {
        wait.until(ExpectedConditions.visibilityOf(contactUsBtn));
        contactUsBtn.click();
    }
    public void enterName()
    {
        wait.until(ExpectedConditions.visibilityOf(contactUsForm));
        nameField.sendKeys(name);
    }
    public void enterAllOtherFieldsExceptEmail()
    {
        mobileField.sendKeys(mob);
        subjectField.sendKeys(subject);
        messageField.sendKeys(message);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //recaptchaCheckbox.sendKeys(Keys.SPACE);
    }
    public void clickSend()
    {
        wait.until(ExpectedConditions.visibilityOf(sendBtn));
        sendBtn.click();
    }

}
