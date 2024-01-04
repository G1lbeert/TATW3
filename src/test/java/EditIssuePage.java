import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class EditIssuePage {
    Keyword keywords = new Keyword();
    Authorization authorization = new Authorization();
    public void EditIssuePageNavigation() throws InterruptedException {
        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
        keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
        keywords.clickElement(By.id("login"));

        keywords.waitForElementToBeClickable(By.id("find_link"), 5);
        keywords.clickElement(By.id("find_link"));
        keywords.waitForElementToBeClickable(By.id("issues_new_search_link_lnk"), 5);
        keywords.clickElement(By.id("issues_new_search_link_lnk"));
        Thread.sleep(3000);

        keywords.clickElement(By.xpath("//*[@id=\"main\"]/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[1]/div[1]/div"));
        Thread.sleep(2000);

        keywords.sendKeysMessage(By.id("searcher-pid-input"), "JETI project (JETI)");
        keywords.sendKeysKey(By.id("searcher-pid-input"),Keys.ENTER);
        Thread.sleep(1000);

        keywords.clickElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]"));
        Thread.sleep(1000);

        keywords.clickElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div/div/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/ol/li[2]/a/div/div[2]/span[1]"));
        Thread.sleep(1000);

        keywords.clickElement(By.xpath("//*[@id=\"edit-issue\"]/span[2]"));
        Thread.sleep(1000);

        WebElement summary = keywords.findElement(By.id("summary"));
        summary.clear();
        summary.sendKeys("This test is modified by automated test.");
        Thread.sleep(2000);

        keywords.clickElement(By.xpath("//*[@id=\"edit-issue-submit\"]"));
    }
}
