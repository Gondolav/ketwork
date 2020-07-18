package ch.gondolav.ketwork

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        runOnConnection {
            off {
                textView.text = "Offline"
            }

            on {
                textView.text = "Online"
            }
        }

        runIfConnected {
            textView.text = "Online"
        }

        runIfDisconnected {
            textView.text = "Offline"
        }
    }
}