package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class ReplaiWebpageTests {
    WebDriver driver;
    String replaiHomepage = "https://www.replai.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test(description = "User story 1: Replai website general test")
    void replaiGeneralTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(replaiHomepage);

        String title = driver.getTitle();

        assertThat(title, containsString("Replai: AI-Driven Video Analytics For Creatives"));
    }

    @Test(description = "User story 1: Replai website menu test")
    void replaiMenuTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(replaiHomepage);

        //Solutions for
        Actions action = new Actions(driver);
        WebElement solutionsMenu = driver.findElement(By.xpath("//li[@id='menu-item-33']"));
        action.moveToElement(solutionsMenu).perform();


        WebElement creativeTeamsLink = solutionsMenu.findElement(By.xpath("//a[text()='Creative teams']"));
        creativeTeamsLink.click();

        String creativeTeamsUrl = driver.getCurrentUrl();
        assertThat(creativeTeamsUrl, equalTo("https://www.replai.io/creative-teams"));

        action.moveToElement(solutionsMenu).perform();

        WebElement customerAcquisitonLink = solutionsMenu.findElement(By.xpath("//a[text()='Customer acquisiton & growth teams']"));
        customerAcquisitonLink.click();

        String customerAcquisitionUrl = driver.getCurrentUrl();
        assertThat(customerAcquisitionUrl, equalTo("https://www.replai.io/customer-acquisition-growth-teams"));

        //Resources
        WebElement resourcesMenu = driver.findElement(By.xpath("//li[@id='menu-item-353']"));
        action.moveToElement(resourcesMenu).perform();

        WebElement insightsLink = resourcesMenu.findElement(By.xpath("//a[text()='Insights']"));
        insightsLink.click();

        String insightsUrl = driver.getCurrentUrl();
        assertThat(insightsUrl, equalTo("https://www.replai.io/insights"));

        action.moveToElement(resourcesMenu).perform();

        WebElement blogLink = resourcesMenu.findElement(By.xpath("//a[text()='Blog']"));
        blogLink.click();

        String blogUrl = driver.getCurrentUrl();
        assertThat(blogUrl, equalTo("https://www.replai.io/blog"));
    }
}
