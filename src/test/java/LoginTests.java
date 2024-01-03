import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests {

    LoginForm loginForm = new LoginForm();

    @Test
    void loginIsSuccessful(){
        loginForm.login();
        loginForm.closeBrowser();
    }

    @Test
    void noCaptchaAfterThirdTry() throws InterruptedException {
        loginForm.wrongCredentialLogin();
        boolean result = loginForm.checkErrorMessage();
        Assertions.assertTrue(result);
        loginForm.closeBrowser();
    }

}
