package com.example.assignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment2.ui.theme.Assignment2Theme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment as ComposeAlignment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Assignment2Theme {
                FizzBuzz()
            }
        }
    }
}

// takes in an integer and returns the correct fizzbuzz label
fun determine_fizz_buzz(counter: Int): String {
    if (counter % 15 == 0) {
        return "FizzBuzz"
    } else if (counter % 3 == 0) {
        return "Fizz"
    } else if (counter % 5 == 0) {
        return "Buzz"
    } else {
        return counter.toString()
    }
}

// the fizzbuzz composable with a counter state and interactables
@Composable
fun FizzBuzz() {
    var counter by remember { mutableStateOf(1) }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = ComposeAlignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "FizzBuzz Simulator",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = determine_fizz_buzz(counter),
            fontSize = 48.sp,
            modifier = Modifier.padding(16.dp)
        )
        Interactable("Next", { counter++ })
        Interactable("Reset", { counter = 1 })
    }
}

// stateless composable that tells the parent composable if the state has changed
@Composable
fun Interactable(text: String, callback: () -> Unit) {
    Button (
        onClick = callback
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Assignment2Theme {
        FizzBuzz()
    }
}