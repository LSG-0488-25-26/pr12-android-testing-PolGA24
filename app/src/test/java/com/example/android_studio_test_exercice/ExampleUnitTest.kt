package com.example.android_studio_test_exercice

import org.junit.Test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.android_studio_test_exercice.viewmodel.MainViewModel
import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val viewModel = MainViewModel()

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `test initial values`() {
        // Comprobamos que los valores empiezan como queremos
        assertEquals(true, viewModel.estatSwitch.value)
        assertEquals("Messi", viewModel.selectedOption.value)
        assertEquals(0f, viewModel.sliderValue.value)
    }

    @Test
    fun `test performSearch updates showSnackbar`() {
        //Al principio debe ser false
        assertEquals(false, viewModel.showSnackbar.value)

        //Llamamos a la función
        viewModel.performSearch()

        //Ahora debe ser true
        assertEquals(true, viewModel.showSnackbar.value)
    }

    @Test
    fun `test setSliderValue updates LiveData`() {
        viewModel.setSliderValue(50f)
        assertEquals(50f, viewModel.sliderValue.value)
    }

    @Test
    fun `test toggleEstatSwitch changes value`() {
        val initialValue = viewModel.estatSwitch.value!!
        viewModel.toggleEstatSwitch()
        assertEquals(!initialValue, viewModel.estatSwitch.value)
    }
}