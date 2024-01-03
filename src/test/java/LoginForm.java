import org.openqa.selenium.By;

public class LoginForm {

    Authorization authorization = new Authorization();
    Keyword keywords = new Keyword();

    public void closeBrowser() {
        keywords.tearDown();
    }

    public void login() {
        keywords.setupForm();
        keywords.sendKeysById("login-form-username", authorization.UserName());
        keywords.sendKeysById("login-form-password", authorization.Password());
        keywords.clickElementID("login");
    }

    public void wrongCredentialLogin() throws InterruptedException {
        keywords.setupForm();
        keywords.sendKeysById("login-form-username", "asd");
        keywords.sendKeysById("login-form-password", "asd");
        keywords.clickElementID("login");

        keywords.waitForElementToBeClickable(By.id("usernameerror"), 5);
    }

    public boolean checkErrorMessage(){
       return keywords.elementIsDisplayed("usernameerror");
    }
}
