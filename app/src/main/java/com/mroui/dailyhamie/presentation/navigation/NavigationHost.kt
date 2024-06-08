package com.mroui.dailyhamie.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mroui.dailyhamie.presentation.component.AppLabel
import com.mroui.dailyhamie.presentation.model.QuestionType
import com.mroui.dailyhamie.presentation.model.Screen
import com.mroui.dailyhamie.presentation.screen.HomeScreen
import com.mroui.dailyhamie.presentation.screen.QuizScreen
import com.mroui.dailyhamie.presentation.screen.ResultScreen

@Composable
fun DailyHamieNavigation() {

    val navController = rememberNavController()
    val quizResult: MutableMap<QuestionType, String> = remember { mutableMapOf() }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            enterTransition = {
                //fadeIn(tween(700))
                //scaleIn(spring(Spring.DampingRatioLowBouncy))
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(500)
                )
            },
            exitTransition = {
                //fadeOut(tween(700))
                //scaleOut(spring(Spring.DampingRatioLowBouncy))
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start,
                    animationSpec = tween(500)
                )
            }
        ) {
            composable(route = Screen.Home.route) { HomeScreen(navController) }
            composable(Screen.Quiz.route) { QuizScreen(navController, quizResult) }
            composable(Screen.Result.route) { ResultScreen(navController, quizResult) }
        }
        AppLabel()
    }
}
