import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage {

    Keyword keywords = new Keyword();
    Authorization authorization = new Authorization();

    public void closeBrowser() {
        keywords.tearDown();
    }
    public void logout() throws InterruptedException {
            keywords.setupForm();
            keywords.sendKeysById("login-form-username", authorization.UserName());
            keywords.sendKeysById("login-form-password", authorization.Password());
            keywords.waitForElementToBeClickable(By.id("login"), 5);
            keywords.clickElementID("login");
            Thread.sleep(3000);

            keywords.waitForElementToBeClickable(By.id("user-options"), 5);
            keywords.clickElementID("user-options");
            keywords.waitForElementToBeClickable(By.id("log_out"), 5);
            keywords.clickElementID("log_out");
    }

}
