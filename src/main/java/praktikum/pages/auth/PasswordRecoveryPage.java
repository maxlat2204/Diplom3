package praktikum.pages.auth;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class PasswordRecoveryPage {

    private final WebDriver driver;
    public PasswordRecoveryPage(WebDriver driver){
        this.driver = driver;
    }

    public final By entranceButtonPasswordRecoveryPage = By.className("Auth_link__1fOlj");

    //Метод клика на кнопку Войти
    @Step("Клик на кнопку Войти, на странице Восстановления пароля")
    public void clickEntranceButtonPasswordRecoveryPage(){
        assertTrue(driver.findElement(entranceButtonPasswordRecoveryPage).isEnabled());
        driver.findElement(entranceButtonPasswordRecoveryPage).click();
    }

}
