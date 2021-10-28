package pri.guanhua.schedule

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<HomeFragment>(R.id.fragment_container_view)
            }
        }
        val addLabel = findViewById<ImageButton>(R.id.add_label)
        addLabel.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace<LabelFragment>(R.id.fragment_container_view)
            }
        }
    }
}