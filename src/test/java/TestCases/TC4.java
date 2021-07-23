package TestCases;

import Base.TestBase;
import Pages.CareersPage;
import Pages.HomePage;
import Pages.JobDetailsPage;
import Pages.JoinUsPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC4 extends TestBase {
    HomePage homeObject;
    CareersPage careersObject;
    JoinUsPage joinUsObject;

    @Test(priority = 1)
    public void reachJoinUsPage()
    {
        homeObject = new HomePage(driver);
        careersObject = new CareersPage(driver);
        homeObject.goToCareers();
        careersObject.goToJoinUs();
        Assert.assertTrue(driver.getCurrentUrl().contains("/join-us/"));
    }
    @Test(priority = 2)
    public void filerResults()
    {
        joinUsObject = new JoinUsPage(driver);
        Select select = new Select(joinUsObject.locationDropMenu);
        select.selectByValue("Sofia");
        joinUsObject.getAllJobsData();
    }
}
