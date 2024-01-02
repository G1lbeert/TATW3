import org.junit.jupiter.api.Test;

public class LogoutTests {

    DashboardPage dashboardPage = new DashboardPage();

    @Test
    void logoutIsSuccesful() throws InterruptedException {
       dashboardPage.logout();
       dashboardPage.closeBrowser();
    }
}
