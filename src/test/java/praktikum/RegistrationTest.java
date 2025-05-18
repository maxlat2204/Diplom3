package praktikum;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import praktikum.api.UserModel;
import praktikum.pages.main.MainPage;
import praktikum.pages.auth.EntrancePage;
import praktikum.pages.auth.RegisterPage;

import static praktikum.api.UserSteps.regAndDelUser;

public class RegistrationTest {

    @Rule
    public praktikum.DriverRule factory = new praktikum.DriverRule();

    private MainPage mainPage;
    private EntrancePage entrancePage;
    private RegisterPage registerPage;

    UserModel user = UserModel.random();
    private boolean tokenDel;

    @Before
    public void setUp(){
        WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        entrancePage = new EntrancePage(driver);
        registerPage = new RegisterPage(driver);
    }

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
    public void checkSuccessRegisterUserTest() {
        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
        registerPage.fillFormRegister(user);//Заполнение формы регистрации
        tokenDel = registerPage.registerFinal();//Проверка перехода после регистрации на окно Вход
    }

    @Test
    @DisplayName("Негативный тест на регистрацию пользователя, с невалидным паролем")
    @Description("Проверяем, что пользователь не может зарегистрироваться, с невалидными паролем, и что выходит ошибка")
    //Проверка появления ошибки регистрации при не валидном пароле
    public void checkErrorNoValidPasswordTest() {
        user.setPassword("1234");

        mainPage.clickPersonalAccountButton();//Переход в личный кабинет
        entrancePage.clickRegisterAccount();//Переход на окно регистрации
        registerPage.fillFormRegister(user);//Заполнение формы регистрации
        registerPage.checkRegisterErrorPassword();//Проверка появления ошибки регистрации при не валидном пароле
    }

}
