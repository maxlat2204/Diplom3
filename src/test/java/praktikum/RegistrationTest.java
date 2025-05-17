package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserModel;
import praktikum.pages.main.MainPage;
import praktikum.pages.auth.EntrancePage;
import praktikum.pages.auth.RegisterPage;

import static praktikum.api.UserSteps.regAndDelUser;

public class RegistrationTest {
    UserModel user = UserModel.random();
    private boolean tokenDel;

    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    @After
    public void delUser(){
        if (tokenDel) {
            regAndDelUser(user);
        }
    }

    @Test
    @DisplayName("Позитивный тест на успешную регистрацию пользователя")
    @Description("Проверяем успешную регистрацию пользователя с валидными данными")
    //Проверка успешной регистрации пользователя
    public void checkSuccessRegisterUser() {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var registerPage = new RegisterPage(driver);

        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
        registerPage.fillFormRegister(user);//Заполнение формы регистрации
        tokenDel = registerPage.registerFinal();//Проверка перехода после регистрации на окно Вход
    }

    @Test
    @DisplayName("Негативный тест на регистрацию пользователя, с невалидным паролем")
    @Description("Проверяем, что пользователь не может зарегистрироваться, с невалидными паролем, и что выходит ошибка")
    //Проверка появления ошибки регистрации при не валидном пароле
    public void checkErrorNoValidPassword() {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var registerPage = new RegisterPage(driver);
        user.setPassword("1234");

        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
        registerPage.fillFormRegister(user);//Заполнение формы регистрации
        registerPage.checkRegisterErrorPassword();//Проверка появления ошибки регистрации при не валидном пароле
    }

}
