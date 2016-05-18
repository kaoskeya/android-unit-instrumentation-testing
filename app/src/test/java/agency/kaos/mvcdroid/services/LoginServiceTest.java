package agency.kaos.mvcdroid.services;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import agency.kaos.mvcdroid.models.User;
import agency.kaos.mvcdroid.presenters.LoginPresenter;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.verify;

/**
 * Created by keya on 18/05/16.
 */
public class LoginServiceTest {

    @Test
    public void invalidLoginTest() {

        // Mock
        LoginPresenter mock = Mockito.mock(LoginPresenter.class);

        // Init
        LoginService mLoginService = new LoginService();
        mLoginService.validateCredentialsFromBackendService("asd", "asd", mock);

        verify(mock).onFailure("Invalid credentials.");
    }

    @Test
    public void validLoginTest() {

        // Mock
        LoginPresenter mock = Mockito.mock(LoginPresenter.class);

        // Init
        LoginService mLoginService = new LoginService();
        mLoginService.validateCredentialsFromBackendService("k", "asdasd", mock);

        ArgumentCaptor<User> user = ArgumentCaptor.forClass(User.class);
        verify(mock).onSuccess(user.capture());

        assertEquals("k", user.getValue().getUsername());
    }

}
