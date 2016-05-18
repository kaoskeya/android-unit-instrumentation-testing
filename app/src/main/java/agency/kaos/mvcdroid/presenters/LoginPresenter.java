package agency.kaos.mvcdroid.presenters;

import android.util.Log;

import agency.kaos.mvcdroid.interfaces.IListener;
import agency.kaos.mvcdroid.interfaces.LoginPresenterInterface;
import agency.kaos.mvcdroid.interfaces.LoginServiceInterface;
import agency.kaos.mvcdroid.interfaces.LoginView;
import agency.kaos.mvcdroid.models.User;
import agency.kaos.mvcdroid.services.LoginService;

/**
 * Created by keya on 18/05/16.
 */
public class LoginPresenter implements LoginPresenterInterface, IListener<User> {

    LoginView iLoginView;
    LoginServiceInterface iLoginService;

    public LoginPresenter(LoginView loginView) {
        iLoginView = loginView;
        iLoginService = new LoginService();
    }

    @Override
    public void onSuccess(User user) {
        iLoginView.navigateToMainActivity();
    }

    @Override
    public void onFailure(String errorMessage) {
        iLoginView.showError("Login failed.");
    }

    @Override
    public void validateCredentials() {

        String username = iLoginView.getUsername();

        if( username.isEmpty() ) {
            iLoginView.showError("Username cannot be empty.");
            return;
        }

        String password = iLoginView.getPassword();

        if( password.isEmpty() ) {
            iLoginView.showError("Password cannot be empty.");
            return;
        }

        iLoginService.validateCredentialsFromBackendService(username, password, this);
    }
}
