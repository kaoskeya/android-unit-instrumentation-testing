package agency.kaos.mvcdroid;

import android.os.IBinder;
import android.support.test.espresso.Root;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.WindowManager;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.app.PendingIntent.getActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.core.deps.guava.base.Predicates.not;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;

/**
 * Created by keya on 18/05/16.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    private String usernameToBeTyped, passwordToBeTyped;

    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivity = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    @Before
    public void initValidString() {
        usernameToBeTyped = "coolUser";
        passwordToBeTyped = "securePassword";
    }

    @Test
    public void usernameSetTest() {
        onView(withId(R.id.username_textView)).perform(typeText(usernameToBeTyped), closeSoftKeyboard());
        assertEquals(mLoginActivity.getActivity().getUsername(), usernameToBeTyped);
    }

    @Test
    public void passwordSetTest() {
        onView(withId(R.id.password_textView)).perform(typeText(passwordToBeTyped), closeSoftKeyboard());
        assertEquals(mLoginActivity.getActivity().getPassword(), passwordToBeTyped);
    }

}
