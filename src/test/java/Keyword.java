import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class Keyword {
    private WebDriver driver;
    private WebDriverWait wait;

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

    public void Wait(){
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
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

    public void clickElementXPath(String objectXPath){
        driver.findElement(By.xpath(objectXPath)).click();
    }

    public void clickElementID(String id){
        driver.findElement(By.id(id)).click();
    }

}
