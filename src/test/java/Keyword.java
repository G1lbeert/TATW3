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
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public void sendKeysMessage(By locator, String message){
        driver.findElement(locator).sendKeys(message);
    }

    public void sendKeysKey(By locator, Keys key){
        driver.findElement(locator).sendKeys(key);
    }

    public void clickElement(By locator){
        driver.findElement(locator).click();
    }

    public boolean elementIsDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
