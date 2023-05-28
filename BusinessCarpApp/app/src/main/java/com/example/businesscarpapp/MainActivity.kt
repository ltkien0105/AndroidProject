package com.example.businesscarpapp

import android.media.Image
import android.media.tv.TvContract.Channels.Logo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscarpapp.ui.theme.BusinessCarpAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCarpAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun LogoNameAndTitle(logo: Painter, fullName: String, title: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = logo,
            contentDescription = null,
            modifier = Modifier
                .height(70.dp)
                .width(60.dp),
        )

        Text(
            text = fullName,
            color = Color.White,
            fontSize = 35.sp,
            fontWeight = FontWeight(350)
        )

        Text(
            text = title,
            color = colorResource(R.color.title_color),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactInformation(phoneNumber: String, shareString: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Divider(color = Color.LightGray, thickness = 2.dp)
        Row(modifier = Modifier
            .padding(32.dp, 5.dp)) {
            Icon(
                Icons.Rounded.Call,
                tint = colorResource(id = R.color.title_color),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = phoneNumber,
                color = Color.White
            )
        }
        Divider(color = Color.LightGray, thickness = 2.dp)
        Row(modifier = Modifier
            .padding(32.dp, 5.dp)) {
            Icon(
                Icons.Rounded.Share,
                tint = colorResource(id = R.color.title_color),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = shareString,
                color = Color.White
            )
        }
        Divider(color = Color.LightGray, thickness = 2.dp)
        Row(modifier = Modifier
            .padding(start = 32.dp,end = 32.dp,top = 5.dp)) {
            Icon(
                Icons.Rounded.Email,
                tint = colorResource(id = R.color.title_color),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = email,
                color = Color.White
            )
        }
    }
}

@Composable
fun BusinessCard(){
    Column(modifier = Modifier.background(colorResource(id = R.color.background_color))) {
        LogoNameAndTitle(
            logo = painterResource(id = R.drawable.android_logo),
            fullName = "Le Trung Kien",
            title = "An Android Developer",
            modifier = Modifier.weight(3f)
        )

        ContactInformation(
            phoneNumber = "(+84) 345542148",
            shareString = "@TK15",
            email = "kienle.ag@gmail.com",
            modifier = Modifier.weight(1f)
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCarpAppTheme {
        BusinessCard()
    }
}