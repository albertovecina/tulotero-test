package com.vsa.tulotero

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.vsa.tulotero.view.main.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun textShowKeyboardOnEditTextClick() {
        onView(withId(R.id.editTextFilter))
            .perform(click())
        assert(isKeyboardShown())
    }

    @Test
    fun testShowEmptyListMessage() {
        onView(withId(R.id.editTextFilter))
            .perform(typeText("xxxxxx"))
        onView(withId(R.id.recyclerViewLotteryBooths))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testEmptyCounter() {
        onView(withId(R.id.editTextFilter))
            .perform(typeText("xxxxxx"))
        onView(withId(R.id.textViewItemCount))
            .check(matches(withText("0")))
    }

    private fun isKeyboardShown(): Boolean {
        val inputMethodManager =
            InstrumentationRegistry.getInstrumentation().targetContext.getSystemService(
                Context.INPUT_METHOD_SERVICE
            ) as InputMethodManager
        return inputMethodManager.isAcceptingText
    }
}
