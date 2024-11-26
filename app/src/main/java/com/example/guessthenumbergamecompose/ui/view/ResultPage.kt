package com.example.guessthenumbergamecompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.guessthenumbergamecompose.R
import com.example.guessthenumbergamecompose.ui.theme.Purple

@Composable
fun ResultPage(isWon: Boolean, guessNumber: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isWon) {
            Text(text = "You won!", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Purple)
            Image(
                painter = painterResource(id = R.drawable.winner_face),
                contentDescription = ""
            )
        } else {
            Text(text = "You lost!", fontSize = 50.sp, fontWeight = FontWeight.Bold, color = Purple)
            Text(text = "The number was $guessNumber", fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Purple)
            Image(
                painter = painterResource(id = R.drawable.loser_face),
                contentDescription = ""
            )
        }
    }
}