package com.example.android.unscramble.ui

data class GameUiState(
    val currentScrambleWord: String = "",
    val score: Int = 0,
    val wordCount: Int = 0,
    val isGuessedWordWrong: Boolean = false
)