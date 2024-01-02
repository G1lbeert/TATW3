import org.junit.jupiter.api.Test;

public class LoginTests {

    LoginForm loginForm = new LoginForm();

    @Test
    void loginIsSuccessful(){
        loginForm.login();
        loginForm.closeBrowser();
    }

}
