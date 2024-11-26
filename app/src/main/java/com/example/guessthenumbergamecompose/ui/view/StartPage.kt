package com.example.guessthenumbergamecompose.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.guessthenumbergamecompose.R
import com.example.guessthenumbergamecompose.ui.theme.Gray
import com.example.guessthenumbergamecompose.ui.theme.Purple
import com.example.guessthenumbergamecompose.ui.theme.White

@Composable
fun StartPage(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.wrapContentSize(),
            text = "Guess The Number Game",
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Gray
        )

        Image(
            painter = painterResource(id = R.drawable.game_dice),
            contentDescription = ""
        )
        Button(
            modifier = Modifier.size(200.dp, 60.dp),
            onClick = { navController.navigate("gamePage") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple,
                contentColor = White
            )
        ) {
            Text(text = "Start", fontSize = 18.sp)
        }
    }
}