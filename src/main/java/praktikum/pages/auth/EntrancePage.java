package praktikum.pages.auth;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;
import praktikum.api.UserModel;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class EntrancePage {

    private final WebDriver driver;
    public EntrancePage(WebDriver driver){
        this.driver = driver;
    }

    public final By buttonRegisterAccount = By.xpath(".//a[text()='Зарегистрироваться']");
    public static final By windowEntrance = By.className("Auth_login__3hAey");
    public final By emailInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='text']");
    public final By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' and @type='password']");
    public final By entranceButton = By.xpath(".//button[text()='Войти']");
    public final By passwordRecoveryButton = By.xpath(".//a[text()='Восстановить пароль']");

    //Метод клика на кнопку Зарегистрироваться
    @Step("Клик на кнопку Зарегистрироваться, на странице Вход")
    public void clickRegisterAccount(){
        assertTrue(driver.findElement(buttonRegisterAccount).isEnabled());
        driver.findElement(buttonRegisterAccount).click();
    }

    //Метод ввода email
    @Step("Ввод email, на странице Вход")
    public void fillEmailEntrance(String email) {
        assertTrue(driver.findElement(emailInput).isEnabled());
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    //Метод ввода password
    @Step("Ввод password, на странице Вход")
    public void fillPasswordEntrance(String password) {
        assertTrue(driver.findElement(passwordInput).isEnabled());
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Метод клика на кнопку Вход
    @Step("Клик на кнопку Вход, на странице Вход")
    public void clickEntranceButton(){
        assertTrue(driver.findElement(entranceButton).isEnabled());
        driver.findElement(entranceButton).click();
    }

    //Метод клика на кнопку Восстановить пароль
    @Step("Клик на кнопку Восстановить пароль, на странице Вход")
    public void clickPasswordRecovery(){
        assertTrue(driver.findElement(passwordRecoveryButton).isEnabled());
        driver.findElement(passwordRecoveryButton).click();
    }

    //Метод ввода данных в форму Входа
    @Step("Ввод данных в форму Входа, на странице Вход")
    public void fillFormEntrance(UserModel user) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        fillEmailEntrance(user.getEmail());
        fillPasswordEntrance(user.getPassword());
        clickEntranceButton();
    }

    //Метод появления страницы Входа
    @Step("Проверка что страница вход открылась")
    public void goWindowEntrancePage() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(windowEntrance));
        assertTrue("Выйти не получилось",driver.findElement(windowEntrance).isDisplayed());
    }
}
