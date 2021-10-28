package pri.guanhua.schedule

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import android.util.TypedValue
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val labelFragment = LabelFragment()
    private lateinit var textViewOldColor : ColorStateList
    private lateinit var textViewLabel : TextView
    private lateinit var textViewSchedule : TextView
    private lateinit var textViewAdd : TextView
    private lateinit var addLabel : ImageButton
    private lateinit var mySchedule : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, homeFragment)
            }
        }
        initView()
        label()
        schedule()
    }

    private fun initView(){

        addLabel = findViewById(R.id.add_label)
        mySchedule = findViewById(R.id.my_schedule)
        textViewLabel = findViewById(R.id.text_label)
        textViewSchedule = findViewById(R.id.text_schedule)
        textViewAdd = findViewById(R.id.text_add)
        textViewOldColor = textViewAdd.textColors

    }

    private fun label(){

        addLabel.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, labelFragment)
            }
            mySchedule.setBackgroundResource(R.drawable.image_schedule)
            textViewSchedule.setTextColor(textViewOldColor)
            addLabel.setBackgroundResource(R.drawable.image_label_selected)
            textViewLabel.setTextColor(Color.parseColor("#FF1493"))
        }

    }

    private fun schedule(){

        mySchedule.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, homeFragment)
            }
            mySchedule.setBackgroundResource(R.drawable.image_schedule_selected)
            addLabel.setBackgroundResource(R.drawable.image_label)
            textViewLabel.setTextColor(textViewOldColor)
            textViewSchedule.setTextColor(Color.parseColor("#FF1493"))
        }

    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

}