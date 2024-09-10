import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import page.Main;
import static org.junit.Assert.assertTrue;

public class MainTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода в раздел 'Булки'")
    public void clickBunToCheckNavigation() {
        Main mainPage = new Main(driver);
        mainPage.open();
        mainPage.clickSauceTab();
        mainPage.clickBunTab();
        assertTrue(mainPage.isBunTabActive());
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Соусы'")
    public void clickSauceToCheckNavigation() {
        Main mainPage = new Main(driver);
        mainPage.open();
        mainPage.clickSauceTab();
        assertTrue(mainPage.isSauceTabActive());
    }

    @Test
    @DisplayName("Проверка перехода в раздел 'Начинки'")
    public void clickFillingsToCheckNavigation() {
        Main mainPage = new Main(driver);
        mainPage.open();
        mainPage.clickFillingTab();
        assertTrue(mainPage.isFillingTabActive());
    }

}
