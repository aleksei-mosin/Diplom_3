package page;

import constant.Endpoints;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private By emailField = By.xpath("//input[@name='name']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[text()='Войти']");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы входа")
    public void open() {
        driver.get(Endpoints.LOGIN_URL);
    }

    @Step("Ввод электронной почты: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Войти'")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Авторизация с электронной почтой: {email} и паролем")
    public void login(String email, String password) {
        this.enterEmail(email);
        this.enterPassword(password);
        this.clickLoginButton();
    }

    @Step("Проверка успешного входа в систему")
    public boolean isLoginSuccessful() {
        String expectedUrl = Endpoints.MAIN_URL;
        return driver.getCurrentUrl().contains(expectedUrl);
    }
}
