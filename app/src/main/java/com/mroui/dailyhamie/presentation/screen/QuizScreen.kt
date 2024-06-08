package com.mroui.dailyhamie.presentation.screen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mroui.dailyhamie.data.QUESTIONS_DATA_SET
import com.mroui.dailyhamie.presentation.component.QuizContent
import com.mroui.dailyhamie.presentation.model.QuestionType
import com.mroui.dailyhamie.presentation.model.Screen

@Composable
internal fun QuizScreen(
    navController: NavController,
    quizResult: MutableMap<QuestionType, String> = mutableMapOf()
) {
    var questionIndex by remember { mutableIntStateOf(0) }
    val currentQuestion = QUESTIONS_DATA_SET[questionIndex]

    val progress by animateFloatAsState(
        targetValue = (questionIndex + 1) / QUESTIONS_DATA_SET.size.toFloat()
    )

    QuizContent {
        Text(
            text = "${questionIndex + 1} of ${QUESTIONS_DATA_SET.size}",
            style = MaterialTheme.typography.labelLarge,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
        )
        Text(
            text = currentQuestion.text,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        currentQuestion.answers.forEach { answer ->

            Button(
                onClick = {
                    quizResult[currentQuestion.type] = answer
                    if (questionIndex < QUESTIONS_DATA_SET.size - 1) {
                        questionIndex++
                    } else {
                        navController.navigate(Screen.Result.route) {
                            popUpTo(Screen.Quiz.route) { inclusive = true }
                        }
                    }
                },
                shape = MaterialTheme.shapes.extraSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.labelLarge,
                    text = answer
                )
            }
        }
    }
}

@Preview
@Composable
private fun QuizScreenPreview() {
    val navController = rememberNavController()
    QuizScreen(navController)
}
