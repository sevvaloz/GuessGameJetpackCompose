package com.example.guessthenumbergamecompose.ui.view

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guessthenumbergamecompose.ui.theme.Gray
import com.example.guessthenumbergamecompose.ui.theme.Purple
import com.example.guessthenumbergamecompose.ui.theme.RemainingClaimColor
import com.example.guessthenumbergamecompose.ui.theme.SurfaceColor
import com.example.guessthenumbergamecompose.ui.theme.UpColor
import com.example.guessthenumbergamecompose.ui.theme.White
import kotlin.random.Random

@Composable
fun GamePage(navController: NavController) {
    val tfText = remember { mutableStateOf("") }
    val randomNumber = remember { mutableIntStateOf(0) }
    val remainingClaim = remember { mutableIntStateOf(5) }
    val hint = remember { mutableStateOf("") }
    val isGuessTrue = remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        randomNumber.intValue = Random.nextInt(101)
        Log.d("TAG","Random Number: ${randomNumber.intValue}")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Gray,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Remaining Claim: ")
            }
            withStyle(
                SpanStyle(
                    color = RemainingClaimColor,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(remainingClaim.intValue.toString())
            }
        })

        Text(text = buildAnnotatedString {
            withStyle(
                SpanStyle(
                    color = Gray,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append("Hint: ")
            }
            withStyle(
                SpanStyle(
                    color = UpColor,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(hint.value)
            }
        })

        OutlinedTextField(
            value = tfText.value,
            onValueChange = { tfText.value = it },
            label = { Text(text = "Estimated number", fontSize = 15.sp) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Purple,
                focusedLabelColor = Purple,
                cursorColor = Purple,
                focusedContainerColor = SurfaceColor,
                unfocusedContainerColor = SurfaceColor,
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Button(
            modifier = Modifier.size(200.dp, 60.dp),
            onClick = {

                val estimatedNumber = tfText.value.toInt()
                tfText.value = ""

                if(estimatedNumber > randomNumber.intValue) {
                    hint.value = "Down"
                } else if(estimatedNumber < randomNumber.intValue) {
                    hint.value = "Up"
                }

                if(estimatedNumber == randomNumber.intValue) {
                    isGuessTrue.value = true
                }

                if(remainingClaim.intValue > 0) {

                    remainingClaim.intValue -= 1

                    if(isGuessTrue.value) {
                        navController.navigate("resultPage/true/${randomNumber.intValue}") {
                            popUpTo("gamePage") { inclusive = true }
                        }
                    }

                    if(isGuessTrue.value.not() && remainingClaim.intValue == 0) {
                        navController.navigate("resultPage/false/${randomNumber.intValue}") {
                            popUpTo("gamePage") { inclusive = true }
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple,
                contentColor = White
            )
        ) {
            Text(text = "Guess", fontSize = 18.sp)
        }
    }
}