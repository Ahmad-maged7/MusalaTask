package TestCases;

import Base.TestBase;
import Data.JsonDataReader;
import Pages.HomePage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TC1 extends TestBase {
    HomePage homeObject;
    JsonDataReader jsonReader;

    @Test(priority = 1)
    public void reachAndOpenContactUsForm()
    {
        homeObject = new HomePage(driver);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.className("news__title")));
        homeObject.clickContactUs();
    }
    @Test(priority = 2)
    public void fillContactUsFormAndSend() throws IOException, ParseException {
        homeObject = new HomePage(driver);
        jsonReader = new JsonDataReader();
        jsonReader.jsonReader();
        homeObject.enterName();
        homeObject.emailField.sendKeys(jsonReader.email1);
        homeObject.enterAllOtherFieldsExceptEmail();
        driver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",homeObject.sendBtn);
        homeObject.clickSend();
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/div[3]/p/span")));
        js.executeScript("arguments[0].scrollIntoView(true);",homeObject.emailField);
        Assert.assertTrue(driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid."));
        System.out.println("First invalid email is: "+jsonReader.email1);
        if (driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid.")==true)
        {
            homeObject.emailField.sendKeys(jsonReader.email2);
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.sendBtn);
            homeObject.clickSend();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/div[3]/p/span")));
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.emailField);
            Assert.assertTrue(driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid."));
            System.out.println("Second invalid email is: "+jsonReader.email2);
        }
        if (driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid.")==true)
        {
            homeObject.emailField.sendKeys(jsonReader.email3);
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.sendBtn);
            homeObject.clickSend();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/div[3]/p/span")));
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.emailField);
            Assert.assertTrue(driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid."));
            System.out.println("Third invalid email is: "+jsonReader.email3);
        }
        if (driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid.")==true)
        {
            homeObject.emailField.sendKeys(jsonReader.email4);
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.sendBtn);
            homeObject.clickSend();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/div[3]/p/span")));
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.emailField);
            Assert.assertTrue(driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid."));
            System.out.println("Fourth invalid email is: "+jsonReader.email4);
        }
        if (driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid.")==true)
        {
            homeObject.emailField.sendKeys(jsonReader.email5);
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.sendBtn);
            homeObject.clickSend();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"wpcf7-f875-o1\"]/form/div[3]/p/span")));
            js.executeScript("arguments[0].scrollIntoView(true);",homeObject.emailField);
            Assert.assertTrue(driver.findElement(By.className("wpcf7-not-valid-tip")).getText().equals("The e-mail address entered is invalid."));
            System.out.println("Fifth invalid email is: "+jsonReader.email5);
        }
    }
}
