package page;

import constant.Endpoints;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
    private WebDriver driver;
    private By passwordError = By.xpath("//*[text()='Некорректный пароль']");

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы регистрации")
    public void open() {
        driver.get(Endpoints.REGISTER_URL);
    }

    @Step("Получение поля ввода имени")
    public WebElement getName() {
        return driver.findElement(By.xpath("//input[@name='name']"));
    }

    @Step("Получение поля ввода электронной почты")
    public WebElement getEmail() {
        return driver.findElements(By.cssSelector("input.input__textfield")).get(1);
    }

    @Step("Получение поля ввода пароля")
    public WebElement getPassword() {
        return driver.findElement(By.xpath("//input[@type='password']"));
    }

    @Step("Получение кнопки регистрации")
    public WebElement getRegisterButton() {
        return driver.findElement(By.cssSelector("button.button_button_type_primary__1O7Bx"));
    }

    @Step("Регистрация пользователя")
    public void register(String name, String email, String password) {
        this.getName().clear();
        this.getName().sendKeys(name);
        this.getEmail().clear();
        this.getEmail().sendKeys(email);
        this.getPassword().clear();
        this.getPassword().sendKeys(password);
        this.getRegisterButton().click();
    }

    @Step("Проверка успешной регистрации")
    public boolean isSuccessfulRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.urlToBe(Endpoints.LOGIN_URL));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("Проверка отображения ошибки ввода пароля")
    public boolean isPasswordErrorDisplayed() {
        try {
            return driver.findElement(passwordError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Переход на страницу входа")
    public void navigateToLogin() {
        By loginLink = By.xpath("//a[contains(text(),'Войти') or contains(@href, '/login')]");
        driver.findElement(loginLink).click();
    }
}
