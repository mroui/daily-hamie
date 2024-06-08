package com.mroui.dailyhamie.presentation.model

internal open class Question(
    val text: String,
    val answers: List<String>,
    val type: QuestionType
)

internal enum class QuestionType {
    MOOD,
    ACTIVITY,
    COLOR
}

internal enum class HamsterMood(val label: String) {
    HAPPY("Happy"),
    SAD("Sad"),
    ANGRY("Angry"),
    EXCITED("Excited")
}

internal enum class HamsterActivity(val label: String) {
    RUNNING("Run"),
    SLEEPING("Sleep"),
    EATING("Eat"),
    PLAYING("Play")
}
