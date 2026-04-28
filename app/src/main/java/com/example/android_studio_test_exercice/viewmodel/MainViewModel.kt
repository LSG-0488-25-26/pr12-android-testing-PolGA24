package com.example.android_studio_test_exercice.viewmodel

import androidx.compose.ui.state.ToggleableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _estatSwitch = MutableLiveData(true)
    val estatSwitch: LiveData<Boolean> = _estatSwitch

    private val _esVegetaria = MutableLiveData(false)
    val esVegetaria: LiveData<Boolean> = _esVegetaria

    private val _esVega = MutableLiveData(false)
    val esVega: LiveData<Boolean> = _esVega

    private val _esCarnivor = MutableLiveData(true)
    val esCarnivor: LiveData<Boolean> = _esCarnivor

    private val _triStateStatus = MutableLiveData(ToggleableState.Off)
    val triStateStatus: LiveData<ToggleableState> = _triStateStatus

    private val _selectedOption = MutableLiveData("Messi")
    val selectedOption: LiveData<String> = _selectedOption

    private val _sliderValue = MutableLiveData(0f)
    val sliderValue: LiveData<Float> = _sliderValue

    private val _expanded = MutableLiveData(false)
    val expanded: LiveData<Boolean> = _expanded

    private val _selectedItem = MutableLiveData("Opció A")
    val selectedItem: LiveData<String> = _selectedItem

    private val _searchText = MutableLiveData("")
    val searchText: LiveData<String> = _searchText

    private val _showSnackbar = MutableLiveData(false)
    val showSnackbar: LiveData<Boolean> = _showSnackbar

    private val _toggleState = MutableLiveData(false)
    val toggleState: LiveData<Boolean> = _toggleState

    fun toggleEstatSwitch() {
        _estatSwitch.value = !(_estatSwitch.value ?: true)
    }

    fun toggleEsCarnivor() {
        _esCarnivor.value = !(_esCarnivor.value ?: true)
    }

    fun toggleEsVegetaria() {
        _esVegetaria.value = !(_esVegetaria.value ?: false)
    }

    fun toggleEsVega() {
        _esVega.value = !(_esVega.value ?: false)
    }

    fun toggleTriStateStatus() {
        _triStateStatus.value = when (_triStateStatus.value) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
            else -> ToggleableState.On
        }
    }

    fun setSelectedOption(player: String) {
        _selectedOption.value = player
    }

    fun setSliderValue(value: Float) {
        _sliderValue.value = value
    }

    fun setExpanded(isExpanded: Boolean) {
        _expanded.value = isExpanded
    }

    fun setSelectedItem(item: String) {
        _selectedItem.value = item
    }

    fun setSearchText(text: String) {
        _searchText.value = text
    }

    fun performSearch() {
        // Al pulsar buscar, mostramos el mensaje que verifica el Test de UI
        _showSnackbar.value = true
    }

    fun toggle() {
        // Cambia el estado del botón final
        _toggleState.value = !(_toggleState.value ?: false)
    }
}