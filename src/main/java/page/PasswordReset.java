package page;

import constant.Endpoints;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordReset {
    private WebDriver driver;
    private By loginButton = By.xpath("//a[text()='Войти']");

    public PasswordReset(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы восстановления пароля")
    public void open() {
        driver.get(Endpoints.FORGOT_URL);
    }

    @Step("Переход на страницу входа через ссылку 'Войти'")
    public void navigateToLogin() {
        driver.findElement(loginButton).click();
    }
}
