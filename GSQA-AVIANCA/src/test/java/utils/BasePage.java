package utils;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static WebDriverWait wait;
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        options.addArguments("start-maximized","--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void writeElement(String locator, String data){
        Find(locator).sendKeys(data);
        Find(locator).sendKeys(Keys.TAB);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

}
