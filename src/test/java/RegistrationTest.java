import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.Login;
import page.Registration;
import java.util.UUID;
import static org.junit.Assert.assertTrue;
public class RegistrationTest extends BaseTest {
    @Test
    @DisplayName("Успешная регистрация")
    public void testSuccessfulRegistration() {
        String username = "testuserQA" + UUID.randomUUID().toString().substring(0, 4);
        String emailPrefix = "testuserQA";
        String emailDomain = "yandex.ru";
        String email = emailPrefix + UUID.randomUUID().toString().substring(0, 4) + "@" + emailDomain;
        Registration registrationPage = new Registration(driver);
        registrationPage.open();
        registrationPage.register(username, email, "q1w2e3r4");
        assertTrue(registrationPage.isSuccessfulRegistration());
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login(email, "q1w2e3r4");
        assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    @DisplayName("Ошибка при регистрации если пароль короткий < 6 символов")
    public void testRegistrationWithShortPassword() {
        Registration registrationPage = new Registration(driver);
        registrationPage.open();
        registrationPage.register("testuseQA", "testuserQA@yandex.ru", "short");
        assertTrue(registrationPage.isPasswordErrorDisplayed());
    }
}
