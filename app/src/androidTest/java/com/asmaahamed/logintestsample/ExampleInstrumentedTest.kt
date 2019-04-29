package com.asmaahamed.logintestsample

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.TypeTextAction
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import kotlinx.android.synthetic.main.activity_main.*


import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
    @JvmField
    val rule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.asmaahamed.logintestsample", appContext.packageName)
    }

    @Test
    fun user_can_enter_frist_name(){
    onView(withId(R.id.fristName_editText)).perform(typeText("asmaa"))
    }


    @Test
    fun user_can_enter_last_name(){
     onView(withId(R.id.lastName_editText)).perform(typeText("hamed"))
    }

    @Test
    fun when_user_enter_frist_and_last_name_check_message_is_correct(){
        onView(withId(R.id.fristName_editText)).perform(typeText("asmaa"))
        onView(withId(R.id.lastName_editText)).perform(typeText("hamed"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message_textView)).check(matches(withText("welcom,asmaa hamed!")))
    }

}
