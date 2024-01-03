import org.junit.jupiter.api.Test;

public class TestsCreateissue {
    DashboardPage dashboardPage = new DashboardPage();

    @Test
    void CreateIssue() throws InterruptedException {
        dashboardPage.CreateIssue();
        dashboardPage.closeBrowser();
    }
}
