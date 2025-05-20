package praktikum;

import com.github.javafaker.Faker;

public class EnvConfig {
    public static Faker faker = new Faker();

    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final int EXPLICIT_WAIT = 10;
    public static final int IMLICIT_WAIT = 3;

    public static final String USER_EMAIL = faker.internet().emailAddress(); //генератор случайной почты
    public static final String USER_PASSWORD = faker.internet().password(); //генератор случайного пароля
    public static final String USER_NAME = faker.name().username(); //генератор случайного имя пользователя

    public static final String CLASS_SELECTED_TAB = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";

}
