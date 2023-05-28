package com.example.clickbehavior

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickbehavior.ui.theme.ClickBehaviorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClickBehaviorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GeneralScreen()
                }
            }
        }
    }
}

@Composable
fun GeneralScreen() {
    var result by remember { mutableStateOf(1) }
    val squeezeCount = (2..4).random()
    var numClick = 0
    val lemonImage = when(result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val notificationText = when(result) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon_squeeze
        3 -> R.string.lemon_drink
        else -> R.string.lemon_restart
    }
    val descText = when(result) {
        1 -> R.string.lemon_tree_desc
        2 -> R.string.lemon_squeeze_desc
        3 -> R.string.lemon_drink_desc
        else -> R.string.lemon_restart_desc
    }
    
    Column(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = notificationText),
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            border = BorderStroke(5.dp, Color(red = 105, green = 205, blue = 216)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
            onClick = {
                when(result) {
                    2 -> {
                        if(numClick < squeezeCount) {
                            numClick++
                        }
                        else result++
                    }
                    4 -> result = 1
                    else -> result++
                }
            }
        ) {
            Image(
                painter = painterResource(id = lemonImage),
                contentDescription = stringResource(id = descText)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickBehaviorTheme {
        GeneralScreen()
    }
}