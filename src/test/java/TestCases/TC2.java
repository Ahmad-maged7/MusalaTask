package TestCases;

import Base.TestBase;
import Pages.CompanyPage;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC2 extends TestBase {
    HomePage homeObject;
    CompanyPage companyObject;

    @Test(priority = 1)
    public void goToCompanyPage()
    {
     homeObject = new HomePage(driver);
     companyObject = new CompanyPage(driver);
     homeObject.goToCompany();
     Assert.assertTrue(driver.getCurrentUrl().equals("https://www.musala.com/company/"));
    }
    @Test(priority = 2)
    public void ValidatePresenceOfLeaderShipSection()
    {
        companyObject = new CompanyPage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.className("footer-links")));
        Assert.assertTrue(companyObject.leaderShipSection.isDisplayed());
        Assert.assertTrue(companyObject.leadershipSectionTitle.isDisplayed());
    }
    @Test(priority = 3)
    public void goToFacebookPage() {
        companyObject = new CompanyPage(driver);
        companyObject.clickFacebookIcon();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.facebook.com/MusalaSoft?fref=ts"));
        Assert.assertTrue(driver.findElement(By.xpath("//img[@class='_6tb5 img']")).isDisplayed());
    }
}