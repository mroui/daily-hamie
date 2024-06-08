package com.mroui.dailyhamie.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mroui.dailyhamie.R
import com.mroui.dailyhamie.presentation.component.QuizContent
import com.mroui.dailyhamie.presentation.model.Screen

@Composable
internal fun HomeScreen(navController: NavController) {
    QuizContent {
        Image(
            painter = painterResource(id = R.drawable.hamster_image),
            contentDescription = "Hamster image",
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "What kind of hamster are you today?",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Take this quiz to find out!",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Button(
            onClick = {
                navController.navigate(Screen.Quiz.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            },
            modifier = Modifier
                .width(200.dp)
                .padding(bottom = 16.dp),
            shape = MaterialTheme.shapes.extraSmall,
        ) {
            Text(
                text = "Start Quiz",
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController)
}
