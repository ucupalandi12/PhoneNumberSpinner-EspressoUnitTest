package com.example.android.phonenumberspinner;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SpinnerSelectionTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void iterateSpinnerItems(){
        String[] myArray = mActivityRule.getActivity().getResources().getStringArray(R.array.labels_array);
        int size = myArray.length;
        for (int i = 0; i < size; i++) {
            // Find the spinner and click on it.
            onView(withId(R.id.label_spinner)).perform(click());

            // Find the spinner item and click on it
            onData(is(myArray[i])).perform(click());

            // Find the submit button and click on it
            onView(withId(R.id.button_main)).perform(click());

            /* Find the text view and check that the spinner item
               is part of the string
             */
            onView(withId(R.id.text_phonelabel)).check(matches(withText(containsString(myArray[i]))));
        }
    }
}
