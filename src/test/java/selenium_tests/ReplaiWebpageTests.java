package selenium_tests;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
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
    void replaiMenuTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(replaiHomepage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        CountDownLatch awaiter = new CountDownLatch(3);

        //Solutions for
        Actions action = new Actions(driver);
        WebElement solutionsMenu = driver.findElement(By.xpath("//li[@id='menu-item-33']"));
        action.moveToElement(solutionsMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement creativeTeamsLink =solutionsMenu.findElement(By.xpath("//a[text()='Creative teams']"));
        creativeTeamsLink.click();

        String creativeTeamsUrl = driver.getCurrentUrl();
        assertThat(creativeTeamsUrl, equalTo("https://www.replai.io/creative-teams"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        action.moveToElement(solutionsMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement customerAcquisitonLink = solutionsMenu.findElement(By.xpath("//a[text()='Customer acquisiton & growth teams']"));
        customerAcquisitonLink.click();

        String customerAcquisitionUrl = driver.getCurrentUrl();
        assertThat(customerAcquisitionUrl, equalTo("https://www.replai.io/customer-acquisition-growth-teams"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        //Resources
        WebElement resourcesMenu = driver.findElement(By.xpath("//li[@id='menu-item-353']"));
        action.moveToElement(resourcesMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement insightsLink = resourcesMenu.findElement(By.xpath("//a[text()='Insights']"));
        insightsLink.click();

        String insightsUrl = driver.getCurrentUrl();
        assertThat(insightsUrl, equalTo("https://www.replai.io/insights"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        action.moveToElement(resourcesMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement blogLink = resourcesMenu.findElement(By.xpath("//a[text()='Blog']"));
        blogLink.click();

        String blogUrl = driver.getCurrentUrl();
        assertThat(blogUrl, equalTo("https://www.replai.io/blog"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        //Company
        WebElement companyMenu = driver.findElement(By.xpath("//li[@id='menu-item-731']"));
        action.moveToElement(companyMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement aboutUsLink = companyMenu.findElement(By.xpath("//a[text()='About us']"));
        aboutUsLink.click();

        String aboutUsUrl = driver.getCurrentUrl();
        assertThat(aboutUsUrl, equalTo("https://www.replai.io/about-us"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        action.moveToElement(companyMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement careersLink = companyMenu.findElement(By.xpath("//a[text()='Careers']"));
        careersLink.click();

        String careersUrl = driver.getCurrentUrl();
        assertThat(careersUrl, equalTo("https://www.replai.io/careers"));

        awaiter.await(3000, TimeUnit.MILLISECONDS);

        action.moveToElement(companyMenu).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='dropdown-submenu active']")));

        WebElement contactLink = companyMenu.findElement(By.xpath("//a[text()='Contact']"));
        contactLink.click();

        String contactUrl = driver.getCurrentUrl();
        assertThat(contactUrl, equalTo("https://www.replai.io/contact"));
    }
}
