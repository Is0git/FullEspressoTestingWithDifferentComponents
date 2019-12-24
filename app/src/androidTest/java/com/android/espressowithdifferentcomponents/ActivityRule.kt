package com.android.espressowithdifferentcomponents

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ActivityRule {

    @get: Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun activityIsolationTest() {
        Espresso.onView(ViewMatchers.withId(R.id.firstLayout))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.navigateButton)).perform(ViewActions.click())

//        onView(withId(R.id.secondLayout)).check(ViewAssertions.matches(isDisplayed()))

        //Another way to check visibility

        Espresso.onView(ViewMatchers.withId(R.id.secondLayout))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
        Espresso.onView(ViewMatchers.withId(R.id.secondTextView))
            .check(ViewAssertions.matches(ViewMatchers.withText("WELCOME TO SECOND ACTIVTY!")))

       pressBack()
        Espresso.onView(ViewMatchers.withId(R.id.firstLayout))
    }

}