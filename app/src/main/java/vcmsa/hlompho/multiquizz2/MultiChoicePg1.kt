package vcmsa.hlompho.multiquizz2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MultiChoicePg1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_multi_choice_pg1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code here


        class QuizActivity : AppCompatActivity() {
// I used Hlompho xolo knowledge to help me with this code
            //Used Mr els's repo for some of the code
            //The link : https://chatgpt/multiQuizz.com/hlompho/
            val questions = arrayOf(
                "Nelson Mandela was the president in 1994",
                "World War II ended in 1945",
                "The Great Wall of China is in India",
                "The Eiffel Tower is located in Paris",
                "The Mona Lisa was painted by Leonardo da Vinci"
            )
// I used chatgpt and gemini to help me  with this code
            val answers = arrayOf(
                true, false, false, true, true
            )
            private var currentQuestionIndex = 0
            private var score = 0

            private lateinit var questionText: TextView
            private lateinit var feedbackText: TextView
            private lateinit var trueButton: Button
            private lateinit var falseButton: Button
            private lateinit var nextButton: Button

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_multi_choice_pg1) // Sets the layout for QuizActivity

                // Find UI elements by their IDs from activity_quiz.xml
                questionText = findViewById(R.id.questionText)
                feedbackText = findViewById(R.id.feedbackText)
                trueButton = findViewById(R.id.trueButton)
                falseButton = findViewById(R.id.falseButton)
                nextButton = findViewById(R.id.nextButton)

                loadQuestion()

                trueButton.setOnClickListener { checkAnswer(true) }
                falseButton.setOnClickListener { checkAnswer(false) }
                nextButton.setOnClickListener {
                    currentQuestionIndex++
                    if (currentQuestionIndex < questions.size) {
                        loadQuestion()
                    } else {
                        // Start ResultActivity when the quiz is finished
                        val resultIntent = Intent(this@QuizActivity, Activity_score::class.java) // Make sure ResultActivity exists and is in AndroidManifest
                        resultIntent.putExtra("score", score)
                        startActivity(resultIntent)
                        finish() // Finish the QuizActivity so it's not on the back stack
                    }
                }
            }

            private fun loadQuestion() {
                if (currentQuestionIndex < questions.size) { // Added a check to prevent index out of bounds
                    questionText.text = questions[currentQuestionIndex]
                    feedbackText.text = ""
                    nextButton.visibility = View.GONE
                    trueButton.isEnabled = true
                    falseButton.isEnabled = true
                } else {
                    // This else block is more for safety and logging in this context,
                    // as the check in the nextButton click listener should prevent
                    // calling loadQuestion when there are no more questions.
                }
            }

            private fun checkAnswer(userAnswer: Boolean) {
                val correctAnswer = answers[currentQuestionIndex]
                if (userAnswer == correctAnswer) {
                    feedbackText.text = "Correct!"
                    score++
                } else {
                    feedbackText.text = "Incorrect!"
                }
                trueButton.isEnabled = false
                falseButton.isEnabled = false
                nextButton.visibility = View.VISIBLE
// This is where I ended up using both chatgpt and gemini for this code


                //code ends here
            }
        }
    }
}
