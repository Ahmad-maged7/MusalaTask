package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompanyPage extends PageBase{
    public CompanyPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver,20);
    @FindBy(className = "company-members")
    public WebElement leaderShipSection;
    @FindBy(css = "div[class='cm-content'] h2")
    public WebElement leadershipSectionTitle;
    @FindBy(xpath = "//span[@class='musala musala-icon-facebook']")
    public WebElement facebookIcon;

    public void clickFacebookIcon()
    {
        wait.until(ExpectedConditions.visibilityOf(facebookIcon));
        facebookIcon.click();
    }
}
