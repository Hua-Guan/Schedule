package pri.guanhua.schedule.view

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import pri.guanhua.schedule.R
import pri.guanhua.schedule.database.Plan
import pri.guanhua.schedule.utils.GetDatabaseUtils

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var time: TextView

    private lateinit var textViewOldColor : ColorStateList
    private lateinit var timeDate: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timePicker(view)
    }

    private fun timePicker(view: View) {
        val incTime: View = view.findViewById(R.id.inc_time)

        time = incTime.findViewById(R.id.edit_time)
        time.setOnClickListener {
            time.setBackgroundResource(R.drawable.rectangle_corner_red)
            time.setTextColor(Color.parseColor("#E91E63"))
            TimePickerFragment().show(parentFragmentManager, "timePicker")
        }

        timeDate = incTime.findViewById(R.id.edit_date)
        textViewOldColor = timeDate.textColors
        timeDate.setOnClickListener {
            timeDate.setBackgroundResource(R.drawable.rectangle_corner_red)
            timeDate.setTextColor(Color.parseColor("#E91E63"))
            val newFragment = DatePickerFragment()
            newFragment.show(parentFragmentManager, "datePicker")
        }

        var data = activity?.let { GetDatabaseUtils.get(it) }
        var plan0 = Plan(0, "3", "2")
        var plan1 = Plan(0, "11", "22")
        data?.planDao()?.insertAll(plan0, plan1)

        var plan = data?.planDao()?.getAll()
        println("       jfowefjwof:::::::::::::::"+plan?.size)
    }

}