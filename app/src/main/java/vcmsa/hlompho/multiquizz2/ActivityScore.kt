package vcmsa.hlompho.multiquizz2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //code starts here
        val score = intent.getIntExtra("score", 0)
        val scoreMessage = findViewById<TextView>(R.id.scoreMessage)
        val reviewButton = findViewById<Button>(R.id.reviewButton)
        val exitButton = findViewById<Button>(R.id.exitButton)

        scoreMessage.text = "Your score: $score"

        reviewButton.setOnClickListener {
            // You could show correct answers here or navigate to a review screen
            Toast.makeText(this, "Feature not implemented yet!", Toast.LENGTH_SHORT).show()
        }

        exitButton.setOnClickListener {
            finish() // This will close the current activity and return to the previous one
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            //code ends here
        }
    }
}
