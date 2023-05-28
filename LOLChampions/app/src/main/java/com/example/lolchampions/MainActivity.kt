package com.example.lolchampions

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lolchampions.ui.theme.LOLChampionsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LOLChampionsTheme {
                LOLChampionsApp()
            }
        }
    }
}

@Composable
fun LOLChampionsApp() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar()
        }
    ) {
        ChampCardList(champInfoList = champInfoList)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ChampCardList(champInfoList: List<ChampInfo>) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy
            )
        ),
        exit = fadeOut()
    ) {
        LazyColumn {
            itemsIndexed(champInfoList) { index, champInfo ->
                ChampCard(
                    champInfo = champInfo,
                    modifier = Modifier
                        .padding(horizontal = 8.dp, vertical = 8.dp)
                        .animateEnterExit(
                        enter = slideInVertically(
                            animationSpec = spring(
                                stiffness = Spring.StiffnessVeryLow,
                                dampingRatio = Spring.DampingRatioNoBouncy
                            ),
                            initialOffsetY = { it + (index + 2) }// staggered entrance
                        )
                    )
                )
            }
        }
    }
}

@Composable
fun ChampCard(champInfo: ChampInfo, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if(expanded) Color.LightGray else MaterialTheme.colors.surface
    )

    Card(
        modifier = modifier,
        elevation = 4.dp,
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = 72.dp)
                    .padding(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(id = champInfo.champName),
                        style = MaterialTheme.typography.h1
                    )
                    Text(
                        text = stringResource(id = R.string.role, stringResource(id = champInfo.role)),
                        style = MaterialTheme.typography.h2
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .size(100.dp)
                ) {
                    Image(
                        painter = painterResource(id = champInfo.champImg),
                        contentDescription = stringResource(id = R.string.expand_image),
                        modifier = Modifier
                            .clickable {
                                expanded = !expanded
                            }
                            .fillMaxSize(),
                        alignment = Alignment.Center,
                        contentScale = ContentScale.FillHeight
                    )
                }
            }
            if(expanded) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = stringResource(id = champInfo.summarization),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.lol_icon),
            contentDescription = null,
            modifier = Modifier
                .size(25.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = stringResource(id = R.string.title),
            style = MaterialTheme.typography.h1,
            fontSize = 20.sp,
            color = MaterialTheme.colors.onPrimary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LOLChampionsTheme {
        LOLChampionsApp()
    }
}
