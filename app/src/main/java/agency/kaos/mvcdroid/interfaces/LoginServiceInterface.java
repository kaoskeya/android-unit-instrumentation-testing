package agency.kaos.mvcdroid.interfaces;

import agency.kaos.mvcdroid.models.User;

/**
 * Created by keya on 18/05/16.
 */
public interface LoginServiceInterface {

    void validateCredentialsFromBackendService(String username, String password,  IListener<User> userCallback);

}
