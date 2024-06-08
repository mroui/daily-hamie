package com.mroui.dailyhamie.data

import com.mroui.dailyhamie.presentation.model.HamsterActivity
import com.mroui.dailyhamie.presentation.model.HamsterMood
import com.mroui.dailyhamie.presentation.model.Question
import com.mroui.dailyhamie.presentation.model.QuestionType

internal val QUESTIONS_DATA_SET = listOf(
    Question(
        text = "What is your mood today?",
        answers = HamsterMood.entries.map { it.label },
        type = QuestionType.MOOD
    ),
    Question(
        text = "What would you like to do today?",
        answers = HamsterActivity.entries.map { it.label },
        type = QuestionType.ACTIVITY
    ),
    Question(
        text = "What is your favorite color?",
        answers = listOf("Red", "Blue", "Green", "Yellow"),
        type = QuestionType.COLOR
    )
)

internal fun determineResult(mood: HamsterMood, activity: HamsterActivity): String {
    return when {
        mood == HamsterMood.HAPPY && activity == HamsterActivity.RUNNING -> "Happy Hopper"
        mood == HamsterMood.HAPPY && activity == HamsterActivity.SLEEPING -> "Blissful Snoozer"
        mood == HamsterMood.HAPPY && activity == HamsterActivity.EATING -> "Cheerful Chewer"
        mood == HamsterMood.HAPPY && activity == HamsterActivity.PLAYING -> "Jolly Entertainer"

        mood == HamsterMood.SAD && activity == HamsterActivity.RUNNING -> "Tearful Runner"
        mood == HamsterMood.SAD && activity == HamsterActivity.SLEEPING -> "Sobbing Sleepwalker"
        mood == HamsterMood.SAD && activity == HamsterActivity.EATING -> "Weepy Snacker"
        mood == HamsterMood.SAD && activity == HamsterActivity.PLAYING -> "Melancholy Toyer"

        mood == HamsterMood.ANGRY && activity == HamsterActivity.RUNNING -> "Furious Flyer"
        mood == HamsterMood.ANGRY && activity == HamsterActivity.SLEEPING -> "Grumpy Sleeper"
        mood == HamsterMood.ANGRY && activity == HamsterActivity.EATING -> "Fuming Foodier"
        mood == HamsterMood.ANGRY && activity == HamsterActivity.PLAYING -> "Raging Racer"

        mood == HamsterMood.EXCITED && activity == HamsterActivity.RUNNING -> "Ecstatic Escaper"
        mood == HamsterMood.EXCITED && activity == HamsterActivity.SLEEPING -> "Snoozy Sprinter"
        mood == HamsterMood.EXCITED && activity == HamsterActivity.EATING -> "Energetic Eater"
        mood == HamsterMood.EXCITED && activity == HamsterActivity.PLAYING -> "Jumpy Juggler"
        else -> ""
    }
}
