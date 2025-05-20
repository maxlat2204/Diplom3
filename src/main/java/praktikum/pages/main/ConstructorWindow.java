package praktikum.pages.main;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.*;

public class ConstructorWindow {

    private final WebDriver driver;
    public ConstructorWindow(WebDriver driver){
        this.driver = driver;
    }

    public final By elementBuns = By.xpath(".//span[text()='Булки']/parent::div");
    public final By elementSauces = By.xpath(".//span[text()='Соусы']/parent::div");
    public final By elementFillings = By.xpath(".//span[text()='Начинки']/parent::div");

    //Метод клика на Булки
    @Step("Клик на раздел Булки, в конструкторе")
    public void clickElementBuns(){
        assertTrue(driver.findElement(elementBuns).isEnabled());
        driver.findElement(elementBuns).click();
    }

    //Метод клика на Соусы
    @Step("Клик на раздел Соусы, в конструкторе")
    public void clickElementSauces(){
        assertTrue(driver.findElement(elementSauces).isEnabled());
        driver.findElement(elementSauces).click();
    }

    //Метод клика на Начинки
    @Step("Клик на раздел Начинки, в конструкторе")
    public void clickElementFillings(){
        assertTrue(driver.findElement(elementFillings).isEnabled());
        driver.findElement(elementFillings).click();
    }

    //Метод Проверки скрола на Булки
    @Step("Проверка перехода на раздел Булки, в конструкторе")
    public void checkScrollBunsElemet() {
        if (Objects.equals(driver.findElement(elementBuns).getDomAttribute("class"), EnvConfig.CLASS_SELECTED_TAB)){
            clickElementSauces();
        }
        clickElementBuns();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(elementBuns, "class", "current"));
        assertEquals(EnvConfig.CLASS_SELECTED_TAB, driver.findElement(elementBuns).getDomAttribute("class"));
    }

    //Метод Проверки скрола на Соусы
    @Step("Проверка перехода на раздел Соусы, в конструкторе")
    public void checkScrollSaucesElemet() {
        if (Objects.equals(driver.findElement(elementSauces).getDomAttribute("class"), EnvConfig.CLASS_SELECTED_TAB)){
            clickElementBuns();
        }
        clickElementSauces();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(elementSauces, "class", "current"));
        assertEquals(EnvConfig.CLASS_SELECTED_TAB, driver.findElement(elementSauces).getDomAttribute("class"));
    }

    //Метод Проверки скрола на Начинки
    @Step("Проверка перехода на раздел Начинки, в конструкторе")
    public void checkScrollFillingsElemet() {
        if (Objects.equals(driver.findElement(elementFillings).getDomAttribute("class"), EnvConfig.CLASS_SELECTED_TAB)){
            clickElementBuns();
        }
        clickElementFillings();
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICIT_WAIT))
                .until(ExpectedConditions.attributeContains(elementFillings, "class", "current"));
        assertEquals(EnvConfig.CLASS_SELECTED_TAB, driver.findElement(elementFillings).getDomAttribute("class"));
    }

}
