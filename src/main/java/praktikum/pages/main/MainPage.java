package praktikum.pages.main;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class MainPage {

    private final WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    public final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    public final By buttonFeedOrder = By.xpath(".//p[text()='Лента Заказов']");
    public final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    public final By logoStellarBurgers = By.className("AppHeader_header__logo__2D0X2");

    public final By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By windowMain = By.className("App_componentContainer__2JC2W");

    //Метод клика на кнопку Личный кабинет
    @Step("Клик на кнопку Личный кабинет, на Главной странице")
    public void clickPersonalAccountButton(){
        assertTrue(driver.findElement(buttonPersonalAccount).isEnabled());
        driver.findElement(buttonPersonalAccount).click();
    }

    //Метод клика на кнопку Войти в аккаунт
    @Step("Клик на кнопку Войти в аккаунт, на Главной странице")
    public void clickEnterAccountButton(){
        assertTrue(driver.findElement(buttonEnterAccount).isEnabled());
        driver.findElement(buttonEnterAccount).click();
    }

    //Метод клика на Логотип бургера
    @Step("Клик на кнопку Логотип бургера, в Шапке")
    public void clickLogoStellarBurgersButton(){
        assertTrue(driver.findElement(logoStellarBurgers).isEnabled());
        driver.findElement(logoStellarBurgers).click();
    }

    //Метод клика на Конструктор
    @Step("Клик на кнопку Конструктор, в Шапке")
    public void clickConstructorButton(){
        assertTrue(driver.findElement(buttonConstructor).isEnabled());
        driver.findElement(buttonConstructor).click();
    }

    //Метод появления Главной страницы
    @Step("Проверка что Главная страница открылась")
    public void goWindowMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(windowMain));
        assertTrue("Войти не получилось",driver.findElement(windowMain).isDisplayed());
    }
}
