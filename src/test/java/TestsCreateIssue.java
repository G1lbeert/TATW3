import org.junit.jupiter.api.Test;

public class TestsCreateIssue {
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    void CreateIssue() throws InterruptedException {
        dashboardPage.CreateIssue();
        dashboardPage.closeBrowser();
    }
}
