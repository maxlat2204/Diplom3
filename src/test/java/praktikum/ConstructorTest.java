package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.pages.main.ConstructorWindow;

public class ConstructorTest {

    @ClassRule
    public static praktikum.DriverRule factory = new praktikum.DriverRule();

//    @Test
//    public void checkScroll3(){
//        WebDriver driver = factory.getDriver();
//        var constructorWindow = new ConstructorWindow(driver);
//
//        constructorWindow.checkScrollThreeElemets();
//    }

    @Test
    @DisplayName("Тест на скролл к разделу Булки")
    @Description("Проверяем, что скролл к разделу Булки работает")
    public void checkScrollBuns(){
        WebDriver driver = factory.getDriver();
        var constructorWindow = new ConstructorWindow(driver);

        constructorWindow.checkScrollBunsElemet();
    }

    @Test
    @DisplayName("Тест на скролл к разделу Соусы")
    @Description("Проверяем, что скролл к разделу Соусы работает")
    public void checkScrollSauces(){
        WebDriver driver = factory.getDriver();
        var constructorWindow = new ConstructorWindow(driver);

        constructorWindow.checkScrollSaucesElemet();
    }

    @Test
    @DisplayName("Тест на скролл к разделу Начинки")
    @Description("Проверяем, что скролл к разделу Начинки работает")
    public void checkScrollFillings(){
        WebDriver driver = factory.getDriver();
        var constructorWindow = new ConstructorWindow(driver);

        constructorWindow.checkScrollFillingsElemet();
    }

}
