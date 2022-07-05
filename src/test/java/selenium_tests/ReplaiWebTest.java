package selenium_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class ReplaiWebTest {
    WebDriver driver;

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
        driver.get("https://www.replai.io/");

        String title = driver.getTitle();

        // Verify
        assertThat(title, containsString("Replai: AI-Driven Video Analytics For Creatives"));
    }

    @Test(description = "User story 2: Replai logo assertion")
    void replaiLogoTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.replai.io/customer-acquisition-growth-teams");

        WebElement growthTeamsSection = driver.findElement(By.xpath("//section[@class='clients   mt-8 mb-8']"));

        WebElement replaiLogo = growthTeamsSection.findElement(By.xpath("//*[text()='YOU’RE IN GOOD COMPANY']"));

        /* boolean replaiLogoExists;

        try {
            WebElement replaiLogo = growthTeamsSection.findElement(By.xpath("//*[text()='YOU’RE IN GOOD COMPANY']"));
            replaiLogoExists = true;
        } catch (NoSuchElementException e) {
            replaiLogoExists = false;
        } */

    }

    @Test(description = "User story 2: Replai customer list assertion")
    void replaiCustomerListTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.replai.io/customer-acquisition-growth-teams");

        WebElement growthTeamsSection = driver.findElement(By.xpath("//section[@class='clients   mt-8 mb-8']"));

        WebElement clientList = growthTeamsSection.findElement(By.xpath("//div[@class='animate-in flex items-center justify-center flex-wrap']"));

        int clientCount = clientList.findElements(By.xpath("//div[@class='mx-4 md:mx-8 mb-8 lg:mb-16']")).size();

        System.out.println("Number of clients: " + clientCount);
    }
}
