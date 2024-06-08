package com.mroui.dailyhamie.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mroui.dailyhamie.presentation.model.QuestionType
import com.mroui.dailyhamie.presentation.model.Screen
import com.mroui.dailyhamie.presentation.screen.HomeScreen
import com.mroui.dailyhamie.presentation.screen.QuizScreen
import com.mroui.dailyhamie.presentation.screen.ResultScreen

@Composable
fun DailyHamieNavigation() {
    val navController = rememberNavController()
    val quizResult: MutableMap<QuestionType, String> = remember { mutableMapOf() }
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Quiz.route) { QuizScreen(navController, quizResult) }
        composable(Screen.Result.route) { ResultScreen(navController, quizResult) }
    }
}
