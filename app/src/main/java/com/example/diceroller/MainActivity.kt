package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = "Dice Roller App") },
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(MaterialTheme.colorScheme.onSecondaryContainer)
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    DiceRollerApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRollerApp(modifier: Modifier = Modifier) {
    var counter by remember {
        mutableIntStateOf(value = 1)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {

        when (counter) {
            1 -> Dice(image = R.drawable.dice_1)
            2 -> Dice(image = R.drawable.dice_2)
            3 -> Dice(image = R.drawable.dice_3)
            4 -> Dice(image = R.drawable.dice_4)
            5 -> Dice(image = R.drawable.dice_5)
            else -> Dice(image = R.drawable.dice_6)
        }

        Button(onClick = {
            counter = (1..6).random()
        }) {
            Text(text = "Roll")
        }
    }
}

@Composable
fun Dice(image: Int) {
    Image(painter = painterResource(id = image), contentDescription = null)
}