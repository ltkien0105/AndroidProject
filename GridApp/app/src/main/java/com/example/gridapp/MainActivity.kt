package com.example.gridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gridapp.data.DataSource
import com.example.gridapp.model.Topic
import com.example.gridapp.ui.theme.GridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GridAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GridList(topics = DataSource.topics)
                }
            }
        }
    }
}

@Composable
fun GridCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(
        elevation = 10.dp
    ) {
        Row(
            modifier = Modifier
                .height(68.dp)
        ) {
            Image(
                painter = painterResource(id = topic.imageResource),
                contentDescription = stringResource(id = topic.stringResource),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(68.dp)
            )

            Column(
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        bottom = 8.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = stringResource(id = topic.stringResource),
                    maxLines = 1,
                    fontSize = 13.sp
                )

                Row(
                    modifier = Modifier
                        .padding(
                            top = 8.dp
                        )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
                        modifier = Modifier
                            .padding(
                                end = 8.dp
                            )
                    )
                    Text(
                        text = topic.courseNumber.toString(),
                        textAlign = TextAlign.Center,
                        fontSize = 11.sp
                    )
                }
            }
        }
    } 
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(topics: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(topics.size) {
                    index -> GridCard(topic = topics[index])
            }
        },
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GridAppTheme {
        GridList(topics = DataSource.topics)
    }
}