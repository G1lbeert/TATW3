import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Keyword {
    private WebDriver driver;

    private static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    private void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
        driver.manage().window().maximize();
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void setupForm(){
        setUpClass();
        setUp();
    }

    public void waitForElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementToBePresent(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void navigate(String url){
        driver.navigate().to(url);
        System.out.println("Navigated to" + url);
    }

    public void sendKeysByXPath(String objectXPath, String message){
        driver.findElement(By.xpath(objectXPath)).sendKeys(message);
    }

    public void sendKeysById(String id, String message){
        driver.findElement(By.id(id)).sendKeys(message);
    }

    public void SendKeys(By locator, Keys key){
        driver.findElement(locator).sendKeys(key);
    }

    public void clickElementXPath(String objectXPath){
        driver.findElement(By.xpath(objectXPath)).click();
    }

    public void clickElementID(String id){
       var element = driver.findElement(By.id(id));
       element.click();
    }

    public boolean elementIsDisplayed(String id){
        return driver.findElement(By.id(id)).isDisplayed();
    }
}
