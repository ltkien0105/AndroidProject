package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.model.Dessert

/**
 * Data class that represents the game UI state
 */
data class GameUiState (
    val currentDessertIndex: Int = 0,
    val dessertSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)