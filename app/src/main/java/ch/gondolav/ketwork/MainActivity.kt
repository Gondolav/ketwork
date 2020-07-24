package ch.gondolav.ketwork

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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