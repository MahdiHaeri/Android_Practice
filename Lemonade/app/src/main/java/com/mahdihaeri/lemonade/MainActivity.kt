package com.mahdihaeri.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mahdihaeri.lemonade.ui.theme.LemonadeTheme
import org.intellij.lang.annotations.PrintFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onImageClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
    ) {
        Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) { Image(painter = painterResource(id = drawableResourceId), contentDescription = stringResource(id = contentDescriptionResourceId))
            Text(text = stringResource(id = textLabelResourceId), fontSize = 18.sp, fontStyle = FontStyle.Italic, color = Color.White)
        }
    }
}


@Composable
fun LemonApp() {
    // A surface container using the 'background' color from the theme
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        when (currentStep) {
            1 -> LemonTextAndImage(
                textLabelResourceId = R.string.lemon_tree_text,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.lemon_tree,
                onImageClick = {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                })

            2 -> LemonTextAndImage(
                textLabelResourceId = R.string.lemon_squeeze_text,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.lemon,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                })

            3 -> LemonTextAndImage(
                textLabelResourceId = R.string.lemon_drink_text,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.lemon_glass,
                onImageClick = {
                    currentStep = 4
                })

            4 -> LemonTextAndImage(
                textLabelResourceId = R.string.lemon_empty_glass_text,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.lemon_empty_glass,
                onImageClick = {
                    currentStep = 1
                })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}