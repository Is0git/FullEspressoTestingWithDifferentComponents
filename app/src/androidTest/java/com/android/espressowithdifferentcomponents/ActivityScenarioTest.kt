package com.android.espressowithdifferentcomponents

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityScenarioTest {


    @Before
    fun launchActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun activityIsolationTest() {
        onView(withId(R.id.firstLayout)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.navigateButton)).perform(ViewActions.click())

//        onView(withId(R.id.secondLayout)).check(ViewAssertions.matches(isDisplayed()))

        //Another way to check visibility

        onView(withId(R.id.secondLayout)).check(ViewAssertions.matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.secondTextView)).check(ViewAssertions.matches(withText("WELCOME TO SECOND ACTIVTY!")))
    }

}