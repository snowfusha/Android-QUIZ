import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class FirstLayoutActivity : AppCompatActivity() {

    private lateinit var recipientNumber: EditText
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_layout)

        recipientNumber = findViewById(R.id.recipientNumber)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        sendButton.setOnClickListener {
            onSendButtonClick()
        }
    }

    private fun setContentView(activityFirstLayout: Any) {

    }

    private fun onSendButtonClick() {
        val recipient = recipientNumber.text.toString()
        val message = messageInput.text.toString()


        if (recipient.isEmpty() || !recipient.matches(Regex("\\d+"))) {
            Toast.makeText(this, "Recipient's number must contain only numbers", Toast.LENGTH_SHORT).show()
            return
        }


        if (message.length > 250) {
            Toast.makeText(this, "Message cannot exceed 250 characters", Toast.LENGTH_SHORT).show()
            return
        }


        val intent = Intent(this, SecondLayoutActivity::class.java).apply {
            putExtra("recipientNumber", recipient)
            putExtra("message", message)
        }
        startActivity(intent)
    }
}
