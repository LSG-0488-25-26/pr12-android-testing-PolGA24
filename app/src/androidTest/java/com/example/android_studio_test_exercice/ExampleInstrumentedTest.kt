package com.example.android_studio_test_exercice

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

import org.junit.Rule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.assertIsDisplayed
import com.example.android_studio_test_exercice.view.MainView
import com.example.android_studio_test_exercice.viewmodel.MainViewModel

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android_studio_test_exercice", appContext.packageName)
    }

    @Test
    fun checkSearchFunctionalityDisplaysSnackbar() {

        composeTestRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeTestRule.onNodeWithTag("searchText_id")
            .performTextInput("Aprender Jetpack Compose")

        composeTestRule.onNodeWithTag("searchButton_id")
            .performClick()

        composeTestRule.onNodeWithText("Acció completada!")
            .assertIsDisplayed()
    }
}