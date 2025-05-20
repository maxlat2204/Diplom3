package praktikum.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class PersonalAccountPage {

    private final WebDriver driver;
    public PersonalAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public final By buttonExit = By.xpath(".//button[text()='Выход']");
    public final By windowPersonalAccountPage = By.className("App_componentContainer__2JC2W");

    //Метод клика на кнопку Выход
    @Step("Клик на кнопку Выход, в Личном кабинете")
    public void clickExitButton(){
        assertTrue(driver.findElement(buttonExit).isEnabled());
        driver.findElement(buttonExit).click();
    }

    //Метод появления страницы Личного кабинета
    @Step("Проверка что страница Личного кабинета открылась")
    public void goWindowPersonalAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOfElementLocated(windowPersonalAccountPage));
        assertTrue("Выйти не получилось",driver.findElement(windowPersonalAccountPage).isDisplayed());
    }

}
