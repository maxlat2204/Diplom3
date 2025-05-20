package praktikum.api;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.Data;
import praktikum.EnvConfig;

@Data
@AllArgsConstructor
public class UserModel {
    private String email;
    private String password;
    private String name;

    //Метод создания рандомного пользователя
    public static UserModel random(){
        return new UserModel(EnvConfig.USER_EMAIL, EnvConfig.USER_PASSWORD, EnvConfig.USER_NAME);
    }

}
