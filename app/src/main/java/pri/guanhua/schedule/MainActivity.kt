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
    private val addFragment = AddFragment()
    private lateinit var textViewOldColor : ColorStateList
    private lateinit var textViewLabel : TextView
    private lateinit var textViewSchedule : TextView
    private lateinit var textViewAdd : TextView
    private lateinit var addLabel : ImageButton
    private lateinit var mySchedule : ImageButton
    private lateinit var addMemorandum : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(R.id.fragment_container_view, addFragment)
            }
        }
        initView()
        label()
        schedule()
        add()
    }

    private fun initView(){

        addLabel = findViewById(R.id.add_label)
        mySchedule = findViewById(R.id.my_schedule)
        addMemorandum = findViewById(R.id.add_plan)
        textViewLabel = findViewById(R.id.text_label)
        textViewSchedule = findViewById(R.id.text_schedule)
        textViewAdd = findViewById(R.id.text_add)
        textViewOldColor = textViewLabel.textColors

    }

    private fun label(){

        addLabel.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, labelFragment)
            }
            addLabel.setBackgroundResource(R.drawable.image_label_selected)
            textViewLabel.setTextColor(Color.parseColor("#FF1493"))

            addMemorandum.setBackgroundResource(R.drawable.image_add)
            textViewAdd.setTextColor(textViewOldColor)

            mySchedule.setBackgroundResource(R.drawable.image_schedule)
            textViewSchedule.setTextColor(textViewOldColor)
        }

    }

    private fun schedule(){

        mySchedule.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, homeFragment)
            }
            mySchedule.setBackgroundResource(R.drawable.image_schedule_selected)
            textViewSchedule.setTextColor(Color.parseColor("#FF1493"))

            addLabel.setBackgroundResource(R.drawable.image_label)
            textViewLabel.setTextColor(textViewOldColor)

            addMemorandum.setBackgroundResource(R.drawable.image_add)
            textViewAdd.setTextColor(textViewOldColor)

        }

    }

    private fun add(){

        addMemorandum.setOnClickListener {

            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, addFragment)
            }
            addMemorandum.setBackgroundResource(R.drawable.image_add_selected)
            textViewAdd.setTextColor(Color.parseColor("#FF1493"))

            mySchedule.setBackgroundResource(R.drawable.image_schedule)
            textViewSchedule.setTextColor(textViewOldColor)

            addLabel.setBackgroundResource(R.drawable.image_label)
            textViewLabel.setTextColor(textViewOldColor)

        }

    }

    private fun dp2px(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(),
            resources.displayMetrics
        ).toInt()
    }

}