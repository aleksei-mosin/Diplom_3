package page;

import constant.Endpoints;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By loginButton = By.cssSelector("button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    private final By profileButton = By.xpath("//a[@href='/account']");
    private final By bun = By.xpath("//span[text()='Булки']");
    private final By sauce = By.xpath("//span[text()='Соусы']");
    private final By filling = By.xpath("//span[text()='Начинки']");
    private final By activeBun = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Булки']");
    private final By activeSauce = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Соусы']");
    private final By activeFilling = By.xpath("//div[contains(@class, 'tab_tab_type_current')]/span[text()='Начинки']");

    public Main(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);

    }

    @Step("Переход в профиль пользователя")
    public void goToProfile() {
        driver.findElement(profileButton).click();
    }

    public By getProfileLink() {
        return profileButton;
    }

    @Step("Открытие главной страницы")
    public void open() {
        driver.get(Endpoints.MAIN_URL);
    }

    @Step("Переход на страницу входа")
    public void navigateToLogin() {
        driver.findElement(loginButton).click();
    }

    @Step("Клик по вкладке 'Булки'")
    public void clickBunTab() {
        clickTab(bun);
    }

    @Step("Клик по вкладке 'Соусы'")
    public void clickSauceTab() {
        clickTab(sauce);
    }

    @Step("Клик по вкладке 'Начинки'")
    public void clickFillingTab() {
        clickTab(filling);
    }

    @Step("Клик по вкладке")
    private void clickTab(By tabLocator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tab = wait.until(ExpectedConditions.elementToBeClickable(tabLocator));
        tab.click();
    }

    public boolean isBunTabActive() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(bun));
        return driver.findElements(activeBun).size() > 0;
    }

    public boolean isSauceTabActive() {
        return driver.findElements(activeSauce).size() > 0;
    }

    public boolean isFillingTabActive() {
        return driver.findElements(activeFilling).size() > 0;
    }
}
