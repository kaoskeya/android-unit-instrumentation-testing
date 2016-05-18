package agency.kaos.mvcdroid.interfaces;

/**
 * Created by keya on 18/05/16.
 */
public interface LoginView {

    String getUsername();
    String getPassword();
    void navigateToMainActivity();
    void showError(String error);

}

