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

public class RegisterPage {

    private final WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public final By nameInput = By.xpath(".//label[text()='Имя']/parent::div/input[@name='name']");
    public final By emailInput = By.xpath(".//label[text()='Email']/parent::div/input[@name='name']");
    public final By passwordInput = By.xpath(".//input[@name='Пароль']");
    public final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    public final By registerErrorPassword = By.xpath(".//p[text()='Некорректный пароль']");
    public final By entranceButtonRegisterPage = By.className("Auth_link__1fOlj");


    //Метод ввода имени
    @Step("Ввод имени, на странице Регистрации")
    public void fillNameRegister(String name) {
        assertTrue(driver.findElement(nameInput).isEnabled());
        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
    }

    //Метод ввода email
    @Step("Ввод email, на странице Регистрации")
    public void fillEmailRegister(String email) {
        assertTrue(driver.findElement(emailInput).isEnabled());
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    //Метод ввода password
    @Step("Ввод password, на странице Регистрации")
    public void fillPasswordRegister(String password) {
        assertTrue(driver.findElement(passwordInput).isEnabled());
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    //Метод клика на кнопку Зарегистрироваться
    @Step("Клик на кнопку Зарегистрироваться, на странице Регистрации")
    public void clickRegisterButton(){
        assertTrue(driver.findElement(registerButton).isEnabled());
        driver.findElement(registerButton).click();
    }

    //Метод клика на кнопку Войти
    @Step("Клик на кнопку Войти, на странице Регистрации")
    public void clickEntranceButtonRegisterPage(){
        assertTrue(driver.findElement(entranceButtonRegisterPage).isEnabled());
        driver.findElement(entranceButtonRegisterPage).click();
    }

    //Метод ввода данных в форму Регистрации
    @Step("Ввод данных в форму Регистрации, на странице Регистрации")
    public void fillFormRegister(UserModel user) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(nameInput));
        fillNameRegister(user.getName());
        fillEmailRegister(user.getEmail());
        fillPasswordRegister(user.getPassword());
        clickRegisterButton();
    }

    //Метод подтверждения регистрации
    @Step("Проверка регистрации и перехода на страницу Вход")
    public boolean registerFinal() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(EntrancePage.windowEntrance));
        assertTrue("Зарегистрироваться не получилось",driver.findElement(EntrancePage.windowEntrance).isDisplayed());
            return true;
    }

    //Метод появления ошибки в поле пароль
    @Step("Проверка появление ошибки неверный пароль, на странице Регистрации")
    public void checkRegisterErrorPassword() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(registerErrorPassword));
        assertTrue("Ошибка не выходит",driver.findElement(registerErrorPassword).isDisplayed());
    }


}
