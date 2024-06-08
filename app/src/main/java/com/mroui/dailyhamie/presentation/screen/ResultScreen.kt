package com.mroui.dailyhamie.presentation.screen

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mroui.dailyhamie.R
import com.mroui.dailyhamie.data.determineResult
import com.mroui.dailyhamie.presentation.component.QuizContent
import com.mroui.dailyhamie.presentation.model.HamsterActivity
import com.mroui.dailyhamie.presentation.model.HamsterMood
import com.mroui.dailyhamie.presentation.model.QuestionType
import com.mroui.dailyhamie.presentation.model.Screen

@Composable
internal fun ResultScreen(
    navController: NavController,
    quizResult: MutableMap<QuestionType, String> = mutableMapOf()
) {

    var expanded by remember { mutableStateOf(false) }
    val hamsterResult = determineResult(
        HamsterMood.entries.first { it.label == quizResult[QuestionType.MOOD] },
        HamsterActivity.entries.first { it.label == quizResult[QuestionType.ACTIVITY] },
    )

    QuizContent {
        Surface(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .animateContentSize(spring(Spring.DampingRatioMediumBouncy))
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    expanded = true
                }
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "You are...",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .weight(1f),
                        textAlign = TextAlign.Center
                    )
                    (if (expanded) null else Icons.Default.KeyboardArrowDown)?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = if (expanded) "Collapse" else "Expand",
                            tint = Color.Gray
                        )
                    }
                }
                if (expanded) {
                    Image(
                        painter = painterResource(id = R.drawable.hamster_image),
                        contentDescription = "Hamster image",
                        modifier = Modifier.padding(vertical = 16.dp)
                    )
                    Text(
                        text = "a $hamsterResult!",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    )
                    Button(
                        onClick = {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Result.route) { inclusive = true }
                            }
                        },
                        modifier = Modifier
                            .width(200.dp),
                        shape = MaterialTheme.shapes.extraSmall,
                    ) {
                        Text(text = "Replay Quiz")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun ResultScreenPreview() {
    val navController = rememberNavController()
    ResultScreen(navController)
}
