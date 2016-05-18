package agency.kaos.mvcdroid.presenters;

import android.app.Activity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.LinkedList;

import agency.kaos.mvcdroid.LoginActivity;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by keya on 18/05/16.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Test
    public void noUsernameTest() {

        // Mocking
        LoginActivity mock = mock(LoginActivity.class);
        when(mock.getUsername()).thenReturn("");

        // Init
        LoginPresenter mLoginPresenter = new LoginPresenter(mock);
        mLoginPresenter.validateCredentials();

        // Verify
        verify(mock).showError("Username cannot be empty.");
    }

    @Test
    public void noPasswordTest() {

        // Mocking
        LoginActivity mock = mock(LoginActivity.class);
        when(mock.getUsername()).thenReturn("asd");
        when(mock.getPassword()).thenReturn("");

        // Init
        LoginPresenter mLoginPresenter = new LoginPresenter(mock);
        mLoginPresenter.validateCredentials();

        // Verify
        verify(mock).showError("Password cannot be empty.");
    }


    @Test
    public void invalidCredentialsTest() {

        // Mocking
        LoginActivity mock = mock(LoginActivity.class);
        when(mock.getUsername()).thenReturn("asd");
        when(mock.getPassword()).thenReturn("asd");

        // Init
        LoginPresenter mLoginPresenter = new LoginPresenter(mock);
        mLoginPresenter.validateCredentials();

        // Verify
        verify(mock).showError("Login failed.");
    }

    @Test
    public void validCredentialsTest() {

        // Mocking
        LoginActivity mock = mock(LoginActivity.class);
        when(mock.getUsername()).thenReturn("k");
        when(mock.getPassword()).thenReturn("asdasd");

        // Init
        LoginPresenter mLoginPresenter = new LoginPresenter(mock);
        mLoginPresenter.validateCredentials();

        // Verify
        verify(mock).navigateToMainActivity();
    }


}
