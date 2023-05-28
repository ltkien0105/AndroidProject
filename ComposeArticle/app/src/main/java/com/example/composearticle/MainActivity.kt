package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArticleContent(
                        stringResource(R.string.text_summarize),
                        stringResource(R.string.text_introduction),
                        stringResource(R.string.text_description)
                    )
                }
            }
        }
    }
}
@Composable
fun ArticleDescription(textSum: String, textIntro: String, textDesc: String) {
    Column {
        Text(
            text = textSum,
            fontSize = 24.sp,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 16.dp
            )
        )

        Text(
            text = textIntro,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
                .wrapContentWidth(Alignment.CenterHorizontally),
            textAlign = TextAlign.Justify
        )

        Text(
            text = textDesc,
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
                .wrapContentWidth(Alignment.CenterHorizontally),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun ArticleContent(textSum: String, textIntro: String, textDesc: String) {
    val articleImage = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = articleImage,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        ArticleDescription(
            textSum = textSum,
            textIntro = textIntro,
            textDesc = textDesc
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeArticleTheme {
        ArticleContent(
            stringResource(R.string.text_summarize),
            stringResource(R.string.text_introduction),
            stringResource(R.string.text_description)
        )
    }
}