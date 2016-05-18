package agency.kaos.mvcdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agency.kaos.mvcdroid.interfaces.LoginPresenterInterface;
import agency.kaos.mvcdroid.interfaces.LoginView;
import agency.kaos.mvcdroid.presenters.LoginPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private LoginPresenter iLoginPresenter;

    EditText username;
    EditText password;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iLoginPresenter = new LoginPresenter(this);

        username = (EditText) findViewById(R.id.username_textView);
        password = (EditText) findViewById(R.id.password_textView);

        login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginPresenter.validateCredentials();
            }
        });
    }


    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void navigateToMainActivity() {
        Toast.makeText(this, "Login SUCCESS! You won't be navigated away though!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
