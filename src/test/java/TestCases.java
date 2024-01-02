import org.junit.jupiter.api.Test;

public class TestCases {

    LoginForm loginForm = new LoginForm();
    
    @Test
    void loginIsSuccessful(){
        loginForm.Login();
    }
}
