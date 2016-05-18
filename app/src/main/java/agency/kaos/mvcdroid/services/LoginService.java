package agency.kaos.mvcdroid.services;

import org.json.JSONObject;

import java.util.Objects;

import agency.kaos.mvcdroid.interfaces.IListener;
import agency.kaos.mvcdroid.interfaces.LoginServiceInterface;
import agency.kaos.mvcdroid.models.User;

/**
 * Created by keya on 18/05/16.
 */
public class LoginService implements LoginServiceInterface {

    public LoginService() {

    }

    @Override
    public void validateCredentialsFromBackendService(String username, String password, IListener<User> userCallback) {

        if(Objects.equals(username, "k") && Objects.equals(password, "asdasd")) {

            User user = new User();
            user.setUsername("k");

            userCallback.onSuccess(user);
        } else {
            userCallback.onFailure("Invalid credentials.");
        }

    }

}
