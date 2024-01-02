import org.junit.jupiter.api.Test;

import java.security.Key;

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
}
