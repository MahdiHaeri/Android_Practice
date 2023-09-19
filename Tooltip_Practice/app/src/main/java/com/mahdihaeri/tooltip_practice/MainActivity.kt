@file:OptIn(ExperimentalMaterial3Api::class)

package com.mahdihaeri.tooltip_practice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.RichTooltipBox
import androidx.compose.material3.RichTooltipState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mahdihaeri.tooltip_practice.ui.theme.Tooltip_PracticeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tooltip_PracticeTheme {
                Main()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    modifier: Modifier = Modifier
) {
    val plainTooltipState = PlainTooltipState()
    val richTooltipState = RichTooltipState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            PlainTooltipBox(
                modifier = Modifier,
                tooltipState = plainTooltipState,
                containerColor = Color.Black,
                contentColor = Color.White,
                tooltip = {
                    Text(
                        text = "tooltip = Tooltip for first button"
                    )
                },
            ) {
                Icon(
                    modifier = modifier.tooltipAnchor(),
                    imageVector = Icons.Default.Share,
                    contentDescription = "share_icon"
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                modifier = Modifier,
                onClick = {
                    scope.launch {
                        plainTooltipState.show()
                    }
                }
            ) {
                Text(text = "PlainTooltipBox")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            RichTooltipBox(
                modifier = Modifier,
                tooltipState = richTooltipState,
                text = {
                    Text(text = "text = Tooltip for second button")
                },
                title = {
                    Text(text = "title = This is a title for RichTooltipBox")
                },
                action = {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Action")
                    }
                }
            ) {
                Icon(
                    modifier = modifier.tooltipAnchor(),
                    imageVector = Icons.Default.Share,
                    contentDescription = "share_icon"
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            Button(
                modifier = Modifier,
                onClick = {
                    scope.launch {
                        richTooltipState.show()
                    }
                }
            ) {
                Text(text = "RichTooltipBox")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    Tooltip_PracticeTheme {
        Main()
    }
}