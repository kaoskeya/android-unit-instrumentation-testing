package agency.kaos.mvcdroid.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import agency.kaos.mvcdroid.LoginActivity;
import agency.kaos.mvcdroid.presenters.LoginPresenter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by keya on 18/05/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserTest {

    @Test
    public void UserClassTest() {
        // Mocking
        User mock = mock(User.class);

        // Init
        mock.setUsername("k");

        // Verify
        verify(mock).getUsername().equals("k");
    }
}
