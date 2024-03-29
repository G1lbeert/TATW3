import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class DashboardPage {

    Keyword keywords = new Keyword();
    Authorization authorization = new Authorization();

    public void closeBrowser() {
        keywords.tearDown();
    }
    public void logout() throws InterruptedException {
            keywords.setupForm();
            Thread.sleep(3000);
            keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
            keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
            keywords.waitForElementToBeClickable(By.id("login"), 5);
            keywords.clickElement(By.id("login"));
            Thread.sleep(3000);

            keywords.waitForElementToBeClickable(By.id("user-options"), 5);
            keywords.clickElement(By.id("user-options"));
            keywords.waitForElementToBeClickable(By.id("log_out"), 5);
            keywords.clickElement(By.id("log_out"));
    }

    public void CreateIssue() throws  InterruptedException {
        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
        keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
        keywords.waitForElementToBeClickable(By.id("login"), 5);
        keywords.clickElement(By.id("login"));
        Thread.sleep(3000);

        String[] Projects = {"COALA project (COALA)"}; // Toucant nem választhatunk
        //, "JETI project (JETI)", "TOUCAN project (TOUCAN)"

        String[] Issues = {"Epic", "Bug"}; //Bug és Story az összesnél
        //, "Task", "Story"

        for (String project : Projects) {
            for (String issue : Issues) {
                try {
                    keywords.clickElement(By.id("create_link"));
                    Thread.sleep(3000);

                    var projectField = keywords.findElement(By.xpath("//*[@id=\"project-field\"]"));
                    Thread.sleep(1000);
                    projectField.click();
                    projectField.sendKeys(Keys.BACK_SPACE);
                    Thread.sleep(3000);
                    projectField.sendKeys(project);
                    projectField.sendKeys(Keys.ENTER);
                    Thread.sleep(3000);

                    var issueField = keywords.findElement(By.xpath("//*[@id=\"issuetype-field\"]"));
                    Thread.sleep(1000);
                    issueField.click();
                    issueField.sendKeys(Keys.BACK_SPACE);
                    Thread.sleep(1000);
                    issueField.sendKeys(issue);
                    issueField.sendKeys(Keys.ENTER);
                    Thread.sleep(3000);

                    //keywords.sendKeysByXPath("//*[@id="summary"]"]", "This test created by automated testing.");
                    var summaryField = keywords.findElement(By.xpath("//*[@id=\"summary\"]"));
                    summaryField.click();
                    summaryField.sendKeys("This test created by automated testing.");
                    Thread.sleep(3000);

                    keywords.clickElement(By.id("create-issue-submit"));
                } catch (Exception e) {// A click nem fut le ezért hibára fut
                    e.getMessage();
                    Thread.sleep(2000);
                    keywords.clickElement(By.xpath("//*[@id=\"create-issue-dialog\"]/footer/div/div/button"));
                }
            }
        }
    }
}
