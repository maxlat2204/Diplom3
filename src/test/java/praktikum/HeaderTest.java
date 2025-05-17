package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserModel;
import praktikum.pages.main.MainPage;
import praktikum.pages.PersonalAccountPage;
import praktikum.pages.auth.EntrancePage;

import static praktikum.api.UserSteps.createUserStep;
import static praktikum.api.UserSteps.deletedUserStep;

public class HeaderTest {

    static UserModel user = UserModel.random();
    private static String accessToken;

    @ClassRule
    public static praktikum.DriverRule factory = new praktikum.DriverRule();

    @BeforeClass
    public static void createUser(){
        accessToken = createUserStep(user)
                .extract().path("accessToken");
    }

    @AfterClass
    public static void delUser(){
        deletedUserStep(accessToken);
    }

    @Test
    @DisplayName("Тест на переход в Личный кабинет")
    @Description("Проверяем, что можно перейти в Личный кабинет")
    public void checkTransferPersonalAccount(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccountButton();
        entrancePage.fillFormEntrance(user);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.goWindowPersonalAccountPage();
    }

    @Test
    @DisplayName("Тест на переход из Личного кабинета в конструктор, через Логотип")
    @Description("Проверяем, что можно перейти из Личного кабинета в конструктор, через Логотип")
    public void checkTransferLogo() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);

        mainPage.clickPersonalAccountButton();
        mainPage.clickLogoStellarBurgersButton();
        mainPage.goWindowMainPage();
    }

    @Test
    @DisplayName("Тест на переход из Личного кабинета в конструктор, через кнопку Конструктор")
    @Description("Проверяем, что можно перейти из Личного кабинета в конструктор, через кнопку Конструктор")
    public void checkTransferConstructor() {
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);

        mainPage.clickPersonalAccountButton();
        mainPage.clickConstructorButton();
        mainPage.goWindowMainPage();
    }

}
