package pri.guanhua.schedule.view

import android.os.Bundle
import android.view.View
import android.widget.NumberPicker
import androidx.fragment.app.Fragment
import pri.guanhua.schedule.R
import pri.guanhua.schedule.database.Plan
import pri.guanhua.schedule.utils.GetDatabaseUtils

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var timeHour: NumberPicker
    private lateinit var timeMin: NumberPicker

    private lateinit var timeMon: NumberPicker
    private lateinit var timeDay: NumberPicker
    private lateinit var timeYear: NumberPicker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        timePicker(view)
    }

    private fun timePicker(view: View) {
        val incTime: View = view.findViewById(R.id.inc_time)
        timeHour = incTime.findViewById(R.id.edit_hour)
        timeHour.maxValue = 24
        timeHour.minValue = 1

        timeMin = incTime.findViewById(R.id.edit_min)
        timeMin.maxValue = 60
        timeMin.minValue = 1

        timeMon = incTime.findViewById(R.id.edit_mon)
        timeMon.maxValue = 12
        timeMon.minValue = 1

        timeDay = incTime.findViewById(R.id.edit_day)
        timeDay.maxValue = 30
        timeDay.minValue = 1

        timeYear = incTime.findViewById(R.id.edit_year)
        timeYear.maxValue = 2099
        timeYear.minValue = 2021

        var data = activity?.let { GetDatabaseUtils.get(it) }
        var plan0 = Plan(0, "3", "2")
        var plan1 = Plan(0, "11", "22")
        data?.planDao()?.insertAll(plan0, plan1)

        var plan = data?.planDao()?.getAll()?.get(1)
        println("       jfowefjwof:::::::::::::::"+plan?.pid)
    }

}