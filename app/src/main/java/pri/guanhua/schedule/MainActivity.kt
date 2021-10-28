package pri.guanhua.schedule

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.util.TypedValue




class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val labelFragment = LabelFragment()
    private var myScheduleSelected = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, homeFragment)
            }
        }
        val addLabel = findViewById<ImageButton>(R.id.add_label)
        val mySchedule = findViewById<ImageButton>(R.id.my_schedule)
        addLabel.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, labelFragment)
            }
            mySchedule.setBackgroundResource(R.drawable.image_schedule)
            addLabel.setBackgroundResource(R.drawable.image_label_selected)
        }

        mySchedule.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, homeFragment)
            }
            mySchedule.setBackgroundResource(R.drawable.image_schedule_selected)
            addLabel.setBackgroundResource(R.drawable.image_label)
        }
    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

}