package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    //Game UI State
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
            val dessertSold = _uiState.value.dessertSold + 1
            val nextDessertIndex = determineDessertIndex(dessertSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                dessertSold = dessertSold,
                revenue = cupcakeUiState.revenue + _uiState.value.currentDessertPrice,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for(index in dessertList.indices) {
            if(dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            }
            else {
                // The list of desserts is sorted by startProductionAmount. As you sell more
                // desserts, you'll start producing more expensive desserts as determined by
                // startProductionAmount. We know to break as soon as we see a dessert who's
                // "startProductionAmount" is greater than the amount sold.
                break;
            }
        }
        return dessertIndex
    }
}
