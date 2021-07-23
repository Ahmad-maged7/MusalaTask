package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.List;

public class JoinUsPage extends PageBase{
    public JoinUsPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait = new WebDriverWait(driver,10);

    @FindBy(xpath = "//*[@id=\"content\"]/section/div[2]/article[1]/div/a")
    WebElement firstJob;
    @FindBy(id = "get_location")
    public WebElement locationDropMenu;

    public void selectJob()
    {
        wait.until(ExpectedConditions.visibilityOf(firstJob));
        firstJob.click();
    }
    public void getAllJobsData()
    {
        List<WebElement> jobs = driver.findElements(By.className("card-jobsHot"));
        for(WebElement job :jobs)
        {
            System.out.println("Location: "+job.findElement(By.className("card-jobsHot__location")).getText());
            System.out.println("Position: "+job.findElement(By.className("card-jobsHot__title")).getText());
            System.out.println("More info: "+job.findElement(By.cssSelector("a")).getAttribute("href"));
            System.out.println("----------------------------------------------------------");
        }
    }
}
