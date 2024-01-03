import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    public void CreateIssue() throws  InterruptedException {
        keywords.setupForm();
        keywords.sendKeysById("login-form-username", authorization.UserName());
        keywords.sendKeysById("login-form-password", authorization.Password());
        keywords.waitForElementToBeClickable(By.id("login"), 5);
        keywords.clickElementID("login");
        Thread.sleep(3000);

        String[] Projects = {"COALA project (COALA)", "JETI project (JETI)", "TOUCAN project (TOUCAN)"}; // Toucant nem választhatunk
        String[] Issues = {"Epic", "Bug", "Task", "Story"}; //Bug és Story az összesnél

        for (String project : Projects) {
            for (String issue : Issues) {
                try {
                    keywords.clickElementID("create_link");
                    Thread.sleep(3000);

                    keywords.clickElementXPath("//*[@id=\"project-field\"]");
                    Thread.sleep(3000);
                    keywords.SendKeys(By.xpath("//*[@id=\"project-field\"]"), Keys.BACK_SPACE);
                    keywords.sendKeysByXPath("//*[@id=\"project-field\"]", project);
                    keywords.SendKeys(By.xpath("//*[@id=\"project-field\"]"), Keys.ENTER);
                    Thread.sleep(3000);

                    keywords.clickElementXPath("//*[@id=\"issuetype-field\"]");
                    Thread.sleep(3000);
                    keywords.SendKeys(By.xpath("//*[@id=\"issuetype-field\"]"), Keys.BACK_SPACE);
                    keywords.sendKeysByXPath("//*[@id=\"issuetype-field\"]", issue);
                    keywords.SendKeys(By.xpath("//*[@id=\"issuetype-field\"]"), Keys.ENTER);
                    Thread.sleep(3000);

                    keywords.sendKeysByXPath("//*[@id=\"issuetype-field\"]", "This test created by automated testing.");
                    Thread.sleep(3000);

                    keywords.clickElementID("create-issue-submit");
                } catch (Exception e) {// A click nem fut le ezért hibára fut
                    e.getMessage();
                    Thread.sleep(2000);
                    keywords.clickElementXPath("//*[@id=\"create-issue-dialog\"]/footer/div/div/button");
                }
            }
        }
    }
}
