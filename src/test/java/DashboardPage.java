
public class DashboardPage {

    Keyword keywords = new Keyword();
    LoginForm loginForm = new LoginForm();

    public void closeBrowser() {
        keywords.tearDown();
    }
    public void logout() throws InterruptedException {
            loginForm.login();

            keywords.Wait(10);
            keywords.clickElementID("header-details-user-fullname");
            keywords.Wait(10);
            keywords.clickElementID("log_out");
    }

}
