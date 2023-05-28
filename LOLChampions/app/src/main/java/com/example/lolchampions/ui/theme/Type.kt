package com.example.lolchampions.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.lolchampions.R

val Sricha = FontFamily(
    Font(R.font.sriracha_regular)
)
// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = Sricha,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),

    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    )
)