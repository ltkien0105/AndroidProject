package com.example.artspaceapp

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Column(
        modifier = Modifier
            .padding(30.dp)
    ){
        ArtworkWall(
            image = R.drawable.yasuo,
            modifier = Modifier
                .align(alignment = CenterHorizontally)

        )
        ArtworkDescription(
            charName = "Aerith",
            nameGame = "Final Fantasy VII (2020)",
            modifier = Modifier
                .align(alignment = CenterHorizontally)

        )
        DisplayController(
            modifier = Modifier
                .align(alignment = CenterHorizontally)

        )
    }
}

@Composable
fun ArtworkWall(image: Int, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .border(width = 2.dp, color = Color.DarkGray, shape = RectangleShape),
        elevation = 10.dp
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier.padding(20.dp)
        )
    }
}

@Composable
fun ArtworkDescription(charName: String, nameGame: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(20.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = charName,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = nameGame,
            fontSize = 15.sp
        )
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(120.dp)
        ) {
            Text(
                text = stringResource(id = R.string.btn_previous)
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(120.dp)
        ) {
            Text(
                text = stringResource(id = R.string.btn_next)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}