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
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.onAllNodesWithTag

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

    @Test
    fun testSliderUpdatesVolumeText() {
        composeTestRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        composeTestRule.onNodeWithText("Volum: 0%").assertIsDisplayed()

        composeTestRule.onNodeWithTag("sliderValue_id")
            .performSemanticsAction(SemanticsActions.SetProgress) { action ->
                action(50f)
            }

        composeTestRule.onNodeWithText("Volum: 50%").assertIsDisplayed()
    }

    @Test
    fun testRadioButtonSelectionChanges() {
        composeTestRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        // Verificamos que Messi está seleccionado por defecto (según tu ViewModel)
        val playerTag = "pilotaDOr_id_Lamine Yamal"

        // Pulsamos el RadioButton de Lamine Yamal
        composeTestRule.onNodeWithTag(playerTag).performClick()

        // Verificamos que ahora está seleccionado
        composeTestRule.onNodeWithTag(playerTag).assertIsSelected()
    }

    @Test
    fun testDropdownMenuSelection() {
        composeTestRule.setContent {
            MainView(myViewModel = MainViewModel())
        }

        // Pulsamos el texto que abre el menú
        composeTestRule.onNodeWithText("Opció A").performClick()

        //  Verificamos que aparece la Opció B en el menú desplegado
        composeTestRule.onAllNodesWithTag("opcion_id")[1].performClick() // Índice 1 es Opció B

        // Verificamos que el texto principal ha cambiado a Opció B
        composeTestRule.onNodeWithText("Opció B").assertIsDisplayed()
    }
}