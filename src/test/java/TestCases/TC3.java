package TestCases;

import Base.TestBase;
import Pages.CareersPage;
import Pages.HomePage;
import Pages.JobDetailsPage;
import Pages.JoinUsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3 extends TestBase {
    HomePage homeObject;
    CareersPage careersObject;
    JoinUsPage joinUsObject;
    JobDetailsPage jobDObject;

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
    public void reachJobDetailsPage()
    {
        joinUsObject = new JoinUsPage(driver);
        jobDObject = new JobDetailsPage(driver);
        joinUsObject.selectJob();
        Assert.assertTrue(jobDObject.generalDescription.isDisplayed());
        System.out.println("General Description Section is Displayed");
        Assert.assertTrue(jobDObject.requirements.isDisplayed());
        System.out.println("Requirements Section is Displayed");
        Assert.assertTrue(jobDObject.responsibilities.isDisplayed());
        System.out.println("Responsibilities Section is Displayed");
        Assert.assertTrue(jobDObject.whatWeOffer.isDisplayed());
        System.out.println("What We Offer Section is Displayed");
    }
    @Test(priority = 3)
    public void openAndSubmitFormWithBlankFields()
    {
        jobDObject = new JobDetailsPage(driver);
        Assert.assertTrue(jobDObject.applyBtn.isDisplayed());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",jobDObject.applyBtn);
        jobDObject.clickApply();
        jobDObject.sendBtn.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(jobDObject.spinner));
        Assert.assertTrue(jobDObject.errorPopup.getText().contains("One or more fields have an error. Please check and try again."));
        wait.until(ExpectedConditions.elementToBeClickable(jobDObject.closeErrorPopup));
        jobDObject.closeErrorPopup.click();

    }
    @Test(priority = 4)
    public void openAndFillApplyFormWithInvalidEmail()
    {
        jobDObject.fillAllFieldsAndWithInvalidEmail();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.invisibilityOf(jobDObject.spinner));
        Assert.assertTrue(jobDObject.errorPopup.getText().contains("One or more fields have an error. Please check and try again."));
    }

}
