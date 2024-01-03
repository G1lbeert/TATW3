import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import javax.swing.plaf.TableHeaderUI;

public class BrowseIssuePage {

    Keyword keywords = new Keyword();

    Authorization authorization = new Authorization();

    public void closeBrowser() {
        keywords.tearDown();
    }
    void browseIssue() throws InterruptedException {

        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
        keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
        keywords.clickElement(By.id("login"));

        keywords.waitForElementToBeClickable(By.id("find_link"), 5);
        keywords.clickElement(By.id("find_link"));
        keywords.waitForElementToBeClickable(By.id("issues_new_search_link_lnk"), 5);
        keywords.clickElement(By.id("issues_new_search_link_lnk"));

        Thread.sleep(5000);

        keywords.clickElement(By.xpath("//*[@id=\"main\"]/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[1]/div[1]/div"));

        Thread.sleep(2000);
        keywords.sendKeysMessage(By.id("searcher-pid-input"), "COALA project");
        Thread.sleep(2000);
        keywords.sendKeysKey(By.id("searcher-pid-input"), Keys.ENTER);

        Thread.sleep(5000);

        keywords.sendKeysMessage(By.id("searcher-pid-input"), "JETI project");
        Thread.sleep(2000);
        keywords.sendKeysKey(By.id("searcher-pid-input"), Keys.ENTER);

        Thread.sleep(5000);

        keywords.sendKeysMessage(By.id("searcher-pid-input"), "TOUCAN project");
        Thread.sleep(2000);
        keywords.sendKeysKey(By.id("searcher-pid-input"), Keys.ENTER);
    }

}
