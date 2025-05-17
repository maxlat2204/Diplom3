package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserModel;
import praktikum.pages.main.MainPage;
import praktikum.pages.PersonalAccountPage;
import praktikum.pages.auth.EntrancePage;
import praktikum.pages.auth.PasswordRecoveryPage;
import praktikum.pages.auth.RegisterPage;

import static praktikum.api.UserSteps.createUserStep;
import static praktikum.api.UserSteps.deletedUserStep;

public class EntranceTest {
    UserModel user = UserModel.random();
    private String accessToken;

    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    @Before
    public void createUser(){
        accessToken = createUserStep(user)
                .extract().path("accessToken");
    }

    @After
    public void delUser(){
        deletedUserStep(accessToken);
    }

    @Test
    @DisplayName("Тест на вход через кнопку Войти в аккаунт на главной странице")
    @Description("Проверяем вход в аккаунт через кнопку Войти в аккаунт на главной странице")
    public void buttonEnterAccountMainPage(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);

        mainPage.clickEnterAccountButton();
        entrancePage.fillFormEntrance(user);
        mainPage.goWindowMainPage();
    }

    @Test
    @DisplayName("Тест на вход через Личный кабинет")
    @Description("Проверяем вход в аккаунт через Личный кабинет")
    public void buttonEnterPersonalAccount(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);

        mainPage.clickPersonalAccountButton();
        entrancePage.fillFormEntrance(user);
        mainPage.goWindowMainPage();
    }

    @Test
    @DisplayName("Тест на вход через кнопку в Форме регистрации")
    @Description("Производим вход в аккаунт через кнопку в Форме регистрации")
    public void buttonEnterFormRegister(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var registerPage = new RegisterPage(driver);

        mainPage.clickPersonalAccountButton();
        entrancePage.clickRegisterAccount();
        registerPage.clickEntranceButtonRegisterPage();
        entrancePage.fillFormEntrance(user);
        mainPage.goWindowMainPage();
    }

    @Test
    @DisplayName("Тест на вход через кнопку в форме восстановления пароля")
    @Description("Производим вход в аккаунт через кнопку в форме восстановления пароля")
    public void buttonEnterFormPasswordRecovery(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var passwordRecoveryPage = new PasswordRecoveryPage(driver);

        mainPage.clickPersonalAccountButton();
        entrancePage.clickPasswordRecovery();
        passwordRecoveryPage.clickEntranceButtonPasswordRecoveryPage();
        entrancePage.fillFormEntrance(user);
        mainPage.goWindowMainPage();
    }

    @Test
    @DisplayName("Тест на Выход из аккаунта")
    @Description("Проверяем Выход из аккаунта")
    public void exitInAccount(){
        WebDriver driver = factory.getDriver();
        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var personalAccountPage = new PersonalAccountPage(driver);

        mainPage.clickPersonalAccountButton();
        entrancePage.fillFormEntrance(user);
        mainPage.clickPersonalAccountButton();
        personalAccountPage.clickExitButton();
        entrancePage.goWindowEntrancePage();
    }

}
