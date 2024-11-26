package com.example.guessthenumbergamecompose.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.guessthenumbergamecompose.ui.theme.GuessTheNumberGameComposeTheme
import com.example.guessthenumbergamecompose.ui.theme.SurfaceColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuessTheNumberGameComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = SurfaceColor) {
                    Navigator()
                }
            }
        }
    }
}

@Composable
fun Navigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "startPage") {
        composable("startPage") {
            StartPage(navController = navController)
        }
        composable("gamePage") {
            GamePage(navController = navController)
        }
        composable(
            "resultPage/{IS_WON}/{GUESS_NUMBER}",
            arguments = listOf(
                navArgument("IS_WON") { type = NavType.BoolType },
                navArgument("GUESS_NUMBER") { type = NavType.IntType }
            )
        ) {
            val isWon = it.arguments?.getBoolean("IS_WON")!!
            val guessNumber = it.arguments?.getInt("GUESS_NUMBER")!!
            ResultPage(isWon, guessNumber)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GuessTheNumberGameComposeTheme {
        Navigator()
    }
}