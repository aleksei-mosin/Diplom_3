import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import page.*;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Вход по кнопке 'Войти' на главной странице")
    public void testLoginMainPage() {
        Main mainPage = new Main(driver);
        mainPage.open();
        mainPage.navigateToLogin();
        Login loginPage = new Login(driver);
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    @DisplayName("Вход по кнопке 'Войти' через страницу регистрации")
    public void testLoginRegistrationPage() {
        Registration registrationPage = new Registration(driver);
        registrationPage.open();
        registrationPage.navigateToLogin();
        Login loginPage = new Login(driver);
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    @DisplayName("Вход по кнопке 'Войти' на форме восстановления пароля")
    public void testLoginPasswordRecoveryPage() {
        PasswordReset passwordResetPage = new PasswordReset(driver);
        passwordResetPage.open();
        passwordResetPage.navigateToLogin();
        Login loginPage = new Login(driver);
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    public void testLoginPersonalAccountButton() {
        Main mainPage = new Main(driver);
        mainPage.open();
        mainPage.goToProfile();
        Login loginPage = new Login(driver);
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете")
    public void logoutTest(){
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Main mainPage = new Main(driver);
        mainPage.goToProfile();
        Profile profilePage = new Profile(driver);
        profilePage.getLogoutButton().click();
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}
