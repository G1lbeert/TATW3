import org.junit.jupiter.api.Test;

public class LoginForm {
    public void Login() {
        Authorization authorization = new Authorization();
        Keyword keywords = new Keyword();

        keywords.setupForm();
        keywords.sendKeysById("login-form-username", authorization.UserName());
        keywords.sendKeysById("login-form-password", authorization.Password());
        keywords.clickElementID("login");
        keywords.tearDown();
    }
}
