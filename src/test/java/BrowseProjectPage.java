import org.openqa.selenium.By;

public class BrowseProjectPage {

    Keyword keywords = new Keyword();

    Authorization authorization = new Authorization();

    public void browseIssue() throws InterruptedException {
        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
        keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
        keywords.clickElement(By.id("login"));
        Thread.sleep(4000);

        keywords.clickElement(By.id("browse_link"));
        Thread.sleep(3000);

        keywords.clickElement(By.id("proj_lnk_10104_lnk"));
        Thread.sleep(5000);
    }

    public void closeBrowser(){
        keywords.tearDown();
    }

}
