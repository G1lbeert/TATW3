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
            keywords.clickElementID("login");

            Thread.sleep(5000);
            keywords.clickElementID("user-options");
            Thread.sleep(5000);
            keywords.clickElementID("log_out");
    }

}
