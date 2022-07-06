package com.kiddo.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG,"ViewModel instance about to be destroyed")
    }
    private val questionBank = listOf(
        Question(R.string.question_australia, true, isCheat = false),
        Question(R.string.question_africa, true, isCheat = false),
        Question(R.string.question_americas,true, isCheat = false),
        Question(R.string.question_asia, true, isCheat = false),
        Question(R.string.question_oceans, true, isCheat = false)
    )

    var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    val currentQuestionIsCheat: Boolean
        get() = questionBank[currentIndex].isCheat

    fun moveToNext(){
       currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPre(){
        if(currentIndex == 0){
            currentIndex = questionBank.size - 1
        }else{
            currentIndex--
        }
    }

    fun checkCheater(){
        questionBank[currentIndex].isCheat = true
    }
}