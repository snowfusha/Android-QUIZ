import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SecondLayoutActivity : AppCompatActivity() {

    private lateinit var recipientNumberDisplay: TextView
    private lateinit var messageDisplay: TextView
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_layout)

        recipientNumberDisplay = findViewById(R.id.recipientNumberDisplay)
        messageDisplay = findViewById(R.id.messageDisplay)
        clearButton = findViewById(R.id.clearButton)


        val recipientNumber = intent.getStringExtra("recipientNumber")
        val message = intent.getStringExtra("message")

        // Display the data
        recipientNumberDisplay.text = recipientNumber
        messageDisplay.text = message

        clearButton.setOnClickListener {
            onClearButtonClick()
        }
    }

    private fun onClearButtonClick() {
        recipientNumberDisplay.text = ""
        messageDisplay.text = ""

        finish()
    }
}
