package john.smith.espressotesting2;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private String stringToBetyped;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        stringToBetyped = "Espresso";
    }

    @Test
    public void changeText_sameActivity() throws InterruptedException {
        // Type text and then press the button.
        onView(withId(R.id.editTextUserInput))
                .perform(typeText("Hello"), closeSoftKeyboard());
        onView(withId(R.id.btnChangeText)).perform(click());
        Thread.sleep(5000);
        // Check that the text was changed.
        onView(withId(R.id.editTextUserInput))
                .check(matches(withText(stringToBetyped)));
    }

    @Test
    public void edit_text_has_hint() {

        // Check that the text has hint value with specific value
        onView(withId(R.id.editTextUserInput))
                .check(matches(withHint("Type name")));
    }
}