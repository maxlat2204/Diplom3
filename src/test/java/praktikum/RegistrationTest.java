package praktikum;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserModel;
import praktikum.pages.MainPage;
import praktikum.pages.auth.EntrancePage;
import praktikum.pages.auth.RegisterPage;

import static org.junit.Assert.assertEquals;
import static praktikum.EnvConfig.*;

public class RegistrationTest {

    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    UserModel user = UserModel.random();

    @After
    public void delUser(){


    }

    @Test
    //Проверка успешной регистрации пользователя
    public void checkSuccessRegisterUser() {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var registerPage = new RegisterPage(driver);

        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
//        registerPage.fillFormScooter(USER_NAME, USER_EMAIL, USER_PASSWORD);//Заполнение формы регистрации
        registerPage.fillFormScooter(user);
        registerPage.registerFinal();//Проверка перехода после регистрации на окно Вход
    }

    @Test
    //Проверка появления ошибки регистрации при не валидном пароле
    public void checkErrorNoValidPassword() {
        WebDriver driver = factory.getDriver();

        var mainPage = new MainPage(driver);
        var entrancePage = new EntrancePage(driver);
        var registerPage = new RegisterPage(driver);
        user.setPassword("1234");

        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
        registerPage.fillFormScooter(user);//Заполнение формы регистрации
        registerPage.checkRegisterErrorPassword();//Проверка перехода после регистрации на окно Вход
    }

}
