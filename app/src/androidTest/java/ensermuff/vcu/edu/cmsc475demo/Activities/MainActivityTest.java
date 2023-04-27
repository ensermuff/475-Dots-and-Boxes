package ensermuff.vcu.edu.cmsc475demo.Activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ensermuff.vcu.edu.cmsc475demo.R;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> myActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void testImageBtns(){
        onView(withId(R.id.playBtn)).check(matches((isDisplayed())));
        onView(withId(R.id.settingsBtn)).check(matches((isDisplayed())));
        onView(withId(R.id.historyBtn)).check(matches((isDisplayed())));
        onView(withId(R.id.infoBtn)).check(matches((isDisplayed())));
    }
    @Test
    public void testImageViews(){
        onView(withId(R.id.SquaresLogo)).check(matches((isDisplayed())));
        onView(withId(R.id.Vcu)).check(matches((isDisplayed())));
    }
    //test functionality of the buttons

}
