package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends PageBase{
    public CareersPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//button[@class='contact-label contact-label-code btn btn-1b']")
    WebElement joinUsBtn;

    public void goToJoinUs()
    {
        joinUsBtn.click();
    }
}
