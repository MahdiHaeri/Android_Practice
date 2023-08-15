package com.mahdihaeri.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdihaeri.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingPreview()
                }
            }
        }
    }
}


@Composable
fun BusinessCard(name: String, job: String, phoneNumber: String, username: String, email: String, modifier: Modifier) {
    Surface(){
        Box(
            modifier = modifier.fillMaxSize(),
        ) {
            UserInformationBlock(name = name, job = job)
            ContactInformationBlock(
                phoneNumber = phoneNumber,
                username = username,
                email = email,
                modifier = modifier
            )
        }
    }
}

@Composable
fun UserInformationBlock(name: String, job: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(color = Color.DarkGray) {
            Image(
                painter = image, contentDescription = null,
                Modifier.size(150.dp, 150.dp),
            )
        }
        Text(
            text = name,
            textAlign = TextAlign.Center,
            fontSize = 80.sp,
            fontFamily = FontFamily.Cursive,
            lineHeight = 100.sp,
        )
        Text(
            text = job,
            textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            fontSize = 30.sp
        )
    }
}

@Composable
fun ContactInformationBlock(phoneNumber: String, username: String, email: String, modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row (
            horizontalArrangement = Arrangement.Center
        )
        {
            Text(
                text = phoneNumber,
                textAlign = TextAlign.Center
            )
        }
        Row (
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = username,
                textAlign = TextAlign.Center
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = email,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCard(
            name = "Mohammad Mahdi",
            job = "Computer Engineering Student",
            phoneNumber =" 09960928404",
            username = "@MahdiHaeri",
            email = "mahdihaerim@gmail.com",
            modifier = Modifier
        )
    }
}