import org.openqa.selenium.By;

public class LoginForm {

    Authorization authorization = new Authorization();
    Keyword keywords = new Keyword();

    public void closeBrowser() {
        keywords.tearDown();
    }

    public void login() {
        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), authorization.UserName());
        keywords.sendKeysMessage(By.id("login-form-password"), authorization.Password());
        keywords.clickElement(By.id("login"));
    }

    public void wrongCredentialLogin() throws InterruptedException {
        keywords.setupForm();
        keywords.sendKeysMessage(By.id("login-form-username"), "asd");
        keywords.sendKeysMessage(By.id("login-form-password"), "asd");
        keywords.clickElement(By.id("login"));

        keywords.waitForElementToBeClickable(By.id("usernameerror"), 5);
    }

    public boolean checkErrorMessage(){
       return keywords.elementIsDisplayed(By.id("usernameerror"));
    }
}
