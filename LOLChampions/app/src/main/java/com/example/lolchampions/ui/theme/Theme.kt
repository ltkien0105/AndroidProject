package com.example.lolchampions.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@SuppressLint("ConflictingOnColor")
private val DarkColorPalette = darkColors(
    background = dark_background,
    surface = dark_surface,
    onSurface = dark_onSurface,
    primary = dark_primary,
    onPrimary = dark_onPrimary,
    secondary = dark_secondary
)

private val LightColorPalette = lightColors(
    background = light_background,
    surface = light_surface,
    onSurface = light_onSurface,
    primary = light_primary,
    onPrimary = light_onPrimary,
    secondary = light_secondary
)

@Composable
fun LOLChampionsTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}