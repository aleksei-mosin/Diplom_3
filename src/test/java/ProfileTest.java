import constant.Endpoints;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Login;
import page.Main;
import page.Profile;

public class ProfileTest extends BaseTest {
    @Test
    @DisplayName("Переход по клику на «Личный кабинет»")
    public void clickOnPersonalAccountButton() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Main mainPage = new Main(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(mainPage.getProfileLink()));
        mainPage.goToProfile();
        wait.until(ExpectedConditions.urlToBe(Endpoints.PROFILE_URL));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL не соответствует ожидаемому", Endpoints.PROFILE_URL, currentUrl);
    }
    @Test
    @DisplayName("Переход по клику на «Лого»")
    public void clickOnLogo() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Main mainPage = new Main(driver);
        mainPage.goToProfile();
        Profile profilePage = new Profile(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePage.getLogo()));
        profilePage.clickLogo();
        wait.until(ExpectedConditions.urlToBe(Endpoints.MAIN_URL));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL не соответствует ожидаемому", Endpoints.MAIN_URL, currentUrl);
    }
    @Test
    @DisplayName("Переход по клику на «Конструкторк»")
    public void clickOnConstructorButton() {
        Login loginPage = new Login(driver);
        loginPage.open();
        loginPage.login("newtestuserQA@yandex.ru", "q1w2e3r4");
        Main mainPage = new Main(driver);
        mainPage.goToProfile();
        Profile profilePage = new Profile(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profilePage.getConstructorButton()));
        profilePage.goToMainByConstructorButton();
        wait.until(ExpectedConditions.urlToBe(Endpoints.MAIN_URL));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("URL не соответствует ожидаемому", Endpoints.MAIN_URL, currentUrl);
    }

}
