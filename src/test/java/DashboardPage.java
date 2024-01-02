
public class DashboardPage {

    Keyword keywords = new Keyword();
    LoginForm loginForm = new LoginForm();

    public void closeBrowser() {
        keywords.tearDown();
    }
    public void logout() throws InterruptedException {
            loginForm.login();

            //wait kaka meg a locator is :)))
            Thread.sleep(5000);
            keywords.clickElementID("user-options");
            Thread.sleep(5000);
            keywords.clickElementID("log_out");
    }

}
