package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.main.ConstructorWindow;

public class ConstructorTest {
    private ConstructorWindow constructorWindow;

    @ClassRule
    public static praktikum.DriverRule factory = new praktikum.DriverRule();

    @Before
    public void setUp(){
        WebDriver driver = factory.getDriver();
        constructorWindow = new ConstructorWindow(driver);
    }

    @Test
    @DisplayName("Тест на скролл к разделу Булки")
    @Description("Проверяем, что скролл к разделу Булки работает")
    public void checkScrollBunsTest(){
        constructorWindow.checkScrollBunsElemet();
    }

    @Test
    @DisplayName("Тест на скролл к разделу Соусы")
    @Description("Проверяем, что скролл к разделу Соусы работает")
    public void checkScrollSaucesTest(){
        constructorWindow.checkScrollSaucesElemet();
    }

    @Test
    @DisplayName("Тест на скролл к разделу Начинки")
    @Description("Проверяем, что скролл к разделу Начинки работает")
    public void checkScrollFillingsTest(){
        constructorWindow.checkScrollFillingsElemet();
    }

}
